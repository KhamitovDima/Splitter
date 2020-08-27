package com.splitter.model;

import android.content.Intent;

import java.util.ArrayList;

public class ContactResponse {

    private Integer count;
    private String next, prev;
    private ArrayList<Contact> mContacts;

    public ContactResponse(Integer count, String next, String prev, ArrayList<Contact> contacts) {
        this.count = count;
        this.next = next;
        this.prev = prev;
        mContacts = contacts;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrev() {
        return prev;
    }

    public void setPrev(String prev) {
        this.prev = prev;
    }

    public ArrayList<Contact> getContacts() {
        return mContacts;
    }

    public void setContacts(ArrayList<Contact> contacts) {
        mContacts = contacts;
    }
}
