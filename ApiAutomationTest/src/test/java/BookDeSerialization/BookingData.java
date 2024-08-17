package BookDeSerialization;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingData {

    String firstname,lastname;
    int totalprice;
    boolean depositpaid;
    @JsonProperty("bookingdates")
    BookingDatesResponse bookingdates;
    String additionalneeds ;


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }
    @JsonProperty("bookingdates")
    public BookingDatesResponse getBookingdates() {
        return bookingdates;
    }
    @JsonProperty("bookingdates")
    public void setBookingdates(BookingDatesResponse bookingdates) {
        this.bookingdates = bookingdates;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }
}
