package com.splitter.repository;

import androidx.lifecycle.LiveData;

import com.splitter.db.ContactDao;
import com.splitter.model.Contact;
import com.splitter.model.ContactResponse;
import com.splitter.network.ContactApiService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;

public class Repository {

    private ContactDao mContactDao;
    private ContactApiService mContactApiService;

    @Inject
    public Repository(ContactDao contactDao, ContactApiService contactApiService) {
        mContactDao = contactDao;
        mContactApiService = contactApiService;
    }

    public Observable<ContactResponse> getContacts(){
        return mContactApiService.getContacts();
    }

    public void insertContact(Contact contact){
        mContactDao.insertContact(contact);
    }

    public void deleteContact(String ContactName){
        mContactDao.deleteContact(ContactName);
    }

    public void deleteAll(){
        mContactDao.deleteAll();
    }

    /*public LiveData<List<Contact>> getFavoritePokemon(){
        return mContactDao.getContacts();
    }*/
}
