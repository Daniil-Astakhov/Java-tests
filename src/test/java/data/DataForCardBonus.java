package data;

import apipojo.CardBonus;
import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDateTime;

public class DataForCardBonus {
    public static final String bonus = RandomStringUtils.randomNumeric(4);
    public static final String sum = "100000";
    public static final String validAt = "2023-12-01 00:00:00";
    public static final String isExpiringTrue = "true";
    public static final String isExpiringFalse = "false";
    public static final String comment = LocalDateTime.now().toString();
    public static final String expireDate = "01122024 0000";
    public static final String author = RandomStringUtils.randomAlphabetic(10);



    public static CardBonus setNoValidCardBonus() {
        CardBonus cardBonus = new CardBonus();
        cardBonus.setBonus(bonus);
        cardBonus.setAuthor(author);
        cardBonus.setComment(comment);
        cardBonus.setExpire_date(expireDate);
        cardBonus.setIs_expiring(isExpiringFalse);
        cardBonus.setSum(sum);
        cardBonus.setValid_at(validAt);
        return cardBonus;
    }

    public static CardBonus setValidCardBonus() {
        CardBonus cardBonus = new CardBonus();
        cardBonus.setBonus(bonus);
        cardBonus.setAuthor(author);
        cardBonus.setComment(comment);
        cardBonus.setExpire_date(expireDate);
        cardBonus.setIs_expiring(isExpiringTrue);
        cardBonus.setSum(sum);
        cardBonus.setValid_at(validAt);
        return cardBonus;
    }
}
