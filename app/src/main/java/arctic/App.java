package arctic;


import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Stack;

/**
 * Hello world!
 *
 */
public class App {
    public App(){
        System.out.println("无参构造方法");
    }
    public static App app1 = new App();
    {
        System.out.println("block A");
    }
    static {
        System.out.println("block B");
    }
}
