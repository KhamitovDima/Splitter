package com.splitter.di;

import android.app.Application;

import androidx.room.Room;

import com.splitter.db.ContactDB;
import com.splitter.db.ContactDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

@Module
@InstallIn(ApplicationComponent.class)
public class DataBaseModule {

    @Provides
    @Singleton
    public static ContactDB provideContactDB(Application application) {
        return Room.databaseBuilder(application, ContactDB.class, "Database")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
    }

    @Provides
    @Singleton
    public static ContactDao providePokeDao(ContactDB contactDB){
        return contactDB.contactDao();
    }
}
