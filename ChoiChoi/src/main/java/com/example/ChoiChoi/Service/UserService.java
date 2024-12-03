package com.example.ChoiChoi.Service;

import com.example.ChoiChoi.Entity.User;
import com.example.ChoiChoi.dto.Request.UserCreationRequest;
import com.example.ChoiChoi.dto.Request.UserUpdateRequest;
import com.example.ChoiChoi.exception.AppException;
import com.example.ChoiChoi.exception.ErorrCode;
import com.example.ChoiChoi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(UserCreationRequest request){
        User user = new User();

        if( userRepository.existsByUsername(request.getUsername()))
            throw new AppException(ErorrCode.USER_EXTSTED);

        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setDod(request.getDod());

        return userRepository.save(user);
    }

    public User updateUser(String userId,UserUpdateRequest request){
        User user = getUser(userId);

        user.setPassword(request.getPassword());
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setDod(request.getDod());

        return userRepository.save(user);
    }

    public void deleteUser(String userId){
        userRepository.deleteById(userId);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(String id){
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }


}
