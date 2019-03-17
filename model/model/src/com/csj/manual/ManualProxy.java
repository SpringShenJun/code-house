package com.csj.manual;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * custom Proxy
 */
public class ManualProxy {

    //换行
    private static final String LN = "\r\n";

    public static Object newProxyInstance(ManualClassLoader loader,
                                          Class<?>[] interfaces,
                                          ManualInvocationHandler h) throws Exception {

        try {


            //1.生成源代码
            String proxyCode = generateCode(interfaces);
            //2.将生成的源代码输出到磁盘，保存为.java文件
            String path = ManualProxy.class.getResource("").getPath();
            File file = new File(path + "$Proxy0.java");
            FileWriter fw = new FileWriter(file);
            fw.write(proxyCode);
            fw.flush();
            fw.close();
            //3.编译源代码，并且生成.class文件
            //java代理提供的
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable<? extends JavaFileObject> it = manager.getJavaFileObjects(file);

            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, it);
            task.call();
            manager.close();
//            file.delete();
            //4.将class文件中的内容，动态加载到jvm中来
            //5.返回被代理后的代理对象
            Class<?> proxyClass = loader.findClass("$Proxy0");
            Constructor<?> c = proxyClass.getConstructor(ManualInvocationHandler.class);
            file.delete();
            return c.newInstance(h);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    private static String generateCode(Class<?>[] interfaces) {

        StringBuffer sb = new StringBuffer();
        sb.append("package com.csj.manual;" + LN);
        sb.append("import java.lang.reflect.Proxy;" + LN);
        sb.append("import java.lang.reflect.Method;" + LN);
        sb.append("public final class $Proxy0 implements " + interfaces[0].getName() + " {" + LN);

        sb.append("ManualInvocationHandler h;" + LN);
        sb.append("public $Proxy0 (ManualInvocationHandler h) {" + LN);
        sb.append("this.h = h;" + LN);
        sb.append("}" + LN);
        for (Method m : interfaces[0].getMethods()) {
//            public final void findLove()为了简单，不做复杂的处理，只是为了生成findLove业务方法
            sb.append("public final " + m.getReturnType().getName() + " " + m.getName() + "(){");
            sb.append("try{" + LN);
            sb.append("Method m = " + interfaces[0].getName() + ".class.getMethod(\"" + m.getName() + "\",new Class[]{});" + LN);
            sb.append("this.h.invoke(this,m,null);" + LN);
            sb.append("}catch(Exception e){" + LN);
            sb.append("}" + LN);
        }
        sb.append("}}");

        return sb.toString();
    }
}
