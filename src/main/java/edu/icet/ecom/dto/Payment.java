package edu.icet.ecom.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.icet.ecom.util.PaymentMethod;
import edu.icet.ecom.util.PaymentStatus;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @NotEmpty(message = "This should not be blank")
    private Long paymentID;

    @NotEmpty(message = "This should not be blank")
    private Long bookingID;

    @NotEmpty(message = "This should not be blank")
    private Double amount;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "MM/dd/yyyy")
    private LocalDate paymentDate;

    @NotEmpty(message = "This should not be blank")
    private PaymentMethod method;

    @NotEmpty(message = "This should not be blank")
    private PaymentStatus status;
}
