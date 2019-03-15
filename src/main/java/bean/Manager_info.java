package bean;

public class Manager_info {
    private String m_account;
    private String m_pwd;
    private String BlackList;
    private String Frozen;
    private String Loss;

    public String getM_account() {
        return m_account;
    }

    public void setM_account(String m_account) {
        this.m_account = m_account;
    }

    public String getM_pwd() {
        return m_pwd;
    }

    public void setM_pwd(String m_pwd) {
        this.m_pwd = m_pwd;
    }

    public String getBlackList() {
        return BlackList;
    }

    public void setBlackList(String blackList) {
        BlackList = blackList;
    }

    public String getFrozen() {
        return Frozen;
    }

    public void setFrozen(String frozen) {
        Frozen = frozen;
    }

    public String getLoss() {
        return Loss;
    }

    public void setLoss(String loss) {
        Loss = loss;
    }
}
