# Crazy Eights Game (Java)

A console-based implementation of the classic card game **Crazy Eights** (known in Greek as "Agonia"), developed for the "Object-Oriented Programming Techniques" course.

## 🎮 Game Rules
* **Setup:** A standard deck is shuffled, 5 cards are dealt to each player, and one card is placed face-up on the table.
* **Gameplay:** Players must play a card that matches either the **suit** or the **number** of the top card.
* **The "8" Rule:** Eights are wildcards and can be played at any time, allowing the player to declare a new suit.
* **Drawing:** If a player cannot move, they must draw a card from the pile and skip their turn.
* **Winning:** The first player to discard all their cards wins the game.

## 🛠️ Class Architecture
The project is structured into several modular classes:

* **`Card`**: Represents a single card with a suit and a number (0-9).
* **`Pile`**: Manages the deck, including filling and shuffling logic.
* **`Table`**: Tracks the current state of the game board, the discard pile, and the top card.
* **`Hand`**: Manages a player's current cards and includes the AI logic for card selection.
* **`Player`**: Handles interactions for both Human and Computer players.
* **`CrazyEights` & `Game`**: The main controllers that coordinate the game flow and user input.

## 🚀 Key Features
* **AI Strategy:** Includes a `ComputerPlayer` that automatically selects matching cards or strategically uses "8s" based on the most frequent suit in its hand.
* **Dynamic Re-shuffling:** If the draw pile empties, the discard pile is automatically recycled and reshuffled.
* **Multiplayer Support:** Supports a human player versus one or more computer-controlled opponents.

## 📋 Execution Instructions
Compile all `.java` files and run the `Game` class:

```bash
javac *.java
java Game
