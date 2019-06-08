package com.example.swapnil.appicmobiletest.view;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ExpandableListView;

import com.example.swapnil.appicmobiletest.R;
import com.example.swapnil.appicmobiletest.service.model.ListModel;
import com.example.swapnil.appicmobiletest.service.model.MidModel;
import com.example.swapnil.appicmobiletest.viewmodel.ExpandableViewModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExpandableActivity extends AppCompatActivity {

    ExpandableViewModel expandableViewModel;
    private LifecycleRegistry mLifecycleRegistry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLifecycleRegistry = new LifecycleRegistry(this);
        mLifecycleRegistry.markState(Lifecycle.State.CREATED);
        expandableViewModel = ViewModelProviders.of(this).get(ExpandableViewModel.class);
        ExpandableAdapter expandableAdapter = new ExpandableAdapter(expandableViewModel.getListData(), this);
        ((ExpandableListView) findViewById(R.id.expandableListView)).setAdapter(expandableAdapter);

    }

    @Override
    public void onStart() {
        super.onStart();
        mLifecycleRegistry.markState(Lifecycle.State.STARTED);
    }

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return mLifecycleRegistry;
    }

}
