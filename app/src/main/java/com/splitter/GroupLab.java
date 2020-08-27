package com.splitter;

import android.content.Context;

import com.splitter.model.Group;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GroupLab {
    private static GroupLab sGroupLab;



    //private Context mContext;
    private List<Group> mGroups;

    public static GroupLab get(Context context) {
        if (sGroupLab == null)
            sGroupLab = new GroupLab(context);

        return sGroupLab;
    }

    private GroupLab(Context context) {
        mGroups = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Group Group = new Group();
            Group.setTitle("Group #" + i);
            mGroups.add(Group);
        }
        //mContext = context.getApplicationContext();
    }

    public List<Group> getGroups() {
        return mGroups;
    }

    public Group getGroup(UUID id) {
        for (Group Group : mGroups)
            if (Group.getId().equals(id))
                return Group;

        return null;
    }
}
