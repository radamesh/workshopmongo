package com.radamesh.workshopmongo.config;

import com.radamesh.workshopmongo.domain.Post;
import com.radamesh.workshopmongo.domain.User;
import com.radamesh.workshopmongo.repository.PostRepository;
import com.radamesh.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        // User user = new User(null, "", "");
        User radames = new User(null, "Radames Silva", "radames@mail.com");
        User carolina = new User(null, "Carolina Silva", "carolina@mail.com");
        User mariana = new User(null, "Mariana Silva", "mariana@mail.com");
        User guilherme = new User(null, "Guilherme Silva", "guilherme@mail.com");
        User leandro = new User(null, "Leandro Silva", "leandro@mail.com");

        // Post post = new Post(null, sdf.parse("20/09/1980"), "", "", mariana);
        Post post1 = new Post(null, sdf.parse("31/07/2025"), "Dicas da Viagem", "quais a melhores dicas para viajar", mariana);
        Post post2 = new Post(null, sdf.parse("02/08/2025"), "Bora começar", "sempre terei um inicio", guilherme);
        Post post3 = new Post(null, sdf.parse("29/07/2025"), "Bom dia", "Bom dia qual é a melhor viagem?", leandro);

        userRepository.saveAll(Arrays.asList(radames, carolina, mariana, guilherme, leandro));
        postRepository.saveAll(Arrays.asList(post1, post2, post3));
    }
}
