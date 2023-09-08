import java.util.ArrayList;
import java.util.List;

/**
 * @author zy
 * @date 2023/8/30 15:09
 */
public class OOMDemo {
    public static void main(String[] args) {
        System.out.println("test start");
        ArrayList<Picture> list = new ArrayList<Picture>();
        Thread t = new Thread(() -> {
            for(int i = 0; i < 1000; i++) {
                list.add(new Picture(1024 * 1024 * 1024));
            }
        });
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            System.out.println("打断");
        }
        System.out.println("test over");


    }
}

class Picture {
    private byte[] pixels;

    public Picture(int len) {
        this.pixels = new byte[len];
    }
}
