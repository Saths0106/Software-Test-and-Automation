package com.example.contactservicematthewjenks;

import org.junit.Test;

public class ContactTest {
    ContactService mContactService = new ContactService();

    @Test
    public void contactValues(){
        mContactService.addContact("TEST", "TEST2", "TESTING", "TESTING123");
        for (Object key : mContactService.getContactMap().keySet()) {
            Contact contact = (Contact) mContactService.getContactMap().get(String.valueOf(key));
            assert (contact.getFirstName().equals("TEST") && contact.getLastName().equals("TEST2")
                    && contact.getPhoneNumber().equals("TESTING") && contact.getAddress().equals("TESTING123"));
        }

    }
}
