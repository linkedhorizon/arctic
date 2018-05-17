package org.lyg.class_loader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by Administrator on 2018/5/6 0006.
 */
public class ClassLoader_self extends ClassLoader {
    private String classPath;
    public ClassLoader_self(String classPath){
        this.classPath = classPath;
    }
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = this.loadClassData(name);
        return this.defineClass(name,data,0,data.length);
    }
    /**
     * 加载Class文件中的内容
     */
    private byte[] loadClassData(String name){
        name = name.replace(".","//");
        try {
            FileInputStream is = new FileInputStream(new File(classPath+name+".class"));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int b = 0;
            while((b = is.read())!=-1){
                baos.write(b);
            }
            is.close();
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
