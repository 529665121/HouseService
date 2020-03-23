package cn.eight.homemaking.pojo;

import java.util.Date;

public class Worker {
    private Integer worker_number;
    private Integer company_number;
    private String worker_name;
    private String gender;
    private String idnumber;
    private String birthday;
    private Integer age;
    private Integer height;
    private String mobile_phone;
    private String telephone;
    private String work_type;
    private String work_time;
    private String disadvantage;
    private String photo;
    private String address;
    private String current_address;
    private String bankcard;
    private String insurance;
    private String language;//
    private String status;
    private String marital;
    private String license;
    private String check_up;
    private String check_up_time;
    private String skill;
    private String introduction;
    private String req_time;
    private String req_pay;
    private String stay_room;
    private String food;
    private String entry_time;
    private Integer belong;
    private String index;

    public Worker() {
    }

    public Worker(Integer worker_number, Integer company_number,String worker_name, String gender, String idnumber, String birthday, Integer age, Integer height, String mobile_phone, String telephone, String work_type, String work_time, String disadvantage, String photo, String address, String current_address, String bankcard, String insurance, String language, String status, String marital, String license, String check_up, String check_up_time, String skill, String introduction, String req_time, String req_pay, String stay_room, String food, String entry_time, Integer belong) {
        this.worker_number = worker_number;
        this.company_number = company_number;
        this.worker_name = worker_name;
        this.gender = gender;
        this.idnumber = idnumber;
        this.birthday = birthday;
        this.age = age;
        this.height = height;
        this.mobile_phone = mobile_phone;
        this.telephone = telephone;
        this.work_type = work_type;
        this.work_time = work_time;
        this.disadvantage = disadvantage;
        this.photo = photo;
        this.address = address;
        this.current_address = current_address;
        this.bankcard = bankcard;
        this.insurance = insurance;
        this.language = language;
        this.status = status;
        this.marital = marital;
        this.license = license;
        this.check_up = check_up;
        this.check_up_time = check_up_time;
        this.skill = skill;
        this.introduction = introduction;
        this.req_time = req_time;
        this.req_pay = req_pay;
        this.stay_room = stay_room;
        this.food = food;
        this.entry_time = entry_time;
        this.belong = belong;
    }

    public Integer getWorker_number() {
        return worker_number;
    }

    public void setWorker_number(Integer worker_number) {
        this.worker_number = worker_number;
    }

    public Integer getCompany_number() {
        return company_number;
    }

    public void setCompany_number(Integer company_number) {
        this.company_number = company_number;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getWorker_name() {
        return worker_name;
    }

    public void setWorker_name(String worker_name) {
        this.worker_name = worker_name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getMobile_phone() {
        return mobile_phone;
    }

    public void setMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getWork_type() {
        return work_type;
    }

    public void setWork_type(String work_type) {
        this.work_type = work_type;
    }

    public String getWork_time() {
        return work_time;
    }

    public void setWork_time(String work_time) {
        this.work_time = work_time;
    }

    public String getDisadvantage() {
        return disadvantage;
    }

    public void setDisadvantage(String disadvantage) {
        this.disadvantage = disadvantage;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCurrent_address() {
        return current_address;
    }

    public void setCurrent_address(String current_address) {
        this.current_address = current_address;
    }

    public String getBankcard() {
        return bankcard;
    }

    public void setBankcard(String bankcard) {
        this.bankcard = bankcard;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMarital() {
        return marital;
    }

    public void setMarital(String marital) {
        this.marital = marital;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getCheck_up() {
        return check_up;
    }

    public void setCheck_up(String check_up) {
        this.check_up = check_up;
    }

    public String getCheck_up_time() {
        return check_up_time;
    }

    public void setCheck_up_time(String check_up_time) {
        this.check_up_time = check_up_time;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getReq_time() {
        return req_time;
    }

    public void setReq_time(String req_time) {
        this.req_time = req_time;
    }

    public String getReq_pay() {
        return req_pay;
    }

    public void setReq_pay(String req_pay) {
        this.req_pay = req_pay;
    }

    public String getStay_room() {
        return stay_room;
    }

    public void setStay_room(String stay_room) {
        this.stay_room = stay_room;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getEntry_time() {
        return entry_time;
    }

    public void setEntry_time(String entry_time) {
        this.entry_time = entry_time;
    }

    public Integer getBelong() {
        return belong;
    }

    public void setBelong(Integer belong) {
        this.belong = belong;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }
}