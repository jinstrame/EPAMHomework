package multithreading.task01.variant2;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import multithreading.task01.Account;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@RequiredArgsConstructor
@Getter
public class AccountConcurent implements Account {
    private final int accountNumber;
    private int balance = 100000;

    public AccountConcurent(int accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    private Lock lock = new ReentrantLock();

    public void deposit(int money){
        proceed(money);
    }

    public void withdraw(int money){
        proceed(-money);
    }

    private void proceed(int money){
        lock.lock();
        balance+=money;
        lock.unlock();
    }
}