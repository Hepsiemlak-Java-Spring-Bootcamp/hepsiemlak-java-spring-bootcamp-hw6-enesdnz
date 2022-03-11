package emlakburada.service;

import emlakburada.config.EmailConfig;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTest {

    @Mock
    private EmailConfig emailConfig;

    @InjectMocks
    private EmailService emailService;


    @Test
    void sendEmailTest(){

        String email = "enodeniz190@gmail.com";


    }
}
