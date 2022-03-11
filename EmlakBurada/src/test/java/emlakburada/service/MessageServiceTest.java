package emlakburada.service;

import emlakburada.dto.MessageRequest;
import emlakburada.dto.response.MessageResponse;
import emlakburada.model.Message;
import emlakburada.repository.MessageRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class MessageServiceTest {

    @Mock
    private MessageRepository messageRepository;
    @InjectMocks
    private MessageService messageService;

    @Test
    @DisplayName("this method tests get all message")
    void getAllMessageTest(){

        List<MessageResponse> allMessage = messageService.getAllMessage();

        assertNotNull(allMessage);

        assertThat(allMessage.size()).isNotZero();
    }

    @Test
    @DisplayName("this method tests save message test")
    void saveMessageTest() {

        messageService.saveMessage(prepareMessage());

        Mockito.verify(messageRepository).save(any());

    }

    @Test
    @DisplayName("this method tests get message by title")
    void getMessageByTitleTest(){

        //// @formatter:off

        Mockito
            .when(messageRepository.findById(1))
            .thenReturn(Optional.of(convertToMessageEntity(prepareMessage())));
        // @formatter:on

        MessageResponse response = messageService.getMessageByTitle("baslik");
        assertNotNull(response);
        assertNotNull(response.getTitle());
    }

    protected Message convertToMessageEntity(MessageRequest messageRequest) {
        Message message = new Message();
        message.setBaslik(messageRequest.getTitle());
        message.setIcerigi(messageRequest.getDescription());
        return message;

    }

    private MessageRequest prepareMessage() {
        MessageRequest message = new MessageRequest();
        message.setTitle("baslik");
        message.setDescription("aciklama");
        return message;

    }





}
