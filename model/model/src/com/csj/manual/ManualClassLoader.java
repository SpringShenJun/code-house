package com.csj.manual;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * simple custom classLoader
 */
//代码生成，编译，重新动态load到jvm
public class ManualClassLoader extends ClassLoader{

    private File baseDir;
    public ManualClassLoader(){

        String basePath = ManualClassLoader.class.getResource("").getPath();
        this.baseDir = new File(basePath);
    }
    //找到之后加载到我们的jvm中来
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        //扎到我们的class(包名+类名)
        String  className = ManualClassLoader.class.getPackage().getName() + "." + name;
        if(baseDir != null) {

            File classFile = new File(baseDir, name.replaceAll("\\.", "/")+ ".class");
            if (classFile.exists()) {

                FileInputStream in = null;
                ByteArrayOutputStream baos = null;
                byte[] buff = new byte[1024];
                try {

                    baos =new ByteArrayOutputStream();
                    in = new FileInputStream(classFile);
                    int len;

                    while ((len = in.read(buff)) != -1) {

                        baos.write(buff, 0, len);
                    }
                    //load进jvm
                    return defineClass(className, baos.toByteArray(), 0, baos.size());
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    try {
                        in.close();
                        baos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    classFile.delete();
                }
            }

        }


        return null;
    }
}
