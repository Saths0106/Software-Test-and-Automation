package com.example.contactservicematthewjenks;


import org.junit.Test;

public class ContactServiceTest {
    private ContactService mContactService = new ContactService();

    @Test
    public void addContactTest() {
        mContactService.addContact("Matt", "Jenks", "8005552345", "1600 Pennsylvania Avenue");
        mContactService.addContact("dsahiaasaodoa", " j", "2125434544343", "address");
        assert(mContactService.getContactMap().size() == 1);
    }
    @Test
    public void updateContactTest() {
        for (Object key : mContactService.getContactMap().keySet()) {
            mContactService.updateContact(String.valueOf(key), "last name", "TEST123");
            Contact contact = (Contact) mContactService.getContactMap().get(String.valueOf(key));
            assert(contact.getLastName().equals("TEST123"));
        }

    }

    @Test
    public void deleteContactTest() {
       for (Object key : mContactService.getContactMap().keySet()) {
           mContactService.deleteContact(String.valueOf(key));
       }
        assert(mContactService.getContactMap().isEmpty());
    }


}
