package com.splitter;

import android.content.Context;

import com.splitter.model.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ContactLab {
    private static ContactLab sContactLab;



    //private Context mContext;
    private List<Contact> mContacts;

    public static ContactLab get(Context context) {
        if (sContactLab == null)
            sContactLab = new ContactLab(context);

        return sContactLab;
    }

    private ContactLab(Context context) {
        mContacts = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Contact contact = new Contact("Contact #" + i);
            mContacts.add(contact);
        }
        //mContext = context.getApplicationContext();
    }

    public List<Contact> getContacts() {
        return mContacts;
    }

    public Contact getContact(String login) {
        for (Contact contact : mContacts)
            if (contact.getLogin().equals(login))
                return contact;

        return null;
    }
}
