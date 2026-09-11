package io.text;

import java.io.*;

import static io.text.TextConst.FILE_NAME;
import static java.nio.charset.StandardCharsets.UTF_8;

public class ReaderWriterMainV4 {

    public static final int BUFFER_SIZE = 8192;

    public static void main(String[] args) throws IOException {

        String writeString = "ABC\n가나다";
        System.out.println("write String: " + writeString);

        BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME), BUFFER_SIZE);
        bw.write(writeString);
        bw.close();

        BufferedReader br = new BufferedReader(new FileReader(FILE_NAME), BUFFER_SIZE);
        StringBuilder content = new StringBuilder();
        String line;
        while((line = br.readLine()) != null) {
            content.append(line).append("\n");
        }
        br.close();

        System.out.println(content.toString());
    }
}
