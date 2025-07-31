package com.radamesh.workshopmongo.config;

import com.radamesh.workshopmongo.domain.User;
import com.radamesh.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        // User user = new User(null, "", "");
        User radames = new User(null, "Radames Silva", "radames@mail.com");
        User carolina = new User(null, "Carolina Silva", "@mail.com");
        User mariana = new User(null, "Mariana Silva", "@mail.com");
        User guilherme = new User(null, "Guilherme Silva", "@mail.com");
        User leandro = new User(null, "Leandro Silva", "@mail.com");

        userRepository.saveAll(Arrays.asList(radames, carolina, mariana, guilherme, leandro));
    }
}
