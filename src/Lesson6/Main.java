package Lesson6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        unification("text1.txt", "text2.txt", "text3.txt");
        System.out.print(finde("осталась ", "text1.txt"));
    }
    private static void unification (String copyFile1, String copyFile2, String nameFile) {
        try {
        StringBuilder buffer = new StringBuilder();
        Scanner readText1 = new Scanner(new FileInputStream(copyFile1));
        while (readText1.hasNext()) {
            buffer.append(readText1.nextLine()).append("\n");
        }
        Scanner readText2 = new Scanner(new FileInputStream(copyFile2));
        while (readText2.hasNext()) {
            buffer.append(readText2.nextLine()).append("\n");
        }
        PrintStream writeText = new PrintStream(new FileOutputStream(nameFile, true));
        writeText.println(buffer);
        writeText.close();
//            Scanner readText3 = new Scanner(new FileInputStream(nameFile));
//            while (readText3.hasNext()) {
//                System.out.println(readText3.nextLine());
//            }
        } catch (IOException e) {
        throw new RuntimeException(e);
        }
}
    private static boolean finde (String word, String File) {
        String althabetic = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        if(word.matches(althabetic)){
            try {
                StringBuilder buffer = new StringBuilder();
                Scanner readText1 = new Scanner(new FileInputStream(File));
                while (readText1.hasNext()) {
                    buffer.append(readText1.nextLine());
                    if ((buffer.toString().contains(word))) {
                        return true;
                    }else {
                        buffer = new StringBuilder();
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }
}
