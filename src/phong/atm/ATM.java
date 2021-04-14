package phong.atm;
import java.util.*;

public class ATM implements Exchange {
    String nameATM;
    User a;
    public ATM(String nameATM,User a) {
        this.nameATM = nameATM;
        this.a = a;
    }

    public String getNameATM() {
        return nameATM;
    }

    Scanner scanner = new Scanner(System.in);
    ArrayList history = new ArrayList();

    @Override
    public void checkAccount() {
        System.out.println("So du tai khoan cua khach hang la: " + a.getBalance() + "vnd \n"
                            + "Bam nut theo menu de tiep tuc giao dich \n"
                            + "========================================================");
    }

    @Override
    public void setDeposit() {
        System.out.println("Giao dich Nap tien");
        System.out.println("Vui long nhap so tien:");
        long moneyDeposit = scanner.nextLong();
        a.setBalance(a.getBalance()+moneyDeposit);
        history.add("Nap tien: " + moneyDeposit + " vnd");
        System.out.println("Giao dich thanh cong. Ban vua nap " + moneyDeposit + " thanh cong");
        System.out.println("So du tai khoan khach hang la: " + a.getBalance() + " vnd \n"
                            + "Bam nut theo menu de tiep tuc giao dich \n"
                            + "========================================================");
    }

    @Override
    public void setWithdrawal() {
        System.out.println("Giao dich Rut tien");
        System.out.println("Vui long nhap so tien:");
        long moneyWithdrawal = scanner.nextLong();
        if (moneyWithdrawal <= a.getBalance()) {
            a.setBalance(a.getBalance() - moneyWithdrawal);
            history.add("Rut tien: " + moneyWithdrawal + " vnd");
            System.out.println("Giao dich thanh cong. Ban vua rut " + moneyWithdrawal + " thanh cong");
            System.out.println("So du tai khoan khach hang la: " + a.getBalance() + " vnd \n"
                                + "Bam nut theo menu de tiep tuc giao dich \n"
                                + "========================================================");
        }
        else {
            System.out.println("Giao dich khong thanh cong \n"
                                + "So du tai khoan khach hang la: " + a.getBalance() + " vnd \n"
                                + "Ban khong the rut so tien hon so du tai khoan. \n"
                                + "Bam nut theo menu de tiep tuc giao dich \n"
                                + "========================================================");
        }
    }

    @Override
    public void checkHistory() {
        int count = 1;
        System.out.println("Lich su giao dich:");
        for (int i = history.size() -1; i > history.size() -4 && i >= 0; i--) {
            System.out.println(count++ + ". " + history.get(i));
        }
        System.out.println("Bam nut theo menu de tiep tuc giao dich \n"
                            + "========================================================");
    }

    public void menu() {
        System.out.println("Ngan hang " + getNameATM() + " kinh chao Quy khach " + a.getName()
                            + "\n"
                            + "Menu: \n"
                            + "1. Nhan phim A de kiem tra tai khoan \n"
                            + "2. Nhan phim D de nap tien \n"
                            + "3. Nhan phim W de rut tien \n"
                            + "4. Nhan phim H de xem lich su 3 lan \n"
                            + "5. Nhan phim X de thoat \n"
                            + "======================================================== \n"
                            + "Nhap lua chon cua ban:");
    }

    public void useATM() {
        do {
            menu();
            String choice = a.getUserChoice();
            switch (choice) {
                case Exchange.ACCOUNT:
                    checkAccount();
                    break;
                case Exchange.DEPOSIT:
                    setDeposit();
                    break;
                case Exchange.WITHDRAWAL:
                    setWithdrawal();
                    break;
                case Exchange.HISTORY:
                    checkHistory();
                    break;
                case Exchange.EXIT:
                    System.out.println("Cam on ban da su dung dich vu ATM");
                    System.exit(0);
                default:
                    System.out.println("Ban nhap sai chuc nang \n"
                                        + "Bam nut theo menu de tiep tuc giao dich \n"
                                        + "========================================================");
            }
        }
        while (true);
    }
}
