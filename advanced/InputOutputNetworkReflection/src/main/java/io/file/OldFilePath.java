package io.file;

import java.io.File;
import java.io.IOException;

public class OldFilePath {
    public static void main(String[] args) throws IOException {
        File file = new File("temp/..");
        System.out.println(file.getPath());

        System.out.println(file.getAbsolutePath());

        System.out.println(file.getCanonicalPath());


        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println((f.isFile() ? "F" : "D" + " | " + f.getName()));
        }

    }
}
