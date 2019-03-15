package bean;

public class User_info {
    private String u_account;
    private String u_pwd;
    private String u_dentity;
    private String TrueName;
    private String Phone;
    private String BankCard;

    public String getU_account() {
        return u_account;
    }

    public void setU_account(String u_account) {
        this.u_account = u_account;
    }

    public String getU_pwd() {
        return u_pwd;
    }

    public void setU_pwd(String u_pwd) {
        this.u_pwd = u_pwd;
    }

    public String getU_dentity() {
        return u_dentity;
    }

    public void setU_dentity(String u_dentity) {
        this.u_dentity = u_dentity;
    }

    public String getTrueName() {
        return TrueName;
    }

    public void setTrueName(String trueName) {
        TrueName = trueName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getBankCard() {
        return BankCard;
    }

    public void setBankCard(String bankCard) {
        BankCard = bankCard;
    }
}
