package com.fyang.myProxy.myProxy;

import com.fyang.myProxy.model.Man;

import java.lang.reflect.Method;

public class MyHandle implements MyInvocationHandler{

    private Man man;

    public MyHandle(Man man) {
        this.man = man;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] arge) throws Throwable {
        before();
        method.invoke(man);
        afore();
        return null;
    }


    private void before(){
        System.out.println("这是提前执行自己写的反射方法");
    }

    private void afore(){
        System.out.println("这是之后执行自己写的反射方法");
    }
}
