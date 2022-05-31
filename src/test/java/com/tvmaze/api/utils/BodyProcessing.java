package com.tvmaze.api.utils;

import com.tvmaze.api.client.CustomClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BodyProcessing {
    private List<String> tvShowList;

    private List<String> getTVShowNameList(String body) {
        tvShowList = new ArrayList<>();
        if(body.startsWith("[")){
        JSONArray jsonArray = new JSONArray(body);
        List<JSONObject> jsonObjectList = new ArrayList<>();
        for (Object jsonObject : jsonArray) {
            jsonObjectList.add(((JSONObject) jsonObject).getJSONObject("show"));
        }
                for (JSONObject jsonObject : jsonObjectList) {
            tvShowList.add(jsonObject.getString("name"));
        }}
        else {
            JSONObject jsonObject = new JSONObject(body);
            tvShowList.add(jsonObject.getString("name"));
        }
        CustomClient.logger.info("TVShow names: " + tvShowList);
        return tvShowList;
    }

    public boolean isResponseContainTVShow(String tvShow, String body) {
        if (tvShowList == null) {
            tvShowList = getTVShowNameList(body);
        }
        return tvShowList.stream().anyMatch(s -> s.contains(tvShow));
    }
}
