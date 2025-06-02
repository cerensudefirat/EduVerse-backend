package com.EduVerse.service.impl;

import com.EduVerse.DTO.*;
import com.EduVerse.model.User;
import com.EduVerse.repository.UserRepository;
import com.EduVerse.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HttpSession session;

    public static Integer userId;

    @Override
    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        User user = userRepository.findByEmail(loginRequestDto.getEmail()).orElse(null);

        if (user != null && user.getPassword().equals(loginRequestDto.getPassword())) {
            session.setAttribute("userId", user.getId());
            userId = user.getId();
            return new LoginResponseDto("Login successful!", true);
        }

        return new LoginResponseDto("Invalid email or password.", false);
    }

    @Override
    public User getUserById(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }


    @Override
    public SigninResponseDto signin(SigninDto signinDto) {

        if (signinDto.getEmail() == null || signinDto.getEmail().isEmpty()) {
            return new SigninResponseDto("Email cannot be null or empty.", false);
        }

        User existingUser = userRepository.findByEmail(signinDto.getEmail()).orElse(null);
        if (existingUser != null) {
            return new SigninResponseDto("User already exists with this email.", false);
        }

        User newUser = new User();
        newUser.setFirstName(signinDto.getFirstName());
        newUser.setLastName(signinDto.getLastName());
        newUser.setEmail(signinDto.getEmail());
        newUser.setPassword(signinDto.getPassword());

        userRepository.save(newUser);

        return new SigninResponseDto("User successfully registered!", true);
    }

    @Override
    public SigninResponseDto updateUser(UpdateUserDto updateUserDto) {
        if (userId == null) {
            return new SigninResponseDto("User is not logged in.", false);
        }

        User existingUser = userRepository.findById(userId).orElse(null);
        if (existingUser == null) {
            return new SigninResponseDto("User not found.", false);
        }

        existingUser.setFirstName(updateUserDto.getFirstName());
        existingUser.setLastName(updateUserDto.getLastName());
        existingUser.setEmail(updateUserDto.getEmail());
        existingUser.setPassword(updateUserDto.getPassword());

        userRepository.save(existingUser);

        return new SigninResponseDto("User successfully updated!", true);
    }

    @Override
    public SigninResponseDto logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return new SigninResponseDto("Logout successful", true);
    }

    @Override
    public Integer getLoggedInUserId() {
        return (Integer) session.getAttribute("userId");
    }

}

