package com.app.androidtestapp.androidtestapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DataProcessor {

    private String dataString;
    //Json keys
    private static final String RESULTS = "results";
    private static final String ENTITY = "entity";
    private static final String THUMBNAIL = "thumbnail";
    private static final String PIC =  "picture";
    private static final String DESCRIPTION = "descritpion";

    public DataProcessor(String dataString){
        this.dataString = dataString;
    }

    public ArrayList<JSONItems> processData(){
        ArrayList<JSONItems> JSONItemsArrayList = new ArrayList<JSONItems>();

        try {
            JSONObject mainObject = new JSONObject(dataString);
            JSONArray jsonArray = mainObject.getJSONArray(RESULTS);
            for(int i = 0; i<jsonArray.length(); i++){

                JSONObject entityObject = jsonArray.getJSONObject(i);
                JSONObject entityitems = entityObject.getJSONObject(ENTITY);

                JSONItems jsonItems = new JSONItems();
                jsonItems.setDescription(entityitems.getString(DESCRIPTION));
                jsonItems.setImage(entityitems.getString(PIC));
                jsonItems.setThumbnail(entityitems.getString(THUMBNAIL));
                if(jsonItems != null)
                    JSONItemsArrayList.add(jsonItems);
            }
        }
        catch (JSONException e){
            e.printStackTrace();
        }
        return JSONItemsArrayList;
    }



}
