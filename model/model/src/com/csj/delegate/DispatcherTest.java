package com.csj.delegate;

public class DispatcherTest {


    public static void main(String[] args) {


        //看上去好像是我们的项目经理在干活\
        //实际干活的人是普通员工
        Dispatcher dispatcher = new Dispatcher(new ExectorA());
        //这就是典型的干活是我的，功劳是你的。
        dispatcher.doing();
    }
}
