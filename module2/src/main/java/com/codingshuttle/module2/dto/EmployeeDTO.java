package com.codingshuttle.module2.dto;

import com.codingshuttle.module2.annotation.EmployeeRoleValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {



    private Long id;

    @NotBlank(message = "name cannot be blank")
    @Size(min = 3,max = 20,message = "name should be of length between 3 to 20")
    private String name;

    @Email(message = "Email should be in proper format")
    private String email;


    @Max(value = 80 , message = "age cannt be more than 80")
    @Min(value = 18 , message = "age cannot be less than 18")
    private Integer age;

    @NotBlank(message = "role cannot be blank")
//    @Pattern(regexp = "^(ADMIN|USER)$", message = "role of the message can be only admin or user")
    @EmployeeRoleValidation
    private String role;

    @NotNull(message = "salary cannt be null")
    @Positive(message = "salary should be positive")
    @Digits(integer = 6,fraction = 2,message = "the salary can be upto XXXXXX.XX")
    @DecimalMax(value = "1000000.75")
    @DecimalMin(value = "100")
    private Double salary;

    @PastOrPresent(message = "date should be only lesser or equal to todays date")
    private LocalDate dateOfJoining;

    @AssertTrue(message = "Employee should be active")
    @JsonProperty("isActive")
    private Boolean isActive;

}
