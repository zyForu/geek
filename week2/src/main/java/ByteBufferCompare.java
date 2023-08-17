import java.nio.ByteBuffer;

/**
 * @author zy
 * @date 2023/8/9 17:22
 */
public class ByteBufferCompare {
    public static void main(String[] args) {
        //allocateCompare();
        operateCompare();
    }

    public static void allocateCompare() {
        long time = 1000 * 10000;

        long st = System.currentTimeMillis();
        for(int i = 0; i < time; i++) {
            ByteBuffer.allocate(2);
        }
        long et = System.currentTimeMillis();
        System.out.println("堆内存分配耗时:" + (et - st) + "ms" );


        st = System.currentTimeMillis();
        for(int i = 0; i < time; i++) {
            ByteBuffer.allocateDirect(2);
        }
        et = System.currentTimeMillis();

        System.out.println("直接内存分配耗时:" + (et - st) + "ms");
    }

    public static void operateCompare() {
        int time = 1 * 10000 * 10000;

        ByteBuffer buffer = ByteBuffer.allocate(2*time);

        long st = System.currentTimeMillis();
        for(int i = 0; i < time; i++) {
               buffer.putChar('a');
        }
        buffer.flip();
        for(int i = 0; i < time; i++) {
            buffer.getChar();
        }
        long et = System.currentTimeMillis();

        System.out.println("堆内存读写操作耗时:" + (et - st) + "ms");

        ByteBuffer direct = ByteBuffer.allocateDirect(2 * time);
        st = System.currentTimeMillis();
        for(int i = 0; i < time; i++) {
            direct.putChar('a');
        }
        direct.flip();
        for(int i = 0; i < time; i++) {
            direct.getChar();
        }
        et = System.currentTimeMillis();
        System.out.println("直接内存读写操作耗时:" + (et - st) + "ms");
    }

}
