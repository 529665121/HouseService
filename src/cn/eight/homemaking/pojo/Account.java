package cn.eight.homemaking.pojo;

public class Account {
    private Integer account_id;
    private String accountcode;//账号
    private String username;
    private String email;
    private String password;
    private String enable;
    private String level;
    private Integer belong;

    public Account() {
    }

    public Account(Integer account_id, String accountcode, String username, String email, String password, String enable, String level, Integer belong) {
        this.account_id=account_id;
        this.accountcode = accountcode;
        this.username = username;
        this.email = email;
        this.password = password;
        this.enable = enable;
        this.level = level;
        this.belong = belong;
    }

    public Integer getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Integer account_id) {
        this.account_id = account_id;
    }

    public String getAccountcode() {
        return accountcode;
    }

    public void setAccountcode(String accountcode) {
        this.accountcode = accountcode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getBelong() {
        return belong;
    }

    public void setBelong(Integer belong) {
        this.belong = belong;
    }
}