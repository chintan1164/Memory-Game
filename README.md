# Memory Game

## Overview
This is an enhanced console-based memory game implemented in Java. The game consists of a customizable grid (minimum 2x2) where pairs of letters are hidden. The player's goal is to match all pairs by uncovering two cells at a time. The game continues until all pairs are matched.

## Features
- **Customizable Board Size:** The player can choose the size of the board, ensuring it's an even number for proper pairing.
- **Randomized Board:** Each game starts with a new shuffled board.
- **Input Validation:** Ensures the player enters valid row and column numbers.
- **Colored Output:** Uses ANSI escape codes for colored output in the console to enhance the visual experience.
- **Game Loop:** Continues to prompt the player for input until all pairs are matched or the player chooses to quit.
- **Attempts Count:** Tracks the number of attempts made by the player.

## Classes

### Main
**Purpose:** Entry point of the application. Manages the game loop and handles user input for starting a new game or quitting.  
**Key Methods:**
- `main(String[] args)`: Initializes the game, handles user input for starting a new game or quitting.

### Printboardwc
**Purpose:** Prints the current state of the board to the console.  
**Constructor:**
- `Printboardwc(String[][] cards, String[][] board, int size)`: Takes the cards and board arrays and prints the board with colors indicating the status of each cell (revealed or hidden).

### Shufflecard
**Purpose:** Shuffles and assigns letters to the cards array.  
**Constructor:**
- `Shufflecard(String[][] cards, int size)`: Randomly assigns pairs of letters to the cards array based on the board size.

### CheckInput
**Purpose:** Handles player input during the game, validates input, and manages the game logic for uncovering cards and checking for matches.  
**Constructor:**
- `CheckInput(String[][] cards, String[][] board, int size)`: Manages the game logic, including validating user input and checking for matches.

### Gameover
**Purpose:** Checks if the game is over (i.e., all pairs are matched).  
**Method:**
- `boolean gameover(String[][] cards, String[][] board, int size)`: Returns true if all pairs are matched, false otherwise.

## How to Run
1. **Compile the Java files:**
   ```
   javac Main.java
   ```
2. **Run the game:**
   ```
   java Main
   ```

## How to Play
1. **Start the Game:** Run the application and enter the desired board size (even number of 2 or higher) or 0 to quit.
2. **Uncover Cards:**
   - You will be prompted to select a row and column for the first card.
   - Then, you will be prompted to select a row and column for the second card.
3. **Matching Pairs:**
   - If the selected cards match, they remain uncovered.
   - If they do not match, they are hidden again.
4. **Continue:** Repeat the process until all pairs are matched.
5. **Quit:** At any time, you can enter 0 as the board size to quit the game.

## Game End
- The game ends when all pairs are matched. A "Game Over" message will be displayed along with the number of attempts.
- You can start a new game by entering a new board size or quit by entering 0.

## Note
- Ensure your console supports ANSI escape codes for colored output.
- Enjoy playing the memory game! If you have any issues or suggestions, feel free to contribute to the project on GitHub.

## License
This project is licensed under the MIT License - see the LICENSE file for details.
