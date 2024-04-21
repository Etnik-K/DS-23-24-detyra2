package Detyra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class BookCipher {
    private String PathToBook; // Path per tek libri
    private int linesPerPage; // Numri i rreshtave per faqe

    // Konstruktori i inicializon pathin dhe faqet
    public BookCipher(String PathToBook, int linesPerPage) {
        this.PathToBook = PathToBook;
        this.linesPerPage = linesPerPage;
    }

    // Metoda lexon librin
    private List<String> readBook() {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(PathToBook))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }


    public String enkripto(String message) {
        List<String> bookLines = readBook();
        StringBuilder encryptedMessage = new StringBuilder();
        int currentPage = 1;
        int currentLine = 0;
        String[] words = message.split("\\s+"); // i ndane fjalet kur ka nje ose me shume hapesira
        Map<String, List<String>> wordPositions = new HashMap<>(); // I run pozitat e fjaleve

        for (String word : words) {
            List<String> positions = new ArrayList<>();
            for (int i = 0; i < bookLines.size(); i++) {
                currentLine++;
                if (currentLine > linesPerPage) {
                    currentPage++;
                    currentLine = 1;
                }
                String[] wordsInLine = bookLines.get(i).split("\\s+");
                for (int j = 0; j < wordsInLine.length; j++) {
                    String bookWord = wordsInLine[j];
                    if (word.equalsIgnoreCase(bookWord)) {
                        positions.add(currentPage + " " + currentLine + " " + (j + 1));
                    }
                }
            }
            // Ja bon shuffle pozites nese ni fjale paraqitet ma shume se dy here
            if (positions.size() > 1) {
                Collections.shuffle(positions);
            }
            wordPositions.put(word.toLowerCase(), positions);
            // Reseton faqen dhe rreshtin per fjalen e radhes
            currentPage = 1;
            currentLine = 0;
        }

        for (String word : words) {
            List<String> positions = wordPositions.get(word.toLowerCase());
            if (positions != null && !positions.isEmpty()) {
                String[] position = positions.get(0).split("\\s+");
                encryptedMessage.append(position[0]).append(" ");
                encryptedMessage.append(position[1]).append(" ");
                encryptedMessage.append(position[2]).append(" ");
                positions.remove(0); // fshin pozicionin e perdorur pas enkriptimit

            }
        }

        return encryptedMessage.toString().trim(); // renditja e numrave qe i kthen: faqja, rreshti, fjala
    }




    public String dekripto(String encryptedMessage) {
        List<String> bookLines = readBook();
        StringBuilder decryptedMessage = new StringBuilder();
        String[] encryptedWords = encryptedMessage.split("\\s+");
        for (int i = 0; i < encryptedWords.length; i += 3) {
            int page = Integer.parseInt(encryptedWords[i]);
            int line = Integer.parseInt(encryptedWords[i + 1]);
            int wordIndex = Integer.parseInt(encryptedWords[i + 2]);
            boolean wordFound = false;

            for (int j = 0; j < bookLines.size(); j++) {
                if (page == 0 || line == 0 || wordIndex == 0) break;
                int lineIndex = (page - 1) * linesPerPage + line - 1;
                if (lineIndex < bookLines.size()) {
                    String[] wordsInLine = bookLines.get(lineIndex).split("\\s+");
                    if (wordIndex >= 1 && wordIndex <= wordsInLine.length) {
                        decryptedMessage.append(wordsInLine[wordIndex - 1]).append(" ");
                        wordFound = true;
                        break;
                    }
                }
            }

            if (!wordFound) {
                // Shton nje hapesire nese fjala nuk gjendet
                decryptedMessage.append("[WORD NOT FOUND]").append(" ");
            }
        }
        return decryptedMessage.toString().trim();
    }


    public static void main(String[] args) {
        //C:\Users\Etnik\Downloads\who moved my cheese_book (1).pdf // me pdf sbon sic duhet
        //C:\Users\Etnik\Desktop\The Story Behind The Story .txt
        String txtFilePath = "C:\\Users\\Etnik\\Desktop\\The Story Behind The Story .txt";
        int linesPerPage = 20;
        Detyra.BookCipher cipher = new Detyra.BookCipher(txtFilePath, linesPerPage);

        //Mesazhi per me ekriptu
        String messageToEncrypt = "The mice moved the cheese";

        //Enkriptimi
        String encryptedMessage = cipher.enkripto(messageToEncrypt);
        System.out.println("Mesazhi i enkriptuar: " + encryptedMessage);

        // Dekriptimi
        String decryptedMessage = cipher.dekripto(encryptedMessage);
        System.out.println("Mesazhi i denkriptuar: " + decryptedMessage);
    }
}
