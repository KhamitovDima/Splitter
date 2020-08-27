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

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.splitter.model.Group;
import com.splitter.GroupLab;
import com.splitter.R;

import java.util.List;

public class GroupListFragment extends Fragment {

    private RecyclerView mGroupRecyclerView;
    private GroupAdapter mAdapter;
    private FloatingActionButton fab;
    private String title;
    private int page;

    public static GroupListFragment newInstance(int page, String title) {
        GroupListFragment fragment = new GroupListFragment();
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
        View v = inflater.inflate(R.layout.fragment_group_list, container, false);

        mGroupRecyclerView = v.findViewById(R.id.group_recycler_view);
        mGroupRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return v;
    }

    private void updateUI() {
        GroupLab GroupLab = com.splitter.GroupLab.get(getActivity());
        List<Group> Groups = GroupLab.getGroups();
        mAdapter = new GroupAdapter(Groups);
        mGroupRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private class GroupHolder extends RecyclerView.ViewHolder {
        public GroupHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_group, parent, false));
        }
    }

    private class GroupAdapter extends RecyclerView.Adapter<GroupHolder> {

        private List<Group> mGroups;

        public GroupAdapter(List<Group> Groups) {
            mGroups = Groups;
        }

        @NonNull
        @Override
        public GroupHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new GroupHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull GroupHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return mGroups.size();
        }
    }
}
