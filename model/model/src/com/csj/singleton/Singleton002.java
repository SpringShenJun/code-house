package com.csj.singleton;

import java.util.HashMap;
import java.util.Map;

//类似spring里面的方法，按类名注册，下次从里面直接获取。
public class Singleton002 {

    private static Map<String, Singleton002> maps = new HashMap<>();

    static {

        Singleton002 singleton = new Singleton002();
        maps.put(singleton.getClass().getName(), singleton);
    }

    private Singleton002(){}

    //静态工厂方法，返还此类唯一的实例
    public static Singleton002 getInstance(String name) {

        if (name == null) {
            name = Singleton002.class.getName();
        }
        if (maps.get(name) == null) {
            try {
                //多态
                maps.put(name, (Singleton002) Class.forName(name).newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }

        return maps.get(name);
    }
}
