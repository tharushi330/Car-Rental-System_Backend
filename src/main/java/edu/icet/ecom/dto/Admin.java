package edu.icet.ecom.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Admin {
    @NotEmpty(message = "Admin ID should not be blank")
    private Long adminID;

    @NotEmpty(message = "AdminName should not be blank")
    private String adminName;

    @NotEmpty(message = "should not be blank")
    private String email;

    @NotEmpty(message = "should not be blank")
    private String password;

    @NotEmpty(message = "Contact number should not be blank")
    @Size(min = 10, max = 10, message = "Contact number must be exactly 10 digits")
    private String contactNumber;
}
