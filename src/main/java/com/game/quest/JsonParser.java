package com.game.quest;

import com.game.quest.important.Information;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import jakarta.servlet.http.HttpServletRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;

public class JsonParser {
    public static String getJsonString(Gson gson, HashMap<String, String> data) {
        Type typeObject = new TypeToken<HashMap>() {
        }.getType();
        String gsonData = gson.toJson(data, typeObject);
        return gsonData;
    }

    public static Information getInfo(HttpServletRequest req, Gson gson) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = req.getReader()) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        }
        // JSON строка
        String jsonString = sb.toString();
        return gson.fromJson(jsonString, Information.class);
    }
}
