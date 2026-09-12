package io.file.text;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import static java.nio.charset.StandardCharsets.UTF_8;

public class ReadTextFileV2 {

    private final static String PATH = "temp//hello2.txt";

    public static void main(String[] args) throws IOException {
        String writeString = "abc\n가나다";
        System.out.println("writeString = " + writeString);

        Path path = Path.of(PATH);

        Files.writeString(path, writeString, UTF_8);
        Stream<String> lineStream = Files.lines(path, UTF_8);
        lineStream.forEach(line -> System.out.println("line = " + line));
        lineStream.close();


/*        String readString = Files.readString(path, UTF_8);
        List<String> lines = Files.readAllLines(path, UTF_8);

        for (String line : lines) {
            System.out.println("line = " + line);
        }*/
    }
}
