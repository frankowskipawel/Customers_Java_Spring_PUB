package pl.codeworld.customersappforkotrak.dtos;

import lombok.Getter;
import lombok.Setter;
import pl.codeworld.customersappforkotrak.entities.Address;
import pl.codeworld.customersappforkotrak.entities.Customer;
import pl.codeworld.customersappforkotrak.entities.CustomerBusiness;
import pl.codeworld.customersappforkotrak.entities.CustomerPerson;
import pl.codeworld.customersappforkotrak.enums.CustomerType;


@Getter
@Setter
public class CustomerDto {

    private int id;
    private String name;
    private Address address;
    private String phoneNumber;
    private String email;
    private String webSite;
    private CustomerType type;

    private String companyName;
    private String taxpayerIdentificationNumber;
    private String nationalBusinessRegistryNumber;

    private String firstName;
    private String lastName;
    private String personalIdNumber;
    private String idCardNumber;

    public CustomerBusiness toCustomerBusiness(){
        CustomerBusiness customerBusiness = new CustomerBusiness();
        setCommonFields(customerBusiness);
        customerBusiness.setName(companyName);

        customerBusiness.setCompanyName(companyName);
        customerBusiness.setTaxpayerIdentificationNumber(taxpayerIdentificationNumber);
        customerBusiness.setNationalBusinessRegistryNumber(nationalBusinessRegistryNumber);
        return customerBusiness;
    }

    public CustomerPerson toCustomerPerson(){
        CustomerPerson customerPerson = new CustomerPerson();
        setCommonFields(customerPerson);
        customerPerson.setName(lastName+" "+firstName);

        customerPerson.setFirstName(firstName);
        customerPerson.setLastName(lastName);
        customerPerson.setPersonalIdNumber(personalIdNumber);
        customerPerson.setIdCardNumber(idCardNumber);
        return customerPerson;
    }

    private <T extends Customer> T setCommonFields(T customer){
        customer.setId(id);
        customer.setName(name);
        customer.setAddress(address);
        customer.setPhoneNumber(phoneNumber);
        customer.setEmail(email);
        customer.setWebSite(webSite);
        customer.setType(type);
        return customer;
    }
}
