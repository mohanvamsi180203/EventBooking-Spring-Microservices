package com.auth.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth.service.entity.Auth;
import com.auth.service.repo.AuthRepo;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthRepo authRepo;

    @Override
    public Auth register(Auth auth) {

        if(authRepo.existsByEmail(auth.getEmail())) {
            throw new RuntimeException("Email Already Exists");
        }

        if(authRepo.existsByUsername(auth.getUsername())) {
            throw new RuntimeException("Username Already Exists");
        }

        if(auth.getPassword().length() < 6) {
            throw new RuntimeException("Password Must Be At Least 6 Characters");
        }

        return authRepo.save(auth);
    }

    @Override
    public String login(String email, String password) {

        Auth auth = authRepo.findByEmail(email);

        if(auth != null && auth.getPassword().equals(password)) {
            return "Login Successful";
        }

        return "Invalid Email Or Password";
    }

    @Override
    public List<Auth> viewAll() {
        return authRepo.findAll();
    }

    @Override
    public Auth getById(Integer id) {
        return authRepo.findById(id).orElse(null);
    }

    @Override
    public Auth getByEmail(String email) {
        return authRepo.findByEmail(email);
    }

    @Override
    public String deleteUser(Integer id) {
        authRepo.deleteById(id);
        return "User Deleted Successfully";
    }
}