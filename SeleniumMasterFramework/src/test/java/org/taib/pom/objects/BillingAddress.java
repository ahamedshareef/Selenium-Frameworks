package org.taib.pom.objects;

public class BillingAddress {
    private String firstName;
    private String lastName;
    private String country;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private String emailAddress;

    public BillingAddress(){}

    public BillingAddress(String firstName, String lastName, String country,
                          String streetAddress, String city, String state,
                          String zipCode, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.emailAddress = emailAddress;
    }

    public BillingAddress setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public BillingAddress setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }


    public BillingAddress setCountry(String country) {
        this.country = country;
        return this;
    }

    public BillingAddress setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
        return this;
    }



    public BillingAddress setCity(String city) {
        this.city = city;
        return this;
    }

    public BillingAddress setState(String state) {
        this.state = state;
        return this;
    }

    public BillingAddress setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public BillingAddress setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }







//    public BillingAddress(String firstName, String lastName, String companyName, String country,
//                          String streetAddress, String apartment, String city, String state,
//                          String zipCode, String phoneNumber, String emailAddress) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.companyName = companyName;
//        this.country = country;
//        this.streetAddress = streetAddress;
//        this.apartment = apartment;
//        this.city = city;
//        this.state = state;
//        this.zipCode = zipCode;
//        this.phoneNumber = phoneNumber;
//        this.emailAddress = emailAddress;
//    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public String getCountry() {
        return country;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
