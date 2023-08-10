import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author zy
 * @date 2023/8/10 10:18
 */
public class HeapInstance {

    public static void main(String[] args) throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);

        List<Picture> list = new ArrayList<>();
        while(true) {
            try {
                TimeUnit.MILLISECONDS.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add(new Picture(new Random().nextInt(1024 * 1024)));
        }
    }
}
class Picture {
    private byte[] pixels;

    public Picture(int len) {
        this.pixels = new byte[len];
    }
}
