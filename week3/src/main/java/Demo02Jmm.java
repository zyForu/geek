import java.util.concurrent.TimeUnit;

/**
 * @author zy
 * @date 2023/8/22 16:04
 */
public class Demo02Jmm {
    public static void main(String[] args) throws InterruptedException {
        JmmDemo jmmDemo = new JmmDemo();
        Thread t = new Thread(jmmDemo);
        t.start();
        TimeUnit.MILLISECONDS.sleep(200);
        jmmDemo.flag = false;

        System.out.println("flag is :" + jmmDemo.flag);
    }

}



class JmmDemo implements Runnable {
    public volatile boolean flag = true;

    @Override
    public void run() {
        System.out.println("线程执行中");
        while (flag) {
            // System.out.println();
        }
        System.out.println("线程执行结束");
    }
}
