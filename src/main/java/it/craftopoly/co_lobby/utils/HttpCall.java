package it.craftopoly.co_lobby.utils;

import com.google.gson.JsonObject;

public class HttpCall
{
    public static JsonObject getUser(String username)
    {
        JsonObject response = HttpUtils.get(
                "/users/"+username,
                null,
                JsonObject.class
        ).getAsJsonObject();

        return response.get("param").getAsJsonObject();
    }
}

