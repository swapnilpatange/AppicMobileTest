package com.example.swapnil.appicmobiletest.service.model;

import com.example.swapnil.appicmobiletest.service.model.MidModel;

import java.util.List;

public class ListModel {

    List<MidModel> midModels;
    String mid;

    public List<MidModel> getMidModels() {
        return midModels;
    }

    public void setMidModels(List<MidModel> midModels) {
        this.midModels = midModels;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }
}
