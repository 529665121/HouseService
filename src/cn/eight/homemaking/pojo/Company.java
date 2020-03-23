package cn.eight.homemaking.pojo;

public class Company {
    private int company_number;
    private String company_account;
    private String company_name;
    private String instruction;

    public Company() {
    }

    public Company(int company_number, String company_account, String company_name, String instruction) {
        this.company_number = company_number;
        this.company_account = company_account;
        this.company_name = company_name;
        this.instruction = instruction;
    }

    public int getCompany_number() {
        return company_number;
    }

    public void setCompany_number(int company_number) {
        this.company_number = company_number;
    }

    public String getCompany_account() {
        return company_account;
    }

    public void setCompany_account(String company_account) {
        this.company_account = company_account;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }
}
