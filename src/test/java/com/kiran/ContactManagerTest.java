package com.kiran;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactManagerTest {

    @Test
    public void shouldCreateContact(){
        ContactManager contactManager=new ContactManager();
        contactManager.addContact("kiran","maharjan","0123456789");
        Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
        Assertions.assertEquals(1,contactManager.getAllContacts().size());
        Assertions.assertTrue(contactManager.getAllContacts().stream()
                .filter(contact -> contact.getFirstName().equals("kiran")
                        && contact.getLastName().equals("maharjan")
                && contact.getPhoneNumber().equals("0123456789"))
                .findAny()
                .isPresent());
    }
}