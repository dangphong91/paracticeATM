package phong.atm;

public class Test {
    public static void main(String[] args) {
        User userA = new User("Nguyen Van A", 1200000);
        ATM atmA = new ATM("ABC", userA);
        atmA.useATM();
    }
}
