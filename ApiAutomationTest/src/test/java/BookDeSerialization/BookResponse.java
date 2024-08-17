package BookDeSerialization;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookResponse {


    int bookingid;
    @JsonProperty("booking")
    BookingData booking;

    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }
    @JsonProperty("booking")
    public BookingData getBooking() {
        return booking;
    }
    @JsonProperty("booking")
    public void setBooking(BookingData booking) {
        this.booking = booking;
    }
}
