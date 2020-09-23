package com.fyang.myProxy.myProxy;


import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;

public class MyClassLoader extends ClassLoader {

    //生成的代理类加载路径
    private File dir;

    private String proxyClassPackage;

    public File getDir() {
        return dir;
    }

    public String getProxyClassPackage() {
        return proxyClassPackage;
    }

    public MyClassLoader(File dir, String proxyClassPackage) {
        this.dir = dir;
        this.proxyClassPackage = proxyClassPackage;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException{
        if(dir != null){
            File classFile = new File(dir,name+".class");
            if(classFile.exists()){
                try {
                    //生成CLASS的二进制字节流
                    byte[] classBytes = FileCopyUtils.copyToByteArray(classFile);
                    return defineClass(proxyClassPackage+"."+name,classBytes,0,classBytes.length);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //如果上述自定义的类没有加载到，走默认加载方式
        return super.findClass(name);
    }

}
