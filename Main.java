import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

class Printboardwc {
    Printboardwc(String cards[][], String board[][], int size) {
        String RED = "\u001B[31m";
        String YELLOW = "\u001B[33m";
        String RESET = "\u001B[0m";
        
        System.out.println("\nCurrent Board:");
        for (int i = 0; i < size; i++) {
            System.out.print(YELLOW + "+---".repeat(size) + "+" + RESET);
            System.out.println();
            for (int j = 0; j < size; j++) {
                System.out.print(YELLOW + "|" + RESET);
                if (board[i][j].equals(" _ ")) {
                    System.out.print(YELLOW + board[i][j] + RESET);
                } else {
                    System.out.print(RED + board[i][j] + RESET);
                }
                System.out.print(YELLOW + "" + RESET);
            }
            System.out.print(YELLOW + "|" + RESET);
            System.out.println();
        }
        System.out.print(YELLOW + "+---".repeat(size) + "+" + RESET);
        System.out.println("\n");
    }
}

class Shufflecard {
    Shufflecard(String cards[][], int size) {
        Random random = new Random();
        ArrayList<String> letter = new ArrayList<String>();
        int numPairs = (size * size) / 2;

        for (char c = 'A'; c < 'A' + numPairs; c++) {
            letter.add(String.valueOf(c));
            letter.add(String.valueOf(c));
        }

        int index;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                index = random.nextInt(letter.size());
                cards[i][j] = letter.get(index);
                letter.remove(index);
            }
        }
    }
}

class CheckInput {
    CheckInput(String cards[][], String board[][], int size) {
        String RESET = "\u001B[0m";
        String GREEN = "\u001B[32m";
        Scanner Scan = new Scanner(System.in);
        int row1 = -1, column1 = -1, row2, column2;
        int attempts = 0;

        while (true) {
            gameover go = new gameover();
            if (!go.gameover(cards, board, size)) {
                // First card selection
                while (true) {
                    System.out.print("Select row (1 - " + size + "): ");
                    row1 = Scan.nextInt();
                    if (row1 > size || row1 < 1) {
                        System.out.println("Invalid row. Please select a valid row.");
                        continue;
                    }
                    System.out.print("Select column (1 - " + size + "): ");
                    column1 = Scan.nextInt();
                    if (column1 > size || column1 < 1) {
                        System.out.println("Invalid column. Please select a valid column.");
                        continue;
                    }
                    if (!board[row1 - 1][column1 - 1].equals(" _ ")) {
                        System.out.println("Cell already opened. Select a different cell.");
                        continue;
                    }
                    break;
                }

                board[row1 - 1][column1 - 1] = " " + cards[row1 - 1][column1 - 1] + " ";
                Printboardwc pbwc = new Printboardwc(cards, board, size);

                // Second card selection
                while (true) {
                    System.out.print("Select row (1 - " + size + "): ");
                    row2 = Scan.nextInt();
                    if (row2 > size || row2 < 1) {
                        System.out.println("Invalid row. Please select a valid row.");
                        continue;
                    }
                    System.out.print("Select column (1 - " + size + "): ");
                    column2 = Scan.nextInt();
                    if (column2 > size || column2 < 1) {
                        System.out.println("Invalid column. Please select a valid column.");
                        continue;
                    }
                    if (!board[row2 - 1][column2 - 1].equals(" _ ")) {
                        System.out.println("Cell already opened. Select a different cell.");
                        board[row1 - 1][column1 - 1] = " _ ";
                        Printboardwc pbwc1 = new Printboardwc(cards, board, size);
                        continue;
                    }
                    break;
                }

                board[row2 - 1][column2 - 1] = " " + cards[row2 - 1][column2 - 1] + " ";
                Printboardwc pbwc2 = new Printboardwc(cards, board, size);

                attempts++;

                if (cards[row1 - 1][column1 - 1].equals(cards[row2 - 1][column2 - 1])) {
                    System.out.println("Correct! The cards match.");
                } else {
                    System.out.println("No match. The cards do not match.");
                    board[row1 - 1][column1 - 1] = " _ ";
                    board[row2 - 1][column2 - 1] = " _ ";
                }
            } else {
                System.out.println(GREEN + "Game Over! You've matched all the cards." + RESET);
                System.out.println("Your score (number of attempts): " + GREEN + attempts +RESET);
                break;
            }
        }
    }
}

class gameover {
    boolean gameover(String cards[][], String board[][], int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j].equals(" _ ")) {
                    return false;
                }
            }
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        String RESET = "\u001B[0m";
        Scanner Scan = new Scanner(System.in);
        int size;

        while (true) {
            // Ask for board size or quit option
            System.out.println("\nEnter board size (even number of 2 or higher) or 0 to quit: ");
            size = Scan.nextInt();

            if (size == 0) {
                System.out.println("Exiting... Thank you for playing!");
                return;
            }
            if (size < 2) {
                System.out.println("Board size must be at least 2.");
                continue;
            }
            if (size % 2 != 0) {
                System.out.println("Odd numbers are not allowed. Please enter an even number.");
                continue;
            }

            // Initialize the board and cards arrays
            String board[][] = new String[size][size];
            String cards[][] = new String[size][size];

            // Start a new game
            Shufflecard sc = new Shufflecard(cards, size);
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    board[i][j] = " _ ";
                }
            }
            Printboardwc pbwcc = new Printboardwc(cards, board, size);
            CheckInput ci = new CheckInput(cards, board, size);

        }
    }
}
