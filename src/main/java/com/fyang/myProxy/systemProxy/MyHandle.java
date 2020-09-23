package com.fyang.myProxy.systemProxy;

import com.fyang.myProxy.model.Man;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyHandle implements InvocationHandler {

    private Man man;

    public MyHandle(Man man) {
        this.man = man;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        method.invoke(man);
        afore();
        return null;
    }

    private void before(){
        System.out.println("这是提前执行");
    }

    private void afore(){
        System.out.println("这是之后执行");
    }

}
