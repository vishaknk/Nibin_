package com.app.androidtestapp.androidtestapp;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;



public class WebInterfaceManager {

    private ResponseService responseService;

    public WebInterfaceManager(Context context){
        this.responseService = (ResponseService) context;
    }

    public void getProductData(){

        // Tag used to cancel the request
        String tag_json_obj = "json_obj_req";

        String url = "https://randomapi.com/api/?key=LMW0-SW97-ISC4-FF25&id=t60ldyb&results=20";

        StringRequest request = new StringRequest(Request.Method.GET, url,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Log.e("datastring", s);
                        responseService.onResponseReceived(s, true);
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        responseService.onResponseReceived("error", false);
                    }
                }
        );

        // Adding request to request queue
        TestApplication.getInstance().addToRequestQueue(request, tag_json_obj);

    }

}
