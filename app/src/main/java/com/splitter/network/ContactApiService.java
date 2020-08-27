package com.splitter.network;

import com.splitter.model.ContactResponse;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface ContactApiService {

    @GET("contact")
    Observable<ContactResponse> getContacts();
}

