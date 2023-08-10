import org.openjdk.jol.info.ClassLayout;

import java.util.Calendar;

/**
 * @author zy
 * @date 2023/8/10 15:45
 */
public class ObjLock02 {
    public static void main(String[] args) {
        Mojo mojo = new Mojo();
        System.out.println("new Mojo:" + ClassLayout.parseInstance(mojo).toPrintable());

        mojo.setI(123);
        mojo.setStr("123");
        mojo.setFlag(true);
        System.out.println("after setting values : " + ClassLayout.parseInstance(mojo).toPrintable());
    }


    static class Mojo{
        private int i;
        private boolean flag;
        private String str;

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }

        public boolean isFlag() {
            return flag;
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }
    }
}
