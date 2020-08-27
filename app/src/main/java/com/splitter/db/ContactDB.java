package com.splitter.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.splitter.model.Contact;

//Это пространство бд

@Database(entities = {Contact.class},version = 2,exportSchema = false)
public abstract class ContactDB extends RoomDatabase {
    public abstract ContactDao contactDao();
}
