package multithreading.task01;

import multithreading.task01.variant1.AccountSynchronized;
import multithreading.task01.variant2.AccountConcurent;
import org.junit.Test;

import java.util.LinkedList;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

@SuppressWarnings("Duplicates")
public class OperationExecutorTest {

    @Test
    public void variantOneSyncTest(){
        Account acc1 = new AccountSynchronized(1);
        Account acc2 = new AccountSynchronized(2);
        Account acc3 = new AccountSynchronized(3);
        LinkedList<Account> accounts= new LinkedList<>();
        accounts.add(acc1);
        accounts.add(acc2);
        accounts.add(acc3);

        OperationExecutor operationExecutor = new OperationExecutor();
        operationExecutor.operate(accounts, "src\\test\\resources\\accountOperations.txt");

        operationExecutor.synchronize();
        System.out.println(acc1.getBalance());
        System.out.println(acc2.getBalance());
        System.out.println(acc2.getBalance());

        assertThat(acc1.getBalance(), equalTo(acc2.getBalance()));
        assertThat(acc3.getBalance(), equalTo(acc2.getBalance()));
    }



    @Test
    public void variantTwoSyncTest(){
        Account acc1 = new AccountConcurent(1);
        Account acc2 = new AccountConcurent(2);
        Account acc3 = new AccountConcurent(3);
        LinkedList<Account> accounts= new LinkedList<>();
        accounts.add(acc1);
        accounts.add(acc2);
        accounts.add(acc3);

        OperationExecutor operationExecutor = new OperationExecutor();
        operationExecutor.operate(accounts, "src\\test\\resources\\accountOperations.txt");

        operationExecutor.synchronize();
        System.out.println(acc1.getBalance());
        System.out.println(acc2.getBalance());
        System.out.println(acc2.getBalance());

        assertThat(acc1.getBalance(), equalTo(acc2.getBalance()));
        assertThat(acc3.getBalance(), equalTo(acc2.getBalance()));

    }


}