package cn.eight.homemaking.pojo;

public class OrderForm {
    private int order_number;
    private String company_name;
    private String consume_type;
    private int consume_count;
    private String consume_time;

    public OrderForm() {
    }

    public OrderForm(int order_number, String company_name, String consume_type, int consume_count, String consume_time) {
        this.order_number = order_number;
        this.company_name = company_name;
        this.consume_type = consume_type;
        this.consume_count = consume_count;
        this.consume_time = consume_time;
    }

    public int getOrder_number() {
        return order_number;
    }

    public void setOrder_number(int order_number) {
        this.order_number = order_number;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getConsume_type() {
        return consume_type;
    }

    public void setConsume_type(String consume_type) {
        this.consume_type = consume_type;
    }

    public int getConsume_count() {
        return consume_count;
    }

    public void setConsume_count(int consume_count) {
        this.consume_count = consume_count;
    }

    public String getConsume_time() {
        return consume_time;
    }

    public void setConsume_time(String consume_time) {
        this.consume_time = consume_time;
    }
}
