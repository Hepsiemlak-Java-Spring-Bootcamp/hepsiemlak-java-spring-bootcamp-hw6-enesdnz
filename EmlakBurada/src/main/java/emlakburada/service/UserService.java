package emlakburada.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import emlakburada.dto.response.AdvertResponse;
import emlakburada.model.Advert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emlakburada.dto.UserRequest;
import emlakburada.dto.response.UserResponse;
import emlakburada.model.User;
import emlakburada.repository.UserRepository;

@Service
public class UserService extends UserBaseService {

	@Autowired
	private UserRepository userRepository;

	public List<UserResponse> getAllUser() {
		List<User> users = userRepository.findAll();
		return users.stream().map(user -> convertToUserResponse(user)).collect(Collectors.toList());
	}

	public void saveUser(UserRequest userRequest) {
		userRepository.save(convertToUserEntity(userRequest));
	}

    public UserResponse getUserByUserId(int userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            return convertToUserResponse(user.get());
        }
        return new UserResponse();
    }

}
