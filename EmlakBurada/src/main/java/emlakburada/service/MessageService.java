package emlakburada.service;

import emlakburada.dto.MessageRequest;
import emlakburada.dto.response.MessageResponse;
import emlakburada.model.Message;
import emlakburada.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class MessageService extends MesajBaseService {

    @Autowired
    private MessageRepository messageRepository;

    public List<MessageResponse> getAllMessage() {
        List<Message> messages = messageRepository.findAll();
        return messages.stream().map(message -> convertToMessageResponse(message)).collect(Collectors.toList());
    }

    public MessageResponse getMessageByTitle(String title) {
        Message messages = messageRepository.findAll().stream().filter(message -> message.getBaslik().equals(title)).findFirst()
            .orElse(new Message());
        return convertToMessageResponse(messages);


    }

    public void saveMessage(MessageRequest messageRequest) {
        messageRepository.save(convertToMessageEntity(messageRequest));
    }

    public MessageResponse convertToMessageResponse(Message savedMessage) {
        MessageResponse response = new MessageResponse();
        response.setTitle(savedMessage.getBaslik());
        response.setDescription(savedMessage.getIcerigi());
        return response;
    }

}
