package pl.codeworld.customersappforkotrak.entities;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@DiscriminatorValue("business")
public class CustomerBusiness extends Customer {

    @Size(min = 3, max = 256)
    private String companyName;
    private String taxpayerIdentificationNumber;
    private String nationalBusinessRegistryNumber;
}
