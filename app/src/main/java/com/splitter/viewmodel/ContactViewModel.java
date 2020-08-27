package com.splitter.viewmodel;

import android.util.Log;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.splitter.model.Contact;
import com.splitter.model.ContactResponse;
import com.splitter.repository.Repository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ContactViewModel extends ViewModel {
    private static final String TAG = "ContactViewModel";

    private Repository mRepository;
    private MutableLiveData<ArrayList<Contact>> contactList = new MutableLiveData<>();

    @ViewModelInject
    public ContactViewModel(Repository repository) {
        mRepository = repository;
    }

    public MutableLiveData<ArrayList<Contact>> getContactList() {return contactList;}

    /*public void getContacts() {
        mRepository.getContacts()
                .subscribeOn(Schedulers.io())
                .map(new Function<ContactResponse, ArrayList<Contact>>() {
                    @Override
                    public ArrayList<Contact> apply(ContactResponse pokemonResponse) throws Throwable {
                        ArrayList<Contact> list = pokemonResponse.getContacts();
                        for (Contact contact : list) {
                            String url = contact.getUrl();
                            String[] pokemonIndex = url.split("/");
                            contact.setUrl("???"); //https://pokeres.bastionbot.org/images/pokemon/"+pokemonIndex[pokemonIndex.length-1] +".png"
                        }
                        Log.e(TAG, "apply: " + list.get(2).getUrl());
                        return list;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> contactList.setValue(result),
                        error -> Log.e(TAG, "getContacts: " + error.getMessage()));
    }*/


    public void insertContact(Contact contact) {
        mRepository.insertContact(contact);
    }

    public void deleteContact(String contactName) {
        mRepository.deleteContact(contactName);
    }

/*
    public LiveData<List<Pokemon>> getFavoritePokemonList() {
        return favoritePokemonList;
    }

    public void getFavoritePokemon(){
        favoritePokemonList = repository.getFavoritePokemon();
   }

 */
}
