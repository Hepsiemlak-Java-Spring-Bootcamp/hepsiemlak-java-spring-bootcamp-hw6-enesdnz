package emlakburada.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import emlakburada.dto.response.AdvertResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import emlakburada.dto.UserRequest;
import emlakburada.dto.response.UserResponse;
import emlakburada.model.User;
import emlakburada.model.enums.UserType;
import emlakburada.repository.UserRepository;

@SpringBootTest
class UserServiceTest {

	@InjectMocks
	private UserService userService;

	@Mock
	private UserRepository userRepository;

	@BeforeEach
	void setup() {

		//// @formatter:off
		Mockito
		.when(userRepository.findAll())
		.thenReturn(prepareMockUserList());

		// @formatter:on

	}

	private List<User> prepareMockUserList() {
		List<User> userList = new ArrayList<User>();
		userList.add(new User(UserType.INDIVIDUAL, "cem", "cem@patika.com"));
		userList.add(new User(UserType.INDIVIDUAL, "emre", "emre@patika.com"));
		return userList;
	}

	@Test
	void getAllUserTest() {

		List<UserResponse> allUser = userService.getAllUser();

		assertNotNull(allUser);

		assertThat(allUser.size()).isNotZero();
	}

	@Test
	void saveUserTest() {

		userService.saveUser(prepareUserRequest());

		Mockito.verify(userRepository).save(any());

	}

    @Test
    void getUserByUserIdTest() {

        //// @formatter:off

        Mockito
            .when(userRepository.findById(1))
            .thenReturn(Optional.of(prepareUser()));
        // @formatter:on

        UserResponse response = userService.getUserByUserId(1);
        assertNotNull(response);
        assertNotNull(response.getName());

    }

	private User prepareUser() {
		return new User(UserType.INDIVIDUAL, "enes", "enodeniz190@gmail.com");
	}
    private UserRequest prepareUserRequest() {
        return new UserRequest(UserType.INDIVIDUAL, "enes", "enodeniz190@gmail.com", null, null);
    }

}
