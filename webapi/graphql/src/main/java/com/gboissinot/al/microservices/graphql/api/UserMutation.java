package com.gboissinot.al.microservices.graphql.api;

import com.gboissinot.al.microservices.graphql.domain.model.Address;
import com.gboissinot.al.microservices.graphql.domain.model.User;
import com.gboissinot.al.microservices.graphql.domain.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class UserMutation {

    private final UserRepository userRepository;

    @Autowired
    public UserMutation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @MutationMapping
    public UserResponse writeUser(@Argument(value = "user") UserCommand userCommand) {
        var user = new User(
                userRepository.nextIdentity(),
                userCommand.lastname,
                userCommand.firstname,
                new Address(userCommand.zipCode, userCommand.city));

        userRepository.save(user);
        return UserResponse.of(user);
    }
}
