package com.splitter;

import android.content.Context;

import com.splitter.model.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EventLab {
    private static EventLab sEventLab;



    //private Context mContext;
    private List<Event> mEvents;

    public static EventLab get(Context context) {
        if (sEventLab == null)
            sEventLab = new EventLab(context);

        return sEventLab;
    }

    private EventLab(Context context) {
        mEvents = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Event Event = new Event();
            Event.setTitle("Event #" + i);
            mEvents.add(Event);
        }
        //mContext = context.getApplicationContext();
    }

    public List<Event> getEvents() {
        return mEvents;
    }

    public Event getEvent(UUID id) {
        for (Event Event : mEvents)
            if (Event.getId().equals(id))
                return Event;

        return null;
    }
}
