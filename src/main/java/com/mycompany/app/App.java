package com.mycompany.app;

import java.io.File;

import com.google.common.io.Files;

/**
 * Hello world!
 */
public class App {

    private static final String MESSAGE = "Hello World!";

    public App() {}

    public static void main(String[] args) {
        File dir = createTempDirectory();
        try {
            System.out.println("Created temporary directory: " + dir);
        }
        finally {
            dir.delete();
        }
        System.out.println(MESSAGE);
    }

    public String getMessage() {
        return MESSAGE;
    }


    private static File createTempDirectory() {
        // https://nvd.nist.gov/vuln/detail/CVE-2023-2976
        return Files.createTempDir();
    }
}
