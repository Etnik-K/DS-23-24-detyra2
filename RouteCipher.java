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

    }
  
