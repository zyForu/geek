import java.util.concurrent.TimeUnit;

/**
 * @author zy
 * @date 2023/8/8 19:33
 */
public class HeapDemo {
    public static void main(String[] args) {
        System.out.println("===start===");
        try {
            TimeUnit.MINUTES.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("===end===");
    }
}
