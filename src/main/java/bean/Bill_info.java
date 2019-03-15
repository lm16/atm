package bean;

import java.util.Date;

public class Bill_info {

    private int b_Id;
    private Date b_time;
    private String b_sun;
    private String u_account;
    private String Balance;

    public int getB_Id() {
        return b_Id;
    }

    public void setB_Id(int b_Id) {
        this.b_Id = b_Id;
    }

    public Date getB_time() {
        return b_time;
    }

    public void setB_time(Date b_time) {
        this.b_time = b_time;
    }

    public String getB_sun() {
        return b_sun;
    }

    public void setB_sun(String b_sun) {
        this.b_sun = b_sun;
    }

    public String getU_account() {
        return u_account;
    }

    public void setU_account(String u_account) {
        this.u_account = u_account;
    }

    public String getBalance() {
        return Balance;
    }

    public void setBalance(String balance) {
        Balance = balance;
    }
}
