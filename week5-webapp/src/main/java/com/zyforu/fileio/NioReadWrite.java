package com.zyforu.fileio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author zy
 * @date 2023/9/11 17:20
 * 一般来说：只有套接字的channel双向的，FileChannel就是单向的
 */
public class NioReadWrite {
    public static void main(String[] args) throws IOException {
        // 文件写入
        File file = new File("test1.txt");
        FileOutputStream fos = new FileOutputStream(file);
        FileChannel channel = fos.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put("Hello, World!".getBytes());
        buffer.flip();
        channel.write(buffer);

        // 尝试同一个channel读取
        ByteBuffer buffer1 = ByteBuffer.allocate((int) file.length());
        channel.read(buffer1);
        System.out.println("文件内容:" + new String(buffer1.array()));
        fos.close();

        // 文件读取
       /* FileInputStream fin = new FileInputStream(file);
        FileChannel chanl = fin.getChannel();
        ByteBuffer buffer1 = ByteBuffer.allocate((int) file.length());
        chanl.read(buffer1);
        System.out.println("文件内容:" + new String(buffer1.array()));
        fin.close();*/


    }

}
