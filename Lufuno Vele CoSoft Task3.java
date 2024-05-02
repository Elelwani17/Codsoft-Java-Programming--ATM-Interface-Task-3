class BankAccount:
    """A class to represent a bank account."""
    def __init__(self, initial_balance=0):
        self.balance = initial_balance

    def deposit(self, amount):
        """Deposits a positive amount to the bank account."""
        if amount > 0:
            self.balance += amount
            return True
        return False

    def withdraw(self, amount):
        """Withdraws an amount from the bank account if funds are sufficient."""
        if 0 < amount <= self.balance:
            self.balance -= amount
            return True
        return False

    def get_balance(self):
        """Returns the current balance of the bank account."""
        return self.balance

class ATM:
    """A class to represent an ATM machine."""
    def __init__(self, bank_account):
        self.account = bank_account

    def run(self):
        """Runs the main ATM interface loop, allowing user interactions."""
        while True:
            print("\nWelcome to the ATM!")
            print("1. Check Balance")
            print("2. Deposit Money")
            print("3. Withdraw Money")
            print("4. Exit")
            choice = input("Enter your choice: ")

            if choice == '1':
                self.check_balance()
            elif choice == '2':
                self.deposit_money()
            elif choice == '3':
                self.withdraw_money()
            elif choice == '4':
                print("Thank you for using the ATM. Goodbye!")
                break
            else:
                print("Invalid choice. Please choose a valid option.")

    def check_balance(self):
        """Displays the current balance to the user."""
        print(f"Your current balance is: ${self.account.get_balance():.2f}")

    def deposit_money(self):
        """Allows the user to deposit money after validating the input amount."""
        try:
            amount = float(input("Enter the amount to deposit: "))
            if self.account.deposit(amount):
                print(f"Successfully deposited ${amount:.2f}. Your new balance is: ${self.account.get_balance():.2f}")
            else:
                print("Invalid amount. Please enter a positive number.")
        except ValueError:
            print("Invalid input. Please enter a valid number.")

    def withdraw_money(self):
        """Allows the user to withdraw money after checking for sufficient funds."""
        try:
            amount = float(input("Enter the amount to withdraw: "))
            if self.account.withdraw(amount):
                print(f"Successfully withdrew ${amount:.2f}. Your new balance is: ${self.account.get_balance():.2f}")
            else:
                print("Invalid withdrawal amount or insufficient balance.")
        except ValueError:
            print("Invalid input. Please enter a valid number.")

def main():
    """Main function to initialize the bank account and ATM, then run the ATM."""
    account = BankAccount(1000)  # Starting with an initial balance
    atm_machine = ATM(account)
    atm_machine.run()

if __name__ == "__main__":
    main()
