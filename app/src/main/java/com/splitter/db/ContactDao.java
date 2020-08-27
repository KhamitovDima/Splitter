package com.splitter.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.splitter.model.Contact;

import java.util.List;

@Dao
public interface ContactDao { // here db interactions

    @Insert
    void insertContact(Contact contact);

    @Query("DELETE FROM contacts_table WHERE login = :contactLogin")
    void deleteContact(String contactLogin);

    @Query("DELETE FROM contacts_table")
    void deleteAll();

    @Query("SELECT * FROM contacts_table")
    LiveData<List<Contact>> getContacts();
}
