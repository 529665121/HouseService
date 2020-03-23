package cn.eight.homemaking.pojo;

import java.util.Date;

public class Employer {
    private String employer_number;
    private String company_number;
    private String employer_name;
    private String gender;
    private String age;
    private String nation;
    private String hometown;
    private String education;
    private String idnumber;
    private String worker_unit;
    private String profession;
    private String contract;
    private String period;
    private String telephone;
    private String mobile_phone;
    private String house;
    private String address;
    private String service_address;
    private String home_current_address;
    private String home_people_number;
    private String home_req;
    private String home_size;
    private String home_service;
    private String home_food;
    private String home_other;
    private String manager;
    private String check_in_time;
    private String min_pay;
    private String max_pay;
    private String claim;
    private String birthday;
    private String status_;


    public Employer() {
    }

    public Employer(String employer_number, String company_number, String employer_name, String gender, String age, String nation, String hometown, String education, String idnumber, String worker_unit, String profession, String contract, String period, String telephone, String mobile_phone, String house, String address, String service_address, String home_current_address, String home_people_number, String home_req, String home_size, String home_service, String home_food, String home_other, String manager, String check_in_time, String min_pay, String max_pay, String claim, String birthday) {
        this.employer_number = employer_number;
        this.company_number = company_number;
        this.employer_name = employer_name;
        this.gender = gender;
        this.age = age;
        this.nation = nation;
        this.hometown = hometown;
        this.education = education;
        this.idnumber = idnumber;
        this.worker_unit = worker_unit;
        this.profession = profession;
        this.contract = contract;
        this.period = period;
        this.telephone = telephone;
        this.mobile_phone = mobile_phone;
        this.house = house;
        this.address = address;
        this.service_address = service_address;
        this.home_current_address = home_current_address;
        this.home_people_number = home_people_number;
        this.home_req = home_req;
        this.home_size = home_size;
        this.home_service = home_service;
        this.home_food = home_food;
        this.home_other = home_other;
        this.manager = manager;
        this.check_in_time = check_in_time;
        this.min_pay = min_pay;
        this.max_pay = max_pay;
        this.claim = claim;
        this.birthday = birthday;
    }

    public Employer(String company_number, String employer_name, String gender, String age, String nation, String hometown, String education, String idnumber, String worker_unit, String profession, String contract, String period, String telephone, String house, String address, String service_address, String home_current_address, String home_people_number, String home_service, String home_size, String home_food, String home_other, String max_pay, String min_pay, String claim, String manager, String check_in_time) {
        this.company_number = company_number;
        this.employer_name = employer_name;
        this.gender = gender;
        this.age = age;
        this.nation = nation;
        this.hometown = hometown;
        this.education = education;
        this.idnumber = idnumber;
        this.worker_unit = worker_unit;
        this.profession = profession;
        this.contract = contract;
        this.period = period;
        this.telephone = telephone;

        this.house = house;
        this.address = address;
        this.service_address = service_address;
        this.home_current_address = home_current_address;
        this.home_people_number = home_people_number;

        this.home_size = home_size;
        this.home_service = home_service;
        this.home_food = home_food;
        this.home_other = home_other;
        this.manager = manager;
        this.check_in_time = check_in_time;
        this.min_pay = min_pay;
        this.max_pay = max_pay;
        this.claim = claim;


    }

    public Employer(String company_number, String employer_name, String gender, String age, String nation, String hometown, String education, String idnumber, String worker_unit, String profession, String contract, String period, String telephone, String house, String address, String service_address, String home_current_address, String home_people_number, String home_service, String home_size, String home_food, String home_other, String claim, String manager, String check_in_time) {
        this.company_number = company_number;
        this.employer_name = employer_name;
        this.gender = gender;
        this.age = age;
        this.nation = nation;
        this.hometown = hometown;
        this.education = education;
        this.idnumber = idnumber;
        this.worker_unit = worker_unit;
        this.profession = profession;
        this.contract = contract;
        this.period = period;
        this.telephone = telephone;
        this.house = house;
        this.address = address;
        this.service_address = service_address;
        this.home_current_address = home_current_address;
        this.home_size = home_size;
        this.home_service = home_service;
        this.home_food = home_food;
        this.home_other = home_other;
        this.manager = manager;
        this.check_in_time = check_in_time;
        this.claim = claim;
    }

    public String getEmployer_number() {
        return employer_number;
    }

    public void setEmployer_number(String employer_number) {
        this.employer_number = employer_number;
    }

    public String getCompany_number() {
        return company_number;
    }

    public void setCompany_number(String company_number) {
        this.company_number = company_number;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
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

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getWorker_unit() {
        return worker_unit;
    }

    public void setWorker_unit(String worker_unit) {
        this.worker_unit = worker_unit;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobile_phone() {
        return mobile_phone;
    }

    public void setMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getService_address() {
        return service_address;
    }

    public void setService_address(String service_address) {
        this.service_address = service_address;
    }

    public String getHome_current_address() {
        return home_current_address;
    }

    public void setHome_current_address(String home_current_address) {
        this.home_current_address = home_current_address;
    }

    public String getHome_people_number() {
        return home_people_number;
    }

    public void setHome_people_number(String home_people_number) {
        this.home_people_number = home_people_number;
    }

    public String getHome_req() {
        return home_req;
    }

    public void setHome_req(String home_req) {
        this.home_req = home_req;
    }

    public String getHome_size() {
        return home_size;
    }

    public void setHome_size(String home_size) {
        this.home_size = home_size;
    }

    public String getHome_service() {
        return home_service;
    }

    public void setHome_service(String home_service) {
        this.home_service = home_service;
    }

    public String getHome_food() {
        return home_food;
    }

    public void setHome_food(String home_food) {
        this.home_food = home_food;
    }

    public String getHome_other() {
        return home_other;
    }

    public void setHome_other(String home_other) {
        this.home_other = home_other;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getCheck_in_time() {
        return check_in_time;
    }

    public void setCheck_in_time(String check_in_time) {
        this.check_in_time = check_in_time;
    }

    public String getMin_pay() {
        return min_pay;
    }

    public void setMin_pay(String min_pay) {
        this.min_pay = min_pay;
    }

    public String getMax_pay() {
        return max_pay;
    }

    public void setMax_pay(String max_pay) {
        this.max_pay = max_pay;
    }

    public String getClaim() {
        return claim;
    }

    public void setClaim(String claim) {
        this.claim = claim;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getStatus_() {
        return status_;
    }

    public void setStatus_(String status_) {
        this.status_ = status_;
    }
}