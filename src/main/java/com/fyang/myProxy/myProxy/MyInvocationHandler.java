package com.fyang.myProxy.myProxy;

import java.lang.reflect.Method;

public interface MyInvocationHandler {

    public Object invoke (Object proxy, Method method, Object[] arge) throws Throwable;
}
