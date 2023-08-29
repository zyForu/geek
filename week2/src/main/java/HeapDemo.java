import java.util.concurrent.TimeUnit;

/**
 * @author zy
 * @date 2023/8/8 19:33
 */
public class HeapDemo {
    public static void main(String[] args) {
        System.out.println("===start===");
		Mini mini = new Mini();
		mini.setFlag(true);
		mini.setI(2);
        try {
            TimeUnit.HOURS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("===end===");
    }
	
	static class Mini{
		private String str;
		private int i;
		private boolean flag;
		
		public void setStr(String str) {
			this.str = str;
		}
		
		public void setI(int i) {
			this.i = i;
		}
		
		public void setFlag(boolean flag) {
			this.flag = flag;
		}
	}
}
