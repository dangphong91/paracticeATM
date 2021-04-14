package phong.atm;

import java.util.Scanner;

public class User {
    String name;
    long balance;

    Scanner scanner = new Scanner(System.in);

    public User(String name, long balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }
    public String getUserChoice() {
        return scanner.nextLine();
    }
}
