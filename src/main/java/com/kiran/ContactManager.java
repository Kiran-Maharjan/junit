package com.kiran;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ContactManager {

    Map<String,Contact> contactList=new ConcurrentHashMap<String,Contact>();
    public void addContact(String firstName,String lastName, String phoneNumber){
        Contact contact=new Contact(firstName,lastName,phoneNumber);
        validateContact(contact);
        addContacts(contact);
    }

    private void validateContact(Contact contact) {
        contact.validateFistName();
        contact.validateLastName();
        contact.validatePhoneNumber();
    }
    public Collection<Contact> getAllContacts(){
        return contactList.values();
    }
    public void addContacts(Contact contact){
        contactList.put(generateKey(contact),contact);
    }

    public String generateKey(Contact contact){
        return String.format("%s-%s",contact.getFirstName(),contact.getLastName());
    }
}
