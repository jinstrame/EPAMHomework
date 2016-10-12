package multithreading.task01;

public interface Account {
    int getAccountNumber();
    int getBalance();
    void deposit(int money);
    void withdraw(int money);
}
