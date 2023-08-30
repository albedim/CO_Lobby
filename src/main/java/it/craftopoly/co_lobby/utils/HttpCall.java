package it.craftopoly.co_lobby.utils;

import com.google.gson.Gson;
import it.craftopoly.co_lobby.schema.User;

public class HttpCall
{
    public static User getUser(String username)
    {
        Response response = HttpRequest.get("/users/"+username);
        if(response == null)
            return new User();
        return new Gson().fromJson(response.getParam().toString(), User.class);
    }
}

