package model;

/**
 * Created by Linus on 2018-05-05.
 */
public class DiscountDTO {
    private double percentage;
    private String expireDate;

    /**
     * @param percent double | The percentage amount of the discount, for example a discount of 25% would have the argument 25
     * @param date String | Not used currently, just an expiration date if that would become relevant
     */
    public DiscountDTO(double percent, String date){
        this.percentage = percent;
        this.expireDate = date;
    }

    double getPercentage(){
        return this.percentage;
    }

    String getExpireDate() {
        return expireDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DiscountDTO that = (DiscountDTO) o;

        if (Double.compare(that.percentage, percentage) != 0) return false;
        return expireDate.equals(that.expireDate);

    }
}
