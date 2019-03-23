package com.csj.delegate;

//调度:项目经理
public class Dispatcher {

    //指定的执行者
    private IExector exector;

    public Dispatcher(IExector exector) {

        this.exector = exector;
    }

    //项目经理：虽然也有执行方法
    //但是他的工作职责是不一样的
    public void doing() {

        this.exector.doing();
    }
}
