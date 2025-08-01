package com.radamesh.workshopmongo.services;

import com.radamesh.workshopmongo.domain.User;
import com.radamesh.workshopmongo.dto.UserDTO;
import com.radamesh.workshopmongo.repository.UserRepository;
import com.radamesh.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new ObjectNotFoundException("Este Usuário não foi encontrado.");
        }
        return user.orElse(null);
    }

    public User insert(User user) {
        return userRepository.insert(user);
    }
    
    public void delete(String id) {
        findById(id);
        userRepository.deleteById(id);
    }
    
    public User update(User obj) {
        User newObj = findById(obj.getId());
        updateData(newObj, obj);
        return userRepository.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setNome(obj.getNome());
        newObj.setEmail(obj.getEmail());
    }

    public User fromDTO(UserDTO usrDto) {
        return new User(usrDto.getId(), usrDto.getNome(), usrDto.getEmail());
    }
}
