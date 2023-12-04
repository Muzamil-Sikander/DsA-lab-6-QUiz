import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ConsoleNotepad {
    public static void main(String[] args) {

        System.out.println("Console Notepad - Enter text (type 'exit' to save and exit):");
        String inputText = getUserInput();

        String reversedText = reverseText(inputText);
        saveToFile("save.txt", reversedText);

        String originalText = loadFromFile("save.txt");
        System.out.println("\nLoaded Text in Original Form: \n" + originalText);
    }

    private static String getUserInput() {
        StringBuilder userInput = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(System.in))) {
            String line;
            while (!(line = reader.readLine()).equalsIgnoreCase("exit")) {
                userInput.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading user input: " + e.getMessage());
        }
        return userInput.toString();
    }

    private static void saveToFile(String filePath, String text) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(text);
        } catch (IOException e) {
            throw new RuntimeException("Error saving to file: " + e.getMessage());
        }
    }

    private static String loadFromFile(String filePath) {
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Error loading from file: " + e.getMessage());
        }

        return stringBuilder.toString();
    }

    private static String reverseText(String text) {
        return new StringBuilder(text).reverse().toString();
    }
}