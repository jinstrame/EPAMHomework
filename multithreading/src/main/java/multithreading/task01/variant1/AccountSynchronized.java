package multithreading.task01.variant1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import multithreading.task01.Account;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
public class AccountSynchronized implements Account {
    private final int accountNumber;
    private int balance = 100000;

    public void deposit(int money){
        proceed(money);
    }

    public void withdraw(int money){
        proceed(-money);
    }

    private void proceed(int money){
        synchronized (this) {
            balance += money;
        }
    }
}
