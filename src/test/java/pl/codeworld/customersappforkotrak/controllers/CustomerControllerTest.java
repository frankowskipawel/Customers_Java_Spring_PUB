package pl.codeworld.customersappforkotrak.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pl.codeworld.customersappforkotrak.entities.Customer;
import pl.codeworld.customersappforkotrak.entities.CustomerPerson;
import pl.codeworld.customersappforkotrak.services.CustomerService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private CustomerService customerService;

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    void shouldFindAllCustomersIsStatusOk() throws Exception {
        mockMvc
                .perform(get("/api/customer"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    void shouldFindByIdStatusIsStatusOK() throws Exception {
        mockMvc
                .perform(get("/api/customer/217"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    void shouldFindByIdStatusIsStatusNotFound() throws Exception {
        mockMvc
                .perform(get("/api/customer/0"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    void shouldInsertCustomerIsTrue() throws Exception {
        //given
        CustomerPerson customerPerson = new CustomerPerson();
        customerPerson.setFirstName("Adam");
        customerPerson.setLastName("Nowak");
        customerPerson.setEmail("adam@example.com");
        //when
        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/customer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(customerPerson)))
        //then
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    void shouldUpdateCustomerIsTrue() throws Exception {
        //given
       Customer customer = customerService.findById(217);
       String email = customer.getEmail();
       customer.setEmail("new@new.pl");
        //when
        mockMvc.perform(
                MockMvcRequestBuilders.put("/api/customer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(customer)))
        //then
                .andExpect(status().isOk());
        customer.setEmail(email);
        customerService.update(customer);

    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    void shouldDeleteCustomerIsTrue() throws Exception {
        //given
        CustomerPerson customerPerson = new CustomerPerson();
        customerPerson.setFirstName("Adam");
        customerPerson.setLastName("Nowak");
        customerPerson.setEmail("adam@example.com");
        customerService.insert(customerPerson);
        //when
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/api/customer/{id}", customerPerson.getId())
                .contentType(MediaType.APPLICATION_JSON))
        //then
            .andExpect(status().isOk());

    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
