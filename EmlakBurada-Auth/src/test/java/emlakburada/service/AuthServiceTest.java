package emlakburada.service;

import emlakburada.dto.AuthRequest;
import emlakburada.dto.AuthResponse;
import emlakburada.entity.User;
import emlakburada.repository.AuthRepository;
import emlakburada.util.JwtUtil;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class AuthServiceTest {

    @InjectMocks
    private AuthService authService;
    @Mock
    private AuthRepository authRepository;

    private JwtUtil jwtUtil;

    @Test
    void getTokenTest() throws Exception {
        AuthRequest request = prepareAuthRequest();

        User user = prepareUser();
        //// @formatter:off
        Mockito
            .when(authRepository.findByEmail(request.getEmail()))
            .thenReturn(user);

        // @formatter:on

        AuthResponse response = authService.getToken(request);

        assertEquals(jwtUtil.generateToken(user), response.getToken());


    }

    private AuthRequest prepareAuthRequest() {
        AuthRequest request = new AuthRequest("enodeniz190@gmail.com", "123456");
        return request;
    }

    private User prepareUser(){
        User user = new User();
        user.setEmail("enodeniz190@gmail.com");
        user.setPassword("123456");
        return user;
    }

}
