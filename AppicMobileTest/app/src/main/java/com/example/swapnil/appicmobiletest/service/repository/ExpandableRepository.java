package com.example.swapnil.appicmobiletest.service.repository;

import android.util.Log;
import android.widget.ExpandableListView;

import com.example.swapnil.appicmobiletest.R;
import com.example.swapnil.appicmobiletest.service.model.ListModel;
import com.example.swapnil.appicmobiletest.service.model.MidModel;
import com.example.swapnil.appicmobiletest.view.ExpandableAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExpandableRepository {
    private static ExpandableRepository expandableRepository;


    public synchronized static ExpandableRepository getInstance() {
        //TODO No need to implement this singleton in Part #2 since Dagger will handle it ...
        if (expandableRepository == null) {
            if (expandableRepository == null) {
                expandableRepository = new ExpandableRepository();
            }
        }
        return expandableRepository;
    }

    public List<ListModel> getListData() {
        String data = "{\n" +
                "\t\"sort\": [{\n" +
                "\t\t\t\"Mid\": \"1\",\n" +
                "\t\t\t\"Tid\": \"7\",\n" +
                "\t\t\t\"narration\": \"ty1\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"Mid\": \"3\",\n" +
                "\t\t\t\"Tid\": \"6\",\n" +
                "\t\t\t\"narration\": \"ty2\"\n" +
                "\t\t}, {\n" +
                "\t\t\t\"Mid\": \"2\",\n" +
                "\t\t\t\"Tid\": \"5\",\n" +
                "\t\t\t\"narration\": \"ty3\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"Mid\": \"3\",\n" +
                "\t\t\t\"Tid\": \"4\",\n" +
                "\t\t\t\"narration\": \"ty4\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"Mid\": \"2\",\n" +
                "\t\t\t\"Tid\": \"3\",\n" +
                "\t\t\t\"narration\": \"ty5\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"Mid\": \"1\",\n" +
                "\t\t\t\"Tid\": \"2\",\n" +
                "\t\t\t\"narration\": \"ty6\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"Mid\": \"3\",\n" +
                "\t\t\t\"Tid\": \"1\",\n" +
                "\t\t\t\"narration\": \"ty7\"\n" +
                "\t\t}\n" +
                "\t]\n" +
                "}";

        List<ListModel> listModels = new ArrayList<>();

        try {

            JSONObject jsonObject = new JSONObject(data);
            JSONArray sort = jsonObject.getJSONArray("sort");
            List<JSONObject> jsonObjects = new ArrayList<>();
            for (int i = 0; i < sort.length(); i++)
                jsonObjects.add(sort.getJSONObject(i));
            Collections.sort(jsonObjects, new Comparator<JSONObject>() {

                @Override
                public int compare(JSONObject a, JSONObject b) {

                    int c;
                    try {
                        c = Integer.parseInt(a.getString("Mid")) - Integer.parseInt((b.getString("Mid")));
                        if (c == 0)
                            c = Integer.parseInt(a.getString("Tid")) - Integer.parseInt(b.getString("Tid"));
                        return c;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    return 0;
                    //if you want to change the sort order, simply use the following:
                    //return -valA.compareTo(valB);
                }
            });
            Log.d(getClass().getSimpleName(), "onCreate: ");
            List<MidModel> midModels = new ArrayList<>();
            for (int i = 0; i < jsonObjects.size(); i++) {
                ListModel listModel = new ListModel();
                listModel.setMid(jsonObjects.get(i).getString("Mid"));
                MidModel midModel = new MidModel();
                midModel.setNarration(jsonObjects.get(i).getString("narration"));
                midModel.setTid(jsonObjects.get(i).getString("Tid"));
                midModels.add(midModel);
                listModel.setMidModels(midModels);
                if (i != jsonObjects.size() - 1 && !(jsonObjects.get(i).getString("Mid").equalsIgnoreCase(jsonObjects.get(i + 1).getString("Mid")))) {
                    listModels.add(listModel);
                    midModels = new ArrayList<>();
                }

                if (i == jsonObjects.size() - 1) {
                    listModels.add(listModel);
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return listModels;
    }
}
