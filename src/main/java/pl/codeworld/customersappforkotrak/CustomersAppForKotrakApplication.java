package pl.codeworld.customersappforkotrak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class CustomersAppForKotrakApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomersAppForKotrakApplication.class, args);
    }
}
