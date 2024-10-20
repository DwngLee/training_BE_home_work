package org.example;

public class Main {
    public static void main(String[] args) {
        BankAccount sharedAccount = new BankAccount(1000);
        Thread thread2 = new Thread(new User("Bob", sharedAccount, false, 200), "Bob");
        Thread thread5 = new Thread(new User("Eve", sharedAccount, true, 300), "Eve");
        Thread thread1 = new Thread(new User("Alice", sharedAccount, true, 100), "Alice");

        Thread thread3 = new Thread(new User("Charlie", sharedAccount, true, 200), "Charlie");
        Thread thread4 = new Thread(new User("David", sharedAccount, false, 300), "David");

        Thread thread6 = new Thread(new User("Frank", sharedAccount, false, 400), "Frank");
        Thread thread7 = new Thread(new User("Grace", sharedAccount, true, 400), "Grace");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();

        try {
            // Đợi cho tất cả các thread hoàn thành
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
            thread6.join();
            thread7.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // In ra số dư còn lại sau khi tất cả các giao dịch hoàn tất
        System.out.println("Final balance: " + sharedAccount.getBalance());
    }
}