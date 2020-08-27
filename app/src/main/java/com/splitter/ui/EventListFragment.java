package com.splitter.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.splitter.model.Event;
import com.splitter.EventLab;
import com.splitter.R;

import java.util.List;

public class EventListFragment extends Fragment {

    private RecyclerView mEventRecyclerView;
    private EventAdapter mAdapter;
    private String title;
    private int page;

    public static EventListFragment newInstance(int page, String title) {
        EventListFragment fragment = new EventListFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_event_list, container, false);

        mEventRecyclerView = v.findViewById(R.id.event_recycler_view);
        mEventRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return v;
    }

    private void updateUI() {
        EventLab EventLab = com.splitter.EventLab.get(getActivity());
        List<Event> Events = EventLab.getEvents();
        mAdapter = new EventAdapter(Events);
        mEventRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private class EventHolder extends RecyclerView.ViewHolder {
        public EventHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_event, parent, false));
        }
    }

    private class EventAdapter extends RecyclerView.Adapter<EventHolder> {

        private List<Event> mEvents;

        public EventAdapter(List<Event> Events) {
            mEvents = Events;
        }

        @NonNull
        @Override
        public EventHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new EventHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull EventHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return mEvents.size();
        }
    }
}
