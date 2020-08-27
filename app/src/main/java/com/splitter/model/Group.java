package com.splitter.model;

import android.content.Context;

import java.util.Date;
import java.util.UUID;

public class Group {

    private UUID mId;
    private String mTitle;
    private Date mDate;

    public Group() {this(UUID.randomUUID());}

    public Group(UUID id) {
        mId = id;
        mDate = new Date();
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public UUID getId() {
        return mId;
    }

    public void setId(UUID id) {
        mId = id;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }
}
