package org.lyg.decorator;

/**
 * 装饰者类
 */
public class Decorator implements Sourceable {
    private Source source;
    public Decorator(Source source){
        super();
        this.source = source;
    }
    @Override
    public void method() {
        System.out.println("before decorator !");
        source.method();
        System.out.println("after decorator !");
    }
}
