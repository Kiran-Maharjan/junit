package com.kiran;

public class Contact {
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Contact(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void validateFistName(){
        if(this.firstName.isBlank()){
        throw new RuntimeException("fist name cannot be null or empty");
        }
    }
    public void validateLastName(){
        if(this.lastName.isBlank()){
            throw new RuntimeException("last name cannot be null or empty");
        }
    }
    public void validatePhoneNumber(){
        if(this.lastName.isBlank()){
            throw new RuntimeException("phone number cannot be null or empty");
        }
        if(this.phoneNumber.length()!=10){
            throw new RuntimeException("phone number must be 10 digit");
        }
        if(!this.phoneNumber.startsWith("0")){
            throw new RuntimeException("phone number must be started with 0 digit");
        }
        if(!this.phoneNumber.matches("\\d+")){
            throw new RuntimeException("phone number must be contain digit");
        }
    }
}
