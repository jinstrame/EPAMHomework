package multithreading.task01;

import lombok.Getter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("WeakerAccess")
public class OperationExecutor {

    @Getter
    ExecutorService executorService;

    public OperationExecutor(){
        executorService = Executors.newCachedThreadPool();
    }

    public  void operate(List<Account> accs, String file){
        Accounts accounts = new Accounts(accs);

        try(FileInputStream fis = new FileInputStream(file);
            Scanner scanner = new Scanner(fis)){
            while (scanner.hasNext()){
                int acc1 = scanner.nextInt();
                int acc2 = scanner.nextInt();
                int money = scanner.nextInt();

                Account account1 = accounts.getAccount(acc1);
                if (account1 == null)
                    continue;

                Account account2 = accounts.getAccount(acc2);
                if (account2 == null)
                    continue;

                executorService.execute(new AccountOperation(account1, account2, money));
            }
            executorService.shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void synchronize(){
        try {
            //noinspection StatementWithEmptyBody
            while (!executorService.awaitTermination(100, TimeUnit.MILLISECONDS)){}
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
