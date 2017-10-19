package com.test.sam.commmodule.reslist;

import android.util.Log;

import com.test.sam.commmodule.Models.ModelItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sam on 7/3/17.
 */

public class ResListParser {

    public static List<ModelItem> parse(String json) throws JSONException {

        List<ModelItem> items = new ArrayList<>();
        JSONObject res = new JSONObject(json);
        Log.d("parser", res.toString());
        if (!res.isNull("results")) {

            JSONArray results = res.getJSONArray("results");
            for (int i = 0; i < results.length(); i++){
                Log.d("parser", results.getJSONObject(i).toString());
                items.add(getItem(results.getJSONObject(i)));
            }
        }

        return items;

    }

    private static ModelItem getItem ( JSONObject res) throws JSONException {

        ModelItem item = new ModelItem();
        if (!res.isNull("id")){
            Log.d("parser", res.getString("id"));
            item.setId(res.getString("id"));
        }
        if (!res.isNull("name")){
            item.setName(res.getString("name"));
        }
        if (!res.isNull("description")){
            item.setDescrpition(res.getString("description"));
        }

        return item;

    }

}
