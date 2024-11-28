package org.example.financetracker.users;

import org.example.financetracker.AbstractTestContainerBase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest extends AbstractTestContainerBase {
    @Autowired
    private UserRepository userRepository;

    @Test
    void getUserByUsername() {
        User userToFind = new User("expectedUser", "expectedUser");
        // given - prepare some user to find#
        List<User> users = List.of(
                new User("test1", "test1"),
                new User("test2", "test2"),
                new User("test3", "test3"),
                userToFind
        );

        userRepository.saveAll(users);

        // when
        Optional<User> user = userRepository.findByUsername(userToFind.getUsername());

        // then
        assertEquals(user.get(), userToFind);
    }
}
