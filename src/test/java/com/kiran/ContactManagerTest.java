package com.kiran;

import org.junit.jupiter.api.*;


class ContactManagerTest {
    ContactManager contactManager;

    @BeforeAll
    public static void setupAll(){
        System.out.printf("before all");
    }

    @BeforeEach
    public  void setupEach(){
        contactManager=new ContactManager();
        System.out.println("initialized");
    }

    @Test
    public void shouldCreateContact(){
//        ContactManager contactManager=new ContactManager();
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

    @Test
    @DisplayName("Should not create contact when first name is null")
    public void shouldThrowRunTimeExceptionWhenFirstNameIsNull(){

        Assertions.assertThrows(RuntimeException.class,()->{
//            new ContactManager().addContacts(new Contact(null,"maharjan","0123456789"));
            contactManager.addContacts(new Contact(null,"maharjan","0123456789"));
        });
    }

    @Test
    @DisplayName("Last name must not be null")
    public void shouldThrowRunTimeExceptionWhenLastNameIsNull(){
        Assertions.assertThrows(RuntimeException.class,()->{
//        new RuntimeException();
//            new ContactManager().addContacts(new Contact("firstname",null,"132"));
            contactManager.addContacts(new Contact("firstname",null,"132"));
        });
    }

    @Test
    @DisplayName("Phone number must not be null")
    public void shouldThrowRunTimeExceptionWhenNumberIsNull(){
        Assertions.assertThrows(RuntimeException.class,()-> {
//            new ContactManager().addContact("firstname", "lastname", null);
            contactManager.addContact("firstname", "lastname", null);
        });
    }
    @AfterEach
    public void tearDown(){
        System.out.printf("Should execute after each test");
    }
    @AfterAll
    public static void tearDownAll(){
        System.out.printf("Should be executed at the end of the test");
    }
}