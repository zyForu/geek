import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zy
 * @date 2023/8/22 18:12
 */
public class Demo06Volatile {
    public static void main(String[] args) throws InterruptedException {
        VolatileDemo volatileDemo = new VolatileDemo();
        for (int i = 0; i < 2; i++) {
            Thread t = new Thread(volatileDemo);
            t.start();
        }
        TimeUnit.MILLISECONDS.sleep(3000);
        System.out.println("count:" + volatileDemo.count);
        Lock lock = new ReentrantLock(true);
        lock.lock();
        lock.unlock();
        try {
            //业务代码
        } finally {
            //释放锁，在finally语句块确保锁最终会释放。
            lock.unlock();
        }

    }
}



class VolatileDemo implements Runnable {
    public volatile int count;


    @Override
    public void run() {
        addCount();
    }
    public void addCount() {
        for (int i = 0; i < 10000; i++) {
            count++;//但是实际情况是三条汇编指令
        }
    }
}
