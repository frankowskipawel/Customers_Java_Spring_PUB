package pl.codeworld.customersappforkotrak.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("individual")
public class CustomerPerson extends Customer{

    @Size(min = 3, max = 256)
    private String firstName;
    @Size(min = 3, max = 256)
    private String lastName;
    private String personalIdNumber;
    private String idCardNumber;
}
