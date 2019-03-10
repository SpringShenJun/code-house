package com.csj.manual;

import java.lang.reflect.Method;

/**
 * custom InvocationHandler
 */
public interface ManualInvocationHandler {

    public Object invoke(Object proxy, Method method, Object[] args);
}
