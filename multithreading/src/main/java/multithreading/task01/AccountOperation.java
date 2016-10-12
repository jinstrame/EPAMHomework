package multithreading.task01;


import lombok.AllArgsConstructor;

@SuppressWarnings("WeakerAccess")
@AllArgsConstructor
public class AccountOperation implements Runnable {
    private Account account1;
    private Account account2;
    private int money;

    @Override
    public void run() {
        account1.withdraw(money);
        account2.deposit(money);
    }
}
