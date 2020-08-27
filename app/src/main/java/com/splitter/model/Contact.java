package com.splitter.model;

import android.content.Context;
import android.provider.ContactsContract;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;
import java.util.UUID;

@Entity(tableName = "contacts_table") // here Room annotation
public class Contact {

    @PrimaryKey(autoGenerate = true) // Первичный ключ, который говорит, чтобы бд автоинкрементом
                                     // генерировала значение для каждого Entity класса.
    private int id;
    private String login;
    //private String url;

    public Contact(String login) {
        this.login = login;
        //this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

}
