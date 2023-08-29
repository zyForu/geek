/**
 * @author zy
 * @date 2023/8/22 16:25
 */
public class Demo03Synchronized {
    private Object obj = new Object();
    public synchronized void increase(){
        System.out.println("synchronized 方法");
    }
    public void syncBlock(){
        synchronized (obj){
            System.out.println("synchronized 块");
        }
    }
}
