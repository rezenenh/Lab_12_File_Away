import java.io.*;
import javax.swing.*;

public class FileInspector {
        public static void main(String[] args) {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    FileReader fileReader = new FileReader(file);
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    int lineCount = 0;
                    int wordCount = 0;
                    int characterCount = 0;
                    String line;
                    while ((line = reader.readLine()) != null) {
                        lineCount++;
                        String[] words = line.split(" ");
                        wordCount += words.length;
                        characterCount += line.length();
                    }
                    System.out.println("File name: " + file.getName());
                    System.out.println("Line count: " + lineCount);
                    System.out.println("Word count: " + wordCount);
                    System.out.println("Character count: " + characterCount);
                    reader.close();
                } catch (FileNotFoundException e) {
                    System.err.println("Error opening file: " + e.getMessage());
                } catch (IOException e) {
                    System.err.println("Error reading file: " + e.getMessage());
                }
            }
        }
    }
