package org.lyg.clone;

import java.io.*;

/**
 * 对象的clone方法，除了对象实现Cloneable之外的另一种克隆方法
 */
public class MyUtil {
    private MyUtil(){
        throw new AssertionError();
    }
    public static <T extends Serializable> T clone(T obj) throws Exception {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream oout = new ObjectOutputStream(bout);
        oout.writeObject(obj);
        ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
        ObjectInputStream oin = new ObjectInputStream(bin);
        return (T)oin.readObject();
        //调用ByteArrayInputStream或ByteArrayOutputStream对象的close方法没有任何意义
        //这两个基于内存的流只要垃圾回收器清理帝乡就能够释放资源，这一点不同于对外部资源（如文件流）的释放
    }
}
