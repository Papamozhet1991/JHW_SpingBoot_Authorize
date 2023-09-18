package JHW_Authorization.askovorodko.service;

import JHW_Authorization.askovorodko.exception.InvalidCredentials;
import JHW_Authorization.askovorodko.exception.UnauthorizedUser;
import JHW_Authorization.askovorodko.model.Authorities;
import JHW_Authorization.askovorodko.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorizationService {
    private final UserRepository userRepository;
    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}