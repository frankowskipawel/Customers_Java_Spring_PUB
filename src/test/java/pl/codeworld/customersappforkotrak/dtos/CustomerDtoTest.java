package pl.codeworld.customersappforkotrak.dtos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.codeworld.customersappforkotrak.entities.Address;
import pl.codeworld.customersappforkotrak.entities.CustomerBusiness;
import pl.codeworld.customersappforkotrak.entities.CustomerPerson;
import pl.codeworld.customersappforkotrak.enums.CustomerType;

import static org.junit.jupiter.api.Assertions.*;

class CustomerDtoTest {

    private CustomerDto customerDtoPerson;
    private CustomerDto customerDtoCompany;
    private Address address;

    @BeforeEach
    void setUp() {
        customerDtoPerson = new CustomerDto();
        customerDtoPerson.setId(1);
        customerDtoPerson.setPhoneNumber("500500500");
        customerDtoPerson.setEmail("nowak@wp.pl");
        customerDtoPerson.setWebSite("www.nowak.pl");
        customerDtoPerson.setType(CustomerType.PERSON);
        customerDtoPerson.setFirstName("Jan");
        customerDtoPerson.setLastName("Nowak");
        customerDtoPerson.setPersonalIdNumber("12345678900");
        customerDtoPerson.setIdCardNumber("AAA123456");
        customerDtoPerson.setAddress(address);

        customerDtoCompany = new CustomerDto();
        customerDtoCompany.setId(2);
        customerDtoCompany.setPhoneNumber("500500500");
        customerDtoCompany.setEmail("nowak@wp.pl");
        customerDtoCompany.setWebSite("www.nowak.pl");
        customerDtoCompany.setType(CustomerType.COMPANY);
        customerDtoCompany.setCompanyName("ADAMEX");
        customerDtoCompany.setTaxpayerIdentificationNumber("999-11-45-567");
        customerDtoCompany.setNationalBusinessRegistryNumber("123456789");
        customerDtoCompany.setAddress(address);

        address = new Address();
        address.setId(1);
        address.setStreet("Nowa");
        address.setBuildingNumber("1");
        address.setApartmentNumber("2");
        address.setPostCode("87-100");
        address.setCity("Toruń");
        address.setProvince("kujawsko-pomorskie");
    }

    @Test
    void shouldCustomerDtoToCustomerMappingIsTrue() {
        //given
        CustomerPerson customer;
        //when
        customer = customerDtoPerson.toCustomerPerson();
        //then
        assertTrue(customerDtoPerson.toCustomerPerson() instanceof CustomerPerson);
        assertTrue(customer.getName().equals(customerDtoPerson.getLastName()+" "+ customerDtoPerson.getFirstName()));
        assertTrue(customer.getPhoneNumber().equals(customerDtoPerson.getPhoneNumber()));
        assertTrue(customer.getEmail().equals(customerDtoPerson.getEmail()));
        assertTrue(customer.getWebSite().equals(customerDtoPerson.getWebSite()));
        assertTrue(customer.getType().equals(customerDtoPerson.getType()));
        assertTrue(customer.getFirstName().equals(customerDtoPerson.getFirstName()));
        assertTrue(customer.getLastName().equals(customerDtoPerson.getLastName()));
        assertTrue(customer.getPersonalIdNumber().equals(customerDtoPerson.getPersonalIdNumber()));
        assertTrue(customer.getIdCardNumber().equals(customerDtoPerson.getIdCardNumber()));
        assertTrue(customer.getAddress()== customerDtoPerson.getAddress());
    }


    @Test
    void toCustomerBusiness() {
        //given
        CustomerBusiness customer;
        //when
        customer = customerDtoCompany.toCustomerBusiness();
        //then
        assertTrue(customerDtoCompany.toCustomerBusiness() instanceof CustomerBusiness);
        assertTrue(customer.getName().equals(customerDtoCompany.getCompanyName()));
        assertTrue(customer.getPhoneNumber().equals(customerDtoCompany.getPhoneNumber()));
        assertTrue(customer.getEmail().equals(customerDtoCompany.getEmail()));
        assertTrue(customer.getWebSite().equals(customerDtoCompany.getWebSite()));
        assertTrue(customer.getType().equals(customerDtoCompany.getType()));
        assertTrue(customer.getCompanyName().equals(customerDtoCompany.getCompanyName()));
        assertTrue(customer.getTaxpayerIdentificationNumber().equals(customerDtoCompany.getTaxpayerIdentificationNumber()));
        assertTrue(customer.getNationalBusinessRegistryNumber().equals(customerDtoCompany.getNationalBusinessRegistryNumber()));
        assertTrue(customer.getAddress()== customerDtoCompany.getAddress());
    }
}
