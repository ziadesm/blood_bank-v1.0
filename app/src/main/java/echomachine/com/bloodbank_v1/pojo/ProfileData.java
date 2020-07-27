package echomachine.com.bloodbank_v1.pojo;

public class ProfileData {
    private String name;
    private String email;
    private String birth_date;
    private int city_id;
    private String phone;
    private String donation_last_date;
    private String password;
    private String password_confirmation;
    private int blood_type_id;
    private String api_token;

    // Edit profile data
    public ProfileData(String name,
                       String email,
                       String birth_date,
                       int city_id,
                       String phone,
                       String donation_last_date,
                       String password,
                       String password_confirmation,
                       int blood_type_id,
                       String api_token) {
        this.name = name;
        this.email = email;
        this.birth_date = birth_date;
        this.city_id = city_id;
        this.phone = phone;
        this.donation_last_date = donation_last_date;
        this.password = password;
        this.password_confirmation = password_confirmation;
        this.blood_type_id = blood_type_id;
        this.api_token = api_token;
    }
    // Register new user into system
    public ProfileData(String name,
                       String email,
                       String birth_date,
                       int city_id,
                       String phone,
                       String donation_last_date,
                       String password,
                       String password_confirmation,
                       int blood_type_id) {
        this.name = name;
        this.email = email;
        this.birth_date = birth_date;
        this.city_id = city_id;
        this.phone = phone;
        this.donation_last_date = donation_last_date;
        this.password = password;
        this.password_confirmation = password_confirmation;
        this.blood_type_id = blood_type_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDonation_last_date() {
        return donation_last_date;
    }

    public void setDonation_last_date(String donation_last_date) {
        this.donation_last_date = donation_last_date;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword_confirmation() {
        return password_confirmation;
    }

    public void setPassword_confirmation(String password_confirmation) {
        this.password_confirmation = password_confirmation;
    }

    public int getBlood_type_id() {
        return blood_type_id;
    }

    public void setBlood_type_id(int blood_type_id) {
        this.blood_type_id = blood_type_id;
    }

    public String getApi_token() {
        return api_token;
    }

    public void setApi_token(String api_token) {
        this.api_token = api_token;
    }
}
