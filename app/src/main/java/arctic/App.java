package arctic;

/**
 * Created by Administrator on 2018/5/22 0022.
 */
public class App {
    public static void main(String[] args){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("put");
            }
        });
        t.start();

    }
}
