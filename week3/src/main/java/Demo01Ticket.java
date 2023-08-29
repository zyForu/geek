import java.util.concurrent.TimeUnit;

/**
 * @author zy
 * @date 2023/8/22 14:55
 */
public class Demo01Ticket {
    public static void main(String[] args) {
        /*SellTicketTask sellTicketTask = new SellTicketTask();
        new Thread(sellTicketTask).start();
        new Thread(sellTicketTask).start();
        new Thread(sellTicketTask).start();*/


        SellTicketTaskSynchronized sellTicketTaskSynchronized = new SellTicketTaskSynchronized();
        new Thread(sellTicketTaskSynchronized).start();
        new Thread(sellTicketTaskSynchronized).start();
        new Thread(sellTicketTaskSynchronized).start();

    }



}


class SellTicketTask implements Runnable{
    private int tickets = 100;


    @Override
    public void run() {
        while(true) {
            if(tickets > 0) {
                try {
                    TimeUnit.MILLISECONDS.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + "-正在卖:" + tickets--);
            }
        }
    }
}

class SellTicketTaskSynchronized  implements Runnable{
    private int tickets = 100;

    private final Object lock = new Object();


    @Override
    public void run() {
        while(true) {
            synchronized (lock) {
                if(tickets > 0) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "-正在卖:" + tickets--);
                }
            }
        }
    }
}



