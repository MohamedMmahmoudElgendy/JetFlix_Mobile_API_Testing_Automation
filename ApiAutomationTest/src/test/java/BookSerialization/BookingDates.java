package BookSerialization;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingDates {

   String checkin,checkout;


    @JsonProperty("checkin")
    public String getCheckin() {
        return checkin;
    }
    @JsonProperty("checkin")
    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }
    @JsonProperty("checkout")
    public String getCheckout() {
        return checkout;
    }
    @JsonProperty("checkout")
    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }
}
