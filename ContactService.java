package com.example.contactservicematthewjenks;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.logging.Logger;

public class ContactService {
    // at work we use TravisCI, this would not have initially passed. Variable name for mContactMap fixed in this iteration
    private Map<String, Contact> mContactMap = new HashMap<>();
    Logger logger = Logger.getAnonymousLogger();

    public void addContact(String firstName, String lastName, String phoneNumber, String address) {
        String contactId = getRandomContactId();
        if (firstName != null && lastName != null && phoneNumber != null && address != null
        && firstName.length() <= 10 && lastName.length() <=10 && phoneNumber.length() <=10 && address.length() <= 30) {
          // I had a while loop here, adding the ternary in getRandomContactId() makes the while loop unnecessary
            mContactMap.put(contactId, new Contact(contactId, firstName, lastName, phoneNumber, address));
        } else {
            logger.warning("None of the contact values can be null or greater than 10 characters, except address which can not be greater than 30 characters");
        }
    }
    public void deleteContact(String id) {
        //deletes the contact based on id, logger lets the user know if delete failed
        if (mContactMap.containsKey(id)) {
            mContactMap.remove(id);
        } else {
            logger.warning("Contact does not exist");
        }
    }
    public void updateContact(String id, String field, String value) {
        //this one has enough fields I should've used switch, but all these if else if still work
        //checks to ensure value is correct based on field and then updates the contact
        if (mContactMap.containsKey(id)) {
            if(value != null) {
                if (field.equalsIgnoreCase("first name") && value.length() <= 10) {
                    mContactMap.get(id).setFirstName(value);
                } else if (field.equalsIgnoreCase("last name") && value.length() <= 10) {
                    mContactMap.get(id).setLastName(value);
                } else if (field.equalsIgnoreCase("address") && value.length() <= 10){
                    mContactMap.get(id).setAddress(value);
                } else if (field.equalsIgnoreCase("phone number") && value.length() <= 10) {
                    mContactMap.get(id).setPhoneNumber(value);
                }
            } else {
                logger.warning("Value can not be null");
            }
        } else {
            logger.warning("Contact does not exist");
        }

    }

    public Map getContactMap() {
        //it is considered best practice to have private variables, using getters and setters to get/change them
        return mContactMap;
    }

    private String getRandomContactId() {
        //Once again I updated to include this ternary. Once I found the bug, it's good to apply the fix everywhere
        Random rand = new Random();
        int randomNumber = rand.nextInt(999999999);
        return mContactMap.containsKey(String.format("%10d", randomNumber)) ? getRandomContactId() : String.format("%10d", randomNumber);
    }

}
