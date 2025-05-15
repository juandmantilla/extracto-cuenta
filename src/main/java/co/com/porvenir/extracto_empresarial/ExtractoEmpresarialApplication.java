package co.com.porvenir.extracto_empresarial;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ExtractoEmpresarialApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExtractoEmpresarialApplication.class, args);
    }

}
