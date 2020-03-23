package cn.eight.homemaking.pojo;

public class Xfcx {
    String company_name;
    String user_name;
    String record_time;
    String charge;

    public Xfcx(String company_name, String user_name, String record_time, String charge) {
        this.company_name = company_name;
        this.user_name = user_name;
        this.record_time = record_time;
        this.charge = charge;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getRecord_time() {
        return record_time;
    }

    public void setRecord_time(String record_time) {
        this.record_time = record_time;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }
}
