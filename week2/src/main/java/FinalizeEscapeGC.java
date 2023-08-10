import java.util.concurrent.TimeUnit;

/**
 * @author zy
 * @date 2023/8/10 16:03
 */
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("你瞅啥，还活着！！！");
    }

    @Override
    public void finalize() throws Throwable {
        //super.finalize();
        System.out.println("执行finalize方法");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();

        SAVE_HOOK = null;
        System.gc();

        TimeUnit.MILLISECONDS.sleep(500);
        if(SAVE_HOOK == null) {
            System.out.println("哦，哥死了");
        }else {
            SAVE_HOOK.isAlive();
        }

        SAVE_HOOK = null;
        System.gc();

        TimeUnit.MILLISECONDS.sleep(500);
        if(SAVE_HOOK == null) {
            System.out.println("哦，哥死了");
        }else {
            SAVE_HOOK.isAlive();
        }
    }
}
