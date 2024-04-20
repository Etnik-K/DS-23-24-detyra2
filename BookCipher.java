package Detyra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BookCipher {

    // Metoda lexon cka ka n'liber
    private static String readBookFromFile(String filePath) throws IOException {
        StringBuilder bookContent = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                bookContent.append(line.toLowerCase());  // E kthen tekstin nshkronja tvogla per me ja lehtsu vetes jeten
            }
        }
        return bookContent.toString();
    }

    public static String encrypt(String book, String message) {
        StringBuilder encryptedMessage = new StringBuilder();
        Map<Character, List<Integer>> charPositions = new HashMap<>();
        message = message.toLowerCase();  // E kthen mesazhin nshkronja tvogla per me ja lehtsu vetes jeten

        // Regjistron poziten e cdo karakteri
        for (int i = 0; i < book.length(); i++) {
            char c = book.charAt(i);
            if (!charPositions.containsKey(c)) {
                charPositions.put(c, new ArrayList<>());
            }
            charPositions.get(c).add(i);
        }

        Random random = new Random();

        // Iteron neper cdo karakter ne mesazh
        for (char c : message.toCharArray()) {
            List<Integer> positions = charPositions.get(c);
            if (positions == null || positions.isEmpty()) {
                throw new IllegalArgumentException("Karakteri nuk u gjet në libër: " + c);
            }
            // Zgjidhet nje pozite e rastesishme per cdo karakter qe me e rrit sigurine
            int randomPosition = positions.get(random.nextInt(positions.size()));
            encryptedMessage.append(randomPosition).append(" ");
        }

        // Kthen mesazhin e enkriptuar sikur String
        return encryptedMessage.toString().trim();
    }

    public static String decrypt(String book, String encryptedMessage) {
        StringBuilder decryptedMessage = new StringBuilder();
        String[] indexes = encryptedMessage.split(" ");  // E bon split mesazhin ne hapesira

        // Iterojna neper cdo indeks
        for (String index : indexes) {
            int idx = Integer.parseInt(index);  // Konvertoni indeksin nga String n'int


            decryptedMessage.append(book.charAt(idx));
        }

        // Kthen mesazhin e dekriptuar n'String'
        return decryptedMessage.toString();
    }

    public static void main(String[] args) {
        String filePath = "C:\\Users\\Etnik\\Downloads\\who moved my cheese_book (1).pdf"; // Path per tek libri
        try {
            String book = readBookFromFile(filePath);
            String message = "Etnik Kelmendi";

            String encrypted = encrypt(book, message);
            System.out.println("I koduar: " + encrypted);

            String decrypted = decrypt(book, encrypted);
            System.out.println("I dekoduar: " + decrypted);
        } catch (IOException e) {
            System.out.println("Gabim gjatë leximit të skedarit të librit: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
