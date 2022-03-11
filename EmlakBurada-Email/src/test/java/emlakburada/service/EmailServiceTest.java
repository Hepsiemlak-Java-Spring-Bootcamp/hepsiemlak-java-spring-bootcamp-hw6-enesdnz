package emlakburada.service;

import emlakburada.config.EmailConfig;
import emlakburada.dto.EmailResponse;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTest {

    @Mock
    private EmailConfig emailConfig;

    @InjectMocks
    private EmailService emailService;


    @Test
    void sendEmailTest(){

        EmailResponse emailResponse = prepareEmail();

        Mockito
            .when(emailConfig.getSmtpServer())
            .thenReturn("smtp.gmail.com");
        Mockito
            .when(emailConfig.getSmtpPort())
            .thenReturn("587");
        Mockito
            .when(emailConfig.getFrom())
            .thenReturn("emlakburada.patika@gmail.com");
        Mockito
            .when(emailConfig.getUsername())
            .thenReturn("username");
        Mockito
            .when(emailConfig.getPassword())
            .thenReturn("password");

        emailService.send("enes@gmail.com");

    }

    private EmailResponse prepareEmail(){
        EmailResponse email = new EmailResponse();
        email.setEmail("enodeniz190@gmail.com");
        return email;
    }
}
