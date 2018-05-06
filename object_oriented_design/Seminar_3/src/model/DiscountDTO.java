package model;

/**
 * Created by Linus on 2018-05-05.
 */
public class DiscountDTO {
    private double percentage;
    private String expireDate;

    public DiscountDTO(double percent, String date){
        this.percentage = percent;
        this.expireDate = date;
    }

    public double getPercentage(){
        return this.percentage;
    }

    public String getExpireDate() {
        return expireDate;
    }
}
