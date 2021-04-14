package phong.atm;

public interface Exchange {
    String ACCOUNT = "A";
    String DEPOSIT = "D";
    String WITHDRAWAL = "W";
    String HISTORY = "H";
    String EXIT = "X";
    void checkAccount();
    void setDeposit();
    void setWithdrawal();
    void checkHistory();
}
