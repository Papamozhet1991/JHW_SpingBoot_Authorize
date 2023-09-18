package JHW_Authorization.askovorodko.repository;

import JHW_Authorization.askovorodko.model.Authorities;
import JHW_Authorization.askovorodko.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class UserRepository {

    private List<User> listUsers = new ArrayList<>(Stream.of(new User("Amir", "key"), new User("Vova", "keys")).collect(Collectors.toList()));

    public List<Authorities> getUserAuthorities(String user, String password) {
        for (User listUser : listUsers) {
            if (listUser.getUser().equals(user) & listUser.getPassword().equals(password)) {
                return List.of(Authorities.READ);
            }
        }
        return List.of();
    }
}