import org.openjdk.jol.info.ClassLayout;

/**
 * @author zy
 * @date 2023/8/10 15:34
 */
public class ObjLock01 {
    public static void main(String[] args) {
        Object o = new Object();
        System.out.println("new Object:" + ClassLayout.parseInstance(o).toPrintable());
    }
}
