/**
 * @author zy
 * @date 2023/8/9 14:12
 */
public class StackTest {
    private static int index = 0;

    public void call() {
        index ++;
        call();
    }

    public static void main(String[] args) {
        StackTest stackTest = new StackTest();
        try {
            stackTest.call();
        }catch (Throwable t) {
            System.out.println("当前调用stack depth:" + StackTest.index);
            t.printStackTrace();
        }
    }
}
