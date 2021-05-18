package pl.codeworld.customersappforkotrak.entities;

import lombok.Getter;
import lombok.Setter;
import pl.codeworld.customersappforkotrak.enums.CustomerType;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminator")
public abstract class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @ManyToOne(cascade = CascadeType.ALL)
    private Address address;
    private String phoneNumber;
    @Email
    private String email;
    private String webSite;
    @Enumerated(EnumType.STRING)
    private CustomerType type;
}
