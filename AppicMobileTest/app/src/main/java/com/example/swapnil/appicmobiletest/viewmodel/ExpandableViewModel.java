package com.example.swapnil.appicmobiletest.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.example.swapnil.appicmobiletest.service.model.ListModel;
import com.example.swapnil.appicmobiletest.service.repository.ExpandableRepository;

import java.util.List;

public class ExpandableViewModel extends AndroidViewModel {
    public ExpandableViewModel(@NonNull Application application) {
        super(application);
    }

    public List<ListModel> getListData() {
        return ExpandableRepository.getInstance().getListData();
    }
}
