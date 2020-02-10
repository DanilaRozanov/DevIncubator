package Entity;

public class Account {
    private int account_Id;
    private int account;
    private int user_Id;

    public Account() {
    }

    public Account(int account_Id, int account, int user_Id) {
        this.account_Id = account_Id;
        this.account = account;
        this.user_Id = user_Id;
    }

    public int getAccount_Id() {
        return account_Id;
    }

    public void setAccount_Id(int account_Id) {
        this.account_Id = account_Id;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public int getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(int user_Id) {
        this.user_Id = user_Id;
    }

}