package cn.eight.homemaking.pojo;

public class QueryOrders {
    private String employer_name;
    private String gender;
    private int age;
    private String nation;
    private String hometown;
    private String education;
    private int idnumber;
    private int interveningact;

    private int worker_number;
    private String company_name;
    private String woker_name;
    private String birthday;


    private String expirydate;
    private String status;

    public QueryOrders() {
    }

    public QueryOrders(String employer_name, String gender, int age, String nation, String hometown, String education, int idnumber, int interveningact, int worker_number, String company_name, String woker_name, String birthday, String expirydate, String status) {
        this.employer_name = employer_name;
        this.gender = gender;
        this.age = age;
        this.nation = nation;
        this.hometown = hometown;
        this.education = education;
        this.idnumber = idnumber;
        this.interveningact = interveningact;
        this.worker_number = worker_number;
        this.company_name = company_name;
        this.woker_name = woker_name;
        this.birthday = birthday;
        this.expirydate = expirydate;
        this.status = status;
    }

    public String getEmployer_name() {
        return employer_name;
    }

    public void setEmployer_name(String employer_name) {
        this.employer_name = employer_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public int getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(int idnumber) {
        this.idnumber = idnumber;
    }

    public int getInterveningact() {
        return interveningact;
    }

    public void setInterveningact(int interveningact) {
        this.interveningact = interveningact;
    }

    public int getWorker_number() {
        return worker_number;
    }

    public void setWorker_number(int worker_number) {
        this.worker_number = worker_number;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getWoker_name() {
        return woker_name;
    }

    public void setWoker_name(String woker_name) {
        this.woker_name = woker_name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(String expirydate) {
        this.expirydate = expirydate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
