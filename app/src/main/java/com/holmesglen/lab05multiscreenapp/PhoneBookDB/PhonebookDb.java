package com.holmesglen.lab05multiscreenapp.PhoneBookDB;

import android.util.Log;

import com.holmesglen.lab05multiscreenapp.Models.Contact;

import java.util.ArrayList;

// refer to https://www.geeksforgeeks.org/singleton-class-java/
// Java program implementing Singleton class
// with getInstance() method
public class PhonebookDb {
    private final String TAG = this.getClass().getSimpleName();

    // static variable single_instance of type Singleton
    private static PhonebookDb db_instance = null;

    // variable of type ArrayList
    private ArrayList<Contact> phonebook;

    public static int getNumberOfContact(){
        return PhonebookDb.getInstance().phonebook.size();
    }
    // private constructor restricted to this class itself
    private PhonebookDb()
    {
        phonebook = new ArrayList<Contact>();

        phonebook.add(new Contact("Qiao1 Li", "123456"));
        phonebook.add(new Contact("Qiao2 Li", "123456"));
        phonebook.add(new Contact("Qiao3 Li", "123456"));
        phonebook.add(new Contact("Qiao4 Li", "123456"));
    }

    // static method to create instance of Singleton class
    public static PhonebookDb getInstance()
    {
        if (db_instance == null)
            db_instance = new PhonebookDb();

        return db_instance;
    }

    // add a element to the end of list
    public void addContact(Contact newContact) {
        phonebook.add(newContact);
        return;
    }

    // dump db data to logcat for debug purpose
    public void dumpDB() {
        Log.d(TAG, "Dump phonebook data ");
        if (phonebook == null) {
            Log.d(TAG, "db not initialized");
        } else {
            Log.d(TAG, "number of contact: " + phonebook.size());
            for (int i = 0; i < phonebook.size(); i++){
                Contact c = phonebook.get(i);
                Log.d(TAG, "(" + i + ") Name: " + c.getName() +
                        "; Email: " + c.getPhone());
            }
        }
        return;
    }
}