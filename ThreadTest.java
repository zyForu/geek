import java.util.concurrent.TimeUnit;

/**
 * @author zy
 * @date 2023/8/9 14:37
 */
public class ThreadTest {
    public static void recurive(double d) {
        if(d == 0) {
            return;
        }
        recurive(d-1);
    }

    public static void main(String[] args) {
        for(int i = 0; i < 100000; i++) {
            new Thread("Thread-" + i) {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
					byte[] abyte = new byte[1024 * 1024];
                    recurive(30000);
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }

}
