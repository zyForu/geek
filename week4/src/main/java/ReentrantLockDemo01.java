import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zy
 * @date 2023/8/30 11:17
 */
public class ReentrantLockDemo01 {
    public static void main(String[] args) {
        //SharedResource share = new SharedResource();
        LockedSharedResource share = new LockedSharedResource(new ReentrantLock());
        new Thread(share).start();
        new Thread(share).start();
    }
}


class SharedResource implements Runnable{
    public int i;

    public void run() {
        for(int j = 0; j < 10000; j++) {
            System.out.println("current i is:" + i++);
        }
    }
}

class LockedSharedResource implements Runnable{
    public int i;
    public Lock lock;

    public LockedSharedResource(Lock lock) {
        this.lock = lock;
    }
    public void run() {
        for(int j = 0; j < 10000; j++) {
            lock.lock();
            System.out.println("current i is:" + i++);
            lock.unlock();
        }
    }
}