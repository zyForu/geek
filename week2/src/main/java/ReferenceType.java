import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/**
 * @author zy
 * @date 2023/8/10 16:14
 */
public class ReferenceType {
    public static void main(String[] args) throws InterruptedException {
        // 强引用
        Object o1 = new Object();

        // 软引用
        Object o2 = new Object();
        SoftReference<Object> soft = new SoftReference<>(o2);
        o2 = null;

        // 弱引用
        Object o3 = new Object();
        WeakReference<Object> week = new WeakReference<>(o3);
        o3 = null;

        // 虚引用
        Object o4 = new Object();
        PhantomReference<Object> phantom = new PhantomReference<>(o4, new ReferenceQueue<>());
        o4 = null;
        System.out.println("弱引用:" + week.get() + ",是否标记为垃圾:" + week.isEnqueued());
        System.out.println("第一次GC---");
        System.gc();
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("强引用:" + o1);
        System.out.println("软引用:" + soft.get() + ",是否标记为垃圾:" + soft.isEnqueued());
        System.out.println("弱引用:" + week.get() + ",是否标记为垃圾:" + week.isEnqueued());
        System.out.println("虚引用:" + phantom.get() + ",是否标记位垃圾:" + phantom.isEnqueued());


        System.out.println("第二次GC---");
        System.gc();
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("强引用:" + o1);
        System.out.println("软引用:" + soft.get() + ",是否标记为垃圾:" + soft.isEnqueued());
        System.out.println("弱引用:" + week.get() + ",是否标记为垃圾:" + week.isEnqueued());
        System.out.println("虚引用:" + phantom.get() + ",是否标记位垃圾:" + phantom.isEnqueued());
}
}
