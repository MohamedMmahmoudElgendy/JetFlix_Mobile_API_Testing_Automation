package BookSerialization;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookActivity {

     String firstname,lastname;
     int totalprice;
   Boolean depositpaid;

     @JsonProperty("bookingdates")
     BookingDates bookingdates;
     String additionalneeds;

    @JsonProperty("bookingdates")
    public BookingDates getBookingdates() {
        return bookingdates;
    }

    @JsonProperty("bookingdates")
    public void setBookingdates(BookingDates bookingdates) {
        this.bookingdates = bookingdates;
    }
    @JsonProperty("firstname")
    public String getFirstname() {
        return firstname;
    }
    @JsonProperty("firstname")
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    @JsonProperty("lastname")
    public String getLastname() {
        return lastname;
    }
    @JsonProperty("lastname")
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    @JsonProperty("totalprice")
    public int getTotalprice() {
        return totalprice;
    }
    @JsonProperty("totalprice")
    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }
    @JsonProperty("depositpaid")
    public Boolean getDepositpaid() {
        return depositpaid;
    }
    @JsonProperty("depositpaid")
    public void setDepositpaid(Boolean depositpaid) {
        this.depositpaid = depositpaid;
    }
    @JsonProperty("additionalneeds")
    public String getAdditionalneeds() {
        return additionalneeds;
    }
    @JsonProperty("additionalneeds")
    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }
}
