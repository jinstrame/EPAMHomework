package multithreading.task01;

import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;

@SuppressWarnings("WeakerAccess")
@NoArgsConstructor
public class Accounts {
    private HashMap<Integer, Account> accounts = new HashMap<>();

    public Accounts(List<? extends Account> collection){
        for (Account acc : collection)
            accounts.put(acc.getAccountNumber(), acc);
    }


    public Account getAccount (int accountNumber){
        return accounts.get(accountNumber);
    }

    public void addAccount(Account account){
        accounts.put(account.getAccountNumber(), account);
    }



}
