package cn.eight.homemaking.pojo;

public class OrderTest {
    private int order_number;
    private String employer_name;
    private int interveningact;
    private String completiondate;
    private String worker_name;
    private String company_name;

    public OrderTest() {
    }

    public OrderTest(int order_number, String employer_name, int interveningact, String completiondate, String worker_name, String company_name) {
        this.order_number = order_number;
        this.employer_name = employer_name;
        this.interveningact = interveningact;
        this.completiondate = completiondate;
        this.worker_name = worker_name;
        this.company_name = company_name;
    }

    public int getOrder_number() {
        return order_number;
    }

    public void setOrder_number(int order_number) {
        this.order_number = order_number;
    }

    public String getEmployer_name() {
        return employer_name;
    }

    public void setEmployer_name(String employer_name) {
        this.employer_name = employer_name;
    }

    public int getInterveningact() {
        return interveningact;
    }

    public void setInterveningact(int interveningact) {
        this.interveningact = interveningact;
    }

    public String getCompletiondate() {
        return completiondate;
    }

    public void setCompletiondate(String completiondate) {
        this.completiondate = completiondate;
    }

    public String getWorker_name() {
        return worker_name;
    }

    public void setWorker_name(String worker_name) {
        this.worker_name = worker_name;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }
}



