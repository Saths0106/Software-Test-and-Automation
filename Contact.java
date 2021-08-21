package com.example.contactservicematthewjenks;



public class Contact {
    //logic for valid values for this class was put into ContactService.java so this class can be simple
    // required strings to fill out the contact, a constructor, and getters and setters
    private String mContactId;
    private String mFirstName;
    private String mLastName;
    private String mPhoneNumber;
    private String mAddress;

    Contact(String id, String firstName, String lastName, String phoneNumber, String address) {
        mContactId = id;
        mFirstName = firstName;
        mLastName = lastName;
        mPhoneNumber = phoneNumber;
        mAddress = address;
    }
    public String getId(){
        return mContactId;
    }

    public String getFirstName(){
        return mFirstName;
    }

    public String getLastName(){
        return mLastName;
    }

    public String getPhoneNumber(){
        return mPhoneNumber;
    }

    public String getAddress(){
        return mAddress;
    }

    public void setFirstName(String firstName){
        mFirstName = firstName;
    }

    public void setLastName(String lastName){
        mLastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber){
        mPhoneNumber = phoneNumber;
    }

    public void setAddress(String address){
        mAddress = address;
    }
}
