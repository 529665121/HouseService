package cn.eight.homemaking.pojo;

public class RechargeQuery {
    private String company_name;
    private String user_name;
    private int recharge_times;
    private int charge;
    private int consume;
    private int blance;
    private int operator;
    private String explain;

    public RechargeQuery(String company_name, String user_name, int recharge_times, int charge, int consume, int blance, int operator, String explain) {
        this.company_name = company_name;
        this.user_name = user_name;
        this.recharge_times = recharge_times;
        this.charge = charge;
        this.consume = consume;
        this.blance = blance;
        this.operator = operator;
        this.explain = explain;
    }

    public RechargeQuery() {
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

    public int getRecharge_times() {
        return recharge_times;
    }

    public void setRecharge_times(int recharge_times) {
        this.recharge_times = recharge_times;
    }

    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }

    public int getConsume() {
        return consume;
    }

    public void setConsume(int consume) {
        this.consume = consume;
    }

    public int getBlance() {
        return blance;
    }

    public void setBlance(int blance) {
        this.blance = blance;
    }

    public int getOperator() {
        return operator;
    }

    public void setOperator(int operator) {
        this.operator = operator;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }
}
