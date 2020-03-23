package cn.eight.homemaking.pojo;

public class CompanyForm {
    private int company_number;
    private String  company_account;
    private String company_name;


    public CompanyForm() {
    }

    public CompanyForm(int company_number, String company_account, String company_name) {
        this.company_number = company_number;
        this.company_account = company_account;
        this.company_name = company_name;
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
}
