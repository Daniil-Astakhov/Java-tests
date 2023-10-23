package apipojo;

import io.qameta.allure.Step;

public class CardBonus {
    private String author;
    private String barcode;
    private String bonus;
    private String comment;
    private String expire_date;
    private String is_expiring;
    private String sum;
    private String valid_at;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBarcode() {
        return barcode;
    }

    @Step("Set value for Barcdoe {barcode}")
    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getExpire_date() {
        return expire_date;
    }

    public void setExpire_date(String expire_date) {
        this.expire_date = expire_date;
    }

    public String getIs_expiring() {
        return is_expiring;
    }

    public void setIs_expiring(String is_expiring) {
        this.is_expiring = is_expiring;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getValid_at() {
        return valid_at;
    }

    public void setValid_at(String valid_at) {
        this.valid_at = valid_at;
    }
}
