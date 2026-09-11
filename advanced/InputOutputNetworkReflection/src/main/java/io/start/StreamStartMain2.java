package io.start;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamStartMain2 {

    public static void main(String[] args) throws IOException {
        // FileOutputStream에는 append가 기본 false 이며 덮어쓰게된다.
        // 폴더는 생성하지 않으므로 만들어야하며, 파일은 없을 경우 새로 만든다.
        FileOutputStream fos = new FileOutputStream("temp/hello.dat", false);
        fos.write(65);
        fos.write(66);
        fos.write(67);
        fos.close();

        FileInputStream fis = new FileInputStream("temp/hello.dat");
        int data;

        // 자바에서는 파일의끝에 도달할 경우 -1을 반환한다.
        // byte는 2바이트로 256개의 수를 나타낼수 있는데
        // -128 ~ 127이다 이걸 int로 변환하면 0 ~ 255가 되어 EOF를 위한 특별한 값을 할당하기 어렵다.
        // 때문에 -1을 통해 스트림의 끝(EOF)을 판단한다.
        while((data = fis.read()) != -1) {
            System.out.println(data);
        }
        fis.close();
    }
}
