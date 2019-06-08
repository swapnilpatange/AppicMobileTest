package com.example.swapnil.appicmobiletest.view;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.swapnil.appicmobiletest.service.model.ListModel;
import com.example.swapnil.appicmobiletest.service.model.MidModel;
import com.example.swapnil.appicmobiletest.R;

import java.util.List;

public class ExpandableAdapter extends BaseExpandableListAdapter {
    List<ListModel> listModels;
    Activity activity;

    public ExpandableAdapter(List<ListModel> listModels, Activity activity) {
        this.listModels = listModels;
        this.activity = activity;
    }

    @Override
    public int getGroupCount() {
        return listModels.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return listModels.get(groupPosition).getMidModels().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listModels.get(groupPosition).getMid();
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listModels.get(groupPosition).getMidModels().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean b, View view, ViewGroup viewGroup) {
        View groupView = LayoutInflater.from(activity).inflate(R.layout.group_item, null);
        TextView mId = groupView.findViewById(R.id.mId);
        mId.setText((String) getGroup(groupPosition));
        return groupView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean b, View view, ViewGroup viewGroup) {
        View childView = LayoutInflater.from(activity).inflate(R.layout.child_item, null);
        TextView narration = childView.findViewById(R.id.narration);
        TextView tId = childView.findViewById(R.id.tId);
        narration.setText(((MidModel) getChild(groupPosition, childPosition)).getNarration());
        tId.setText(((MidModel) getChild(groupPosition, childPosition)).getTid());
        return childView;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
