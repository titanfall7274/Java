package io.streams;

import java.io.*;

public class DataStreamEtcStream {

    public static void main(String[] args) throws IOException {

        FileOutputStream fos = new FileOutputStream("temp/data.txt");
        DataOutputStream dataOutputStream = new DataOutputStream(fos);

        dataOutputStream.writeUTF("회원A");

        // 자바가 저장할때 사용하는 것들로 저장됨
//         회원A   @%      
        dataOutputStream.writeInt(20);
        dataOutputStream.writeDouble(10.5);
        dataOutputStream.writeBoolean(true);

        dataOutputStream.close();

        FileInputStream fis = new FileInputStream("temp/data.txt");
        DataInputStream dataInputStream = new DataInputStream(fis);

        System.out.println(dataInputStream.readUTF());
        System.out.println(dataInputStream.readInt());
        System.out.println(dataInputStream.readDouble());
        System.out.println(dataInputStream.readBoolean());

        dataInputStream.close();
    }
}
