package emlakburada.service;

import emlakburada.dto.MessageRequest;
import emlakburada.dto.response.MessageResponse;
import emlakburada.model.Message;

public class MesajBaseService {
    protected Message convertToMessageEntity(MessageRequest messageRequest) {
        Message message = new Message();
        message.setBaslik(messageRequest.getTitle());
        message.setIcerigi(messageRequest.getDescription());
        return message;

    }

    protected MessageResponse convertToMessageResponse(Message message) {
        MessageResponse messageResponse = new MessageResponse();
        messageResponse.setDescription(message.getIcerigi());
        messageResponse.setTitle(message.getBaslik());
        messageResponse.setReceiver(message.getAlici());
        messageResponse.setReadDate(message.getOkunduguTarihi());
        messageResponse.setSentDate(message.getGonderilenTarih());
        messageResponse.setSender(message.getGonderici());
        return messageResponse;
    }
}
