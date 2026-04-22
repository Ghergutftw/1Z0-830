package advancedLockingMechanism;

public class StampedLockExample {

    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        Runnable depositTask = () ->{
            for (int i = 0; i < 3; i++) {
                account.deposit(100.00);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable withdrawTask = () -> {
            for (int i = 0; i < 3; i++) {
                account.withdraw(50);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable readTask = () -> {
            for (int i = 0; i < 3; i++) {
                account.getBalanceOptimistic();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread depositorThread = new Thread(depositTask , "depozitor");
        Thread withdrawThread = new Thread(withdrawTask , "withdrawer");
        Thread readThread = new Thread(readTask , "reader");

        depositorThread.start();
        withdrawThread.start();
        readThread.start();

        try {
            depositorThread.join();
            withdrawThread.join();
            readThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Final Balance : " + account.getBalance());


    }

}
