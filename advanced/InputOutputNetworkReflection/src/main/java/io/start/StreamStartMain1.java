package io.start;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamStartMain1 {

    public static void main(String[] args) throws IOException {
        // FileOutputStream에는 append가 기본 false 이며 덮어쓰게된다.
        // 폴더는 생성하지 않으므로 만들어야하며, 파일은 없을 경우 새로 만든다.
        FileOutputStream fos = new FileOutputStream("temp/hello.dat", false);
        fos.write(65);
        fos.write(66);
        fos.write(67);

        fos.close();

        FileInputStream fis = new FileInputStream("temp/hello.dat");
        System.out.println(fis.read());
        System.out.println(fis.read());
        System.out.println(fis.read());
        fis.close();
    }
}
