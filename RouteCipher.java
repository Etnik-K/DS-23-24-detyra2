package ProjektiNeSiguri;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RouteCipher {

    // Metoda e enkriptimit te clockwise route
    List<Character> clockwiseEn(char[][] matrix) {
        List<Character> res = new ArrayList<>();

        if (matrix.length == 0) {
            return res;
        }

        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            if (rowBegin > rowEnd) break;

            // Traverse Down
            for (int j = rowBegin; j <= rowEnd; j++) {
                res.add(matrix[j][colEnd]);
            }
            colEnd--;

            if (colBegin > colEnd) break;

            // Traverse Left
            for (int j = colEnd; j >= colBegin; j--) {
                res.add(matrix[rowEnd][j]);
            }
            rowEnd--;

            if (rowBegin > rowEnd) break;

            // Traverse Up
            for (int j = rowEnd; j >= rowBegin; j--) {
                res.add(matrix[j][colBegin]);
            }
            colBegin++;

            // Traverse Right
            for (int j = colBegin; j <= colEnd; j++) {
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;
        }

        return res;
    }

    // Metoda e enkrpitimit te anticlocwise route
    List<Character> anticlockwiseEn(char[][] matrix) {
        List<Character> res = new ArrayList<>();

        if (matrix.length == 0) {
            return res;
        }

        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Down
            for (int j = rowBegin; j <= rowEnd; j++) {
                res.add(matrix[j][colBegin]);
            }
            colBegin++;

            if (colBegin > colEnd) break;

            // Traverse Right
            for (int j = colBegin; j <= colEnd; j++) {
                res.add(matrix[rowEnd][j]);
            }
            rowEnd--;

            if (rowBegin > rowEnd) break;

            // Traverse Up
            for (int j = rowEnd; j >= rowBegin; j--) {
                res.add(matrix[j][colEnd]);
            }
            colEnd--;

            if (colBegin > colEnd) break;

            // Traverse Left
            for (int j = colEnd; j >= colBegin; j--) {
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;
        }

        return res;
    }

    // Metoda e dekrpitimit te clockwise route
    String deClockwise(char[][] matrix, List<Character> spiral) {
        int totalRows = matrix.length;
        int totalCols = matrix[0].length;
        int index = 0;

        int rowBegin = 0;
        int rowEnd = totalRows - 1;
        int colBegin = 0;
        int colEnd = totalCols - 1;

        StringBuilder result = new StringBuilder();

        while (rowBegin <= rowEnd && colBegin <= colEnd && index < spiral.size()) {

            // kolona e djathte
            for (int j = rowBegin; j <= rowEnd; j++) {
                matrix[j][colEnd] = spiral.get(index++);
            }
            colEnd--;

            if (rowBegin <= rowEnd) {
                // rreshti i poshtem
                for (int j = colEnd; j >= colBegin; j--) {
                    matrix[rowEnd][j] = spiral.get(index++);
                }
            }
            rowEnd--;

            if (colBegin <= colEnd) {
                // kolona e majte
                for (int j = rowEnd; j >= rowBegin; j--) {
                    matrix[j][colBegin] = spiral.get(index++);
                }
            }
            colBegin++;

            // rreshti i siperm
            for (int j = colBegin; j <= colEnd; j++) {
                matrix[rowBegin][j] = spiral.get(index++);
            }
            rowBegin++;
        }

        // Leximi i matrices te dekriptuar
        for (int r = 0; r < totalRows; r++) {
            for (int c = 0; c < totalCols; c++) {
                result.append(matrix[r][c]);
            }
        }

        return result.toString();
    }

    // metoda e dekriptimit te anticlockwise route

    String deAnticlockwise(char[][] matrix, List<Character> spiral) {
        int totalRows = matrix.length;
        int totalCols = matrix[0].length;
        int index = 0;

        int rowBegin = 0;
        int rowEnd = totalRows - 1;
        int colBegin = 0;
        int colEnd = totalCols - 1;

        StringBuilder result = new StringBuilder();

        while (rowBegin <= rowEnd && colBegin <= colEnd && index < spiral.size()) {
            // kolona e majte
            for (int j = rowBegin; j <= rowEnd; j++) {
                matrix[j][colBegin] = spiral.get(index++);
            }
            colBegin++;

            if (colBegin > colEnd) break;

            // rrreshti i poshtem
            for (int j = colBegin; j <= colEnd; j++) {
                matrix[rowEnd][j] = spiral.get(index++);
            }
            rowEnd--;

            if (rowBegin > rowEnd) break;

            // kolona e dhjathte
            for (int j = rowEnd; j >= rowBegin; j--) {
                matrix[j][colEnd] = spiral.get(index++);
            }
            colEnd--;

            if (colBegin > colEnd) break;

            // rreshti i siperm
            for (int j = colEnd; j >= colBegin; j--) {
                matrix[rowBegin][j] = spiral.get(index++);
            }
            rowBegin++;
        }

        // Leximi i matrices te dekriptuar te anticlockwise
        for (int r = 0; r < totalRows; r++) {
            for (int c = 0; c < totalCols; c++) {
                result.append(matrix[r][c]);
            }
        }

        return result.toString();
    }

    // Metoda per me printu matricen e plaintextit
    void printPlaintextMatrix(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            System.out.println("Matrix is empty.");
            return;
        }

        System.out.println("\nThe plaintext matrix:");
        for (char[] row : matrix) {
            for (char ch : row) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Zgjidheni metoden e enkriptimit/dekriptimit:");
        System.out.println("1. Clockwise route");
        System.out.println("2. Anticlockwise route");
        System.out.print(">> ");
        int methodChoice = Integer.parseInt(scanner.nextLine());

        System.out.print("\nJu lutem vendoseni numrin e kolonave (me i madh se 1): ");
        int routeSize = Integer.parseInt(scanner.nextLine());

        System.out.print("Ju lutem vendoseni plaintextin qe deshironi te enkriptoni/dekriptoni: ");
        String plainText = scanner.nextLine();

        // hjek hapsirat nga plaintexti
        plainText = plainText.replaceAll("\\s", "");

        // nga kolonat e dhena i kalkulon sa rreshta nevojiten
        int totalRows = (int) Math.ceil((double) plainText.length() / routeSize);
        if (totalRows * routeSize < plainText.length()) {
            totalRows++;
        }

        // krijohet matrica qe i mban karakteret e dhena
        char[][] grid = new char[totalRows][routeSize];


        // karakteret vendosen ne matrice
        int index = 0;
        for (int r = 0; r < totalRows; r++) {
            for (int c = 0; c < routeSize; c++) {
                if (index < plainText.length()) {
                    grid[r][c] = plainText.charAt(index++);
                } else {
                    grid[r][c] = '-'; // nese teksti eshte me i shkurter mbushet me "-" per hapesirat
                }
            }
        }


        RouteCipher spiralEncryption = new RouteCipher();

        // printo plaintextin si matrice
        spiralEncryption.printPlaintextMatrix(grid);

        // printo matricen nga metoda e zgjedhur nga useri
        List<Character> spiral;
        String despiraledText;
        if (methodChoice == 1) {
            // enkriptimi i clockwise route
            spiral = spiralEncryption.clockwiseEn(grid);
            System.out.println("\nClockwise encryption:");
            for (char ch : spiral) {
                System.out.print(ch + " ");
            }
            System.out.println();

            // dekriptimi i clockwise route
            despiraledText = spiralEncryption.deClockwise(grid, spiral);
            System.out.println("\nClockwise decryption:");
        } else {
            // enkripitimi i anticlockwise route
            spiral = spiralEncryption.anticlockwiseEn(grid);
            System.out.println("\nAnticlockwise encryption:");
            for (char ch : spiral) {
                System.out.print(ch + " ");
            }
            System.out.println();

            // dekriptimi i anticlockwise route
            despiraledText = spiralEncryption.deAnticlockwise(grid, spiral);
            System.out.println("\nTAnticlockwise decryption:");
        }

        System.out.println(despiraledText);
    }
}
  
