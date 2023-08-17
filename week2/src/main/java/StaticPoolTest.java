import java.util.ArrayList;

/**
 * @author zy
 * @date 2023/8/9 16:22
 */
public class StaticPoolTest {
    static String base = "string";
    /*public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        for(int i = 0; i < Integer.MAX_VALUE; i ++) {
            String str = base + base;
            base = str;
            list.add(str.intern());
        }

    }*/

    public static void main(String[] args) {
        //ArrayList<String> list = new ArrayList<String>();
        for(int i = 0; i < Integer.MAX_VALUE; i ++) {
            String str = base + base;
            //str.intern();
            base = str;
          //  list.add(str.intern());
        }

    }
}
