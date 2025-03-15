package edu.icet.ecom.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.icet.ecom.util.BookingPayment;
import edu.icet.ecom.util.BookingStatus;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Booking {

    @NotEmpty(message = "This should not be blank")
    private Long bookingID;

    @NotEmpty(message = "User ID should not be blank")
    private Long userName;

    @NotEmpty(message = "This should not be blank")
    private String email;

    @NotEmpty(message = "This should not be blank")
    private Long vehicleID;

    @NotNull(message = "This should not be blank")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    private Date startDate;

    @NotNull(message = "This should not be blank")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    private Date endDate;

    @NotEmpty(message = "This should not be blank")
    private Double totalPrice;

    @NotEmpty(message = "This should not be blank")
    private BookingStatus bookingStatus;

    @NotEmpty(message = "This should not be blank")
    private BookingPayment paymentStatus;
}
