package api;

import apipojo.CardBonus;
import com.google.gson.Gson;

public class ResponseCard {

    public String getJsonFromCardBonus(CardBonus cardBonus) {
        Gson gson = new Gson();
        String jsonString = gson.toJson(cardBonus);
        return jsonString;
    }
}
