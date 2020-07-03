package snack.bean;

import java.io.Serializable;

public class UserBean implements Serializable {

    //UserBeanのすべての値
    private int id;
    private String firstName;
    private String lastName;
    private String firstNameFurigana;
    private String lastNameFurigana;
    private String email;
    private String password;
    private String type;
    private String postalCode;
    private String address;
    private String phoneNumber;

    //全ての値のgetter&setter
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFirstNameFurigana() {
        return firstNameFurigana;
    }
    public void setFirstNameFurigana(String firstNameFurigana) {
        this.firstNameFurigana = firstNameFurigana;
    }
    public String getLastNameFurigana() {
        return lastNameFurigana;
    }
    public void setLastNameFurigana(String lastNameFurigana) {
        this.lastNameFurigana = lastNameFurigana;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
