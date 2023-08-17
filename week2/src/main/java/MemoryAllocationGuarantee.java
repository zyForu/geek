/**
 * @author zy
 * @date 2023/8/10 15:16
 */
public class MemoryAllocationGuarantee {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        memeoryAllocation();
    }

    public static void memeoryAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[1 * _1MB];
        allocation2 = new byte[1 * _1MB];
        allocation3 = new byte[1 * _1MB];
        allocation4 = new byte[5 * _1MB];
        System.out.println("完毕");
    }
}
