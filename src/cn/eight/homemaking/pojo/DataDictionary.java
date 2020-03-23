package cn.eight.homemaking.pojo;

public class DataDictionary {
    private int bastic_id;
    private String  bastic_name;
    private String bastic_type;

    public DataDictionary() {
    }

    public DataDictionary(int bastic_id, String bastic_name, String bastic_type) {
        this.bastic_id = bastic_id;
        this.bastic_name = bastic_name;
        this.bastic_type = bastic_type;
    }

    public int getBastic_id() {
        return bastic_id;
    }

    public void setBastic_id(int bastic_id) {
        this.bastic_id = bastic_id;
    }

    public String getBastic_name() {
        return bastic_name;
    }

    public void setBastic_name(String bastic_name) {
        this.bastic_name = bastic_name;
    }

    public String getBastic_type() {
        return bastic_type;
    }

    public void setBastic_type(String bastic_type) {
        this.bastic_type = bastic_type;
    }
}
