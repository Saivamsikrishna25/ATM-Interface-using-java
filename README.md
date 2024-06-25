# ATM Interface in Java

This Java program simulates a basic ATM (Automated Teller Machine) interface with functionalities such as deposit, withdraw, transfer, view transaction history, and quit. It is implemented using object-oriented principles and a console-based interface.

## Features

- **Deposit**: Allows the user to deposit money into their account.
- **Withdraw**: Enables the user to withdraw money from their account, provided sufficient funds are available.
- **Transfer**: Allows the user to transfer money from their account to another account.
- **View Transaction History**: Displays a list of all transactions made on the account.
- **Quit**: Terminates the program and ends the ATM session.

## Classes

### Transaction.java

This class defines the types of transactions (`DEPOSIT`, `WITHDRAW`, `TRANSFER`) and provides a representation for each transaction made.

### Account.java

The `Account` class represents a bank account with methods to perform operations such as depositing, withdrawing, transferring money, and viewing transaction history.

### ATM.java

The `ATM` class implements the console-based interface for the ATM. It interacts with the `Account` class to perform operations based on user input and displays the appropriate messages and transaction history.

## Getting Started

To run the program locally:

1. Ensure you have Java Development Kit (JDK) installed on your machine.
2. Clone this repository to your local machine.
   ```
   git clone https://github.com/your-username/atm-java.git
   ```
3. Navigate to the project directory.
   ```
   cd atm-java
   ```
4. Compile the Java files.
   ```
   javac ATM.java
   ```
5. Run the ATM interface.
   ```
   java ATM
   ```

## Usage

- Upon running the program, you will see a menu with options to deposit, withdraw, transfer, view transaction history, and quit.
- Enter the corresponding number to select an option and follow the prompts to complete the transaction.
- The program will display transaction details and current balance after each operation.

## Example

Here's an example of how the program works:

1. Deposit: User deposits $100.
2. Withdraw: User withdraws $50.
3. Transfer: User transfers $30 to another account.
4. View Transaction History: User views all transactions made.
5. Quit: User exits the ATM interface.

## Contributing

Contributions are welcome! If you have any suggestions or improvements, feel free to submit a pull request.
