package com.fyang.myProxy;

import com.fyang.myProxy.model.Fyang;
import com.fyang.myProxy.model.Man;
import com.fyang.myProxy.systemProxy.MyHandle;

import java.lang.reflect.Proxy;

public class Test {

    public static void main(String[] args) {
        Man man = new Fyang();
        MyHandle myHandle = new MyHandle(man);
        Man proxyMan = (Man) Proxy.newProxyInstance(man.getClass().getClassLoader(),new Class[]{Man.class},myHandle);

        System.out.println(proxyMan.getClass().getName());
        proxyMan.findObject();
    }
}
