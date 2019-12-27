package com.idianyou.media.core.service.impl;

import java.io.*;

public class test2 {

    public static void main(String[] args) {
        int i = 0;
        // 歌词文件位置
//        File paramFile = new File("C:\\Users\\xinyu\\Desktop\\sing");
        File paramFile = new File("C:\\Users\\xinyu\\Desktop\\sing");
        File [] files = paramFile.listFiles();
        int a = 0;
        try {
            for (File file: files) {
                InputStream inputStream = new FileInputStream(file);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                byte[] arrayOfByte = new byte[1024];
                for (; ; ) {
                    int j = bufferedInputStream.read(arrayOfByte);
                    if (j <= 0) {
                        break;
                    }
                    byteArrayOutputStream.write(arrayOfByte, 0, j);
                }
                arrayOfByte = byteArrayOutputStream.toByteArray();
                while (i < arrayOfByte.length) {
                    arrayOfByte[i] = ((byte) (arrayOfByte[i] ^ new byte[]{-50, -45, 110, 105, 64, 90, 97, 119, 94, 50, 116, 71, 81, 54, -91, -68}[(i % 16)]));
                    i += 1;
                }
                String paramFile11 = new String(arrayOfByte, "UTF-8");
                File dir = new File("C:\\Users\\xinyu\\Desktop\\lyric");
                if(!dir.exists()) {
                    dir.mkdirs();
                }
                File txt = new File("C:\\Users\\xinyu\\Desktop\\lyric" + "\\" + file.getName().replace(".zrce", ".txt"));
                if (!txt.exists()) {
                    txt.createNewFile();
                }
                byte bytes[] = new byte[512];
                bytes = paramFile11.getBytes();
                FileOutputStream fos = new FileOutputStream(txt);
                fos.write(bytes);
                fos.flush();
                fos.close();
                a++;
            }
            System.out.println(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}