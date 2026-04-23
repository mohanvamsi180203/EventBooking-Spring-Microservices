//package com.user.service.service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.user.service.client.AuthClient;
//import com.user.service.dto.AuthDto;
//import com.user.service.dto.UserResponseDto;
//import com.user.service.entity.User;
//import com.user.service.repo.UserRepo;
//
//@Service
//public class UserServiceImpl implements UserService {
//
//    @Autowired
//    private UserRepo userRepo;
//
//   
//
//    @Override
//    public User addUser(User user) {
//
//        AuthDto auth = authClient.getById(user.getAuthId());
//
//        if(auth == null) {
//            throw new RuntimeException("Auth Record Not Found");
//        }
//
//        if(userRepo.existsByEmail(user.getEmail())) {
//            throw new RuntimeException("Email Already Exists");
//        }
//
//        if(user.getPhone().length() != 10) {
//            throw new RuntimeException("Phone Number Must Be 10 Digits");
//        }
//
//        return userRepo.save(user);
//    }
//
//    @Override
//    public User updateUser(Integer id, User user) {
//
//        User existingUser = userRepo.findById(id).orElse(null);
//
//        if(existingUser != null) {
//            existingUser.setName(user.getName());
//            existingUser.setEmail(user.getEmail());
//            existingUser.setPhone(user.getPhone());
//            existingUser.setCity(user.getCity());
//            existingUser.setStatus(user.getStatus());
//
//            return userRepo.save(existingUser);
//        }
//
//        return null;
//    }
//
//    @Override
//    public String deleteUser(Integer id) {
//
//        	userRepo.deleteById(id);
//
//        return "User Deleted Successfully";
//    }
//
////    @Override
////    public List<User> viewAll() {
////        return userRepo.findAll();
////    }
//    
//    @Override
//    public List<UserResponseDto> viewAll() {
//
//        List<User> users = userRepo.findAll();
//
//        return users.stream().map(user -> {
//
//            AuthDto auth = authClient.getById(user.getAuthId());
//
//            UserResponseDto response = new UserResponseDto();
//
//            response.setUserId(user.getUserId());
//            response.setAuthId(user.getAuthId());
//            response.setName(user.getName());
//            response.setEmail(user.getEmail());
//            response.setPhone(user.getPhone());
//            response.setCity(user.getCity());
//            response.setStatus(user.getStatus());
//            response.setAuth(auth);
//
//            return response;
//
//        }).collect(Collectors.toList());
//    }
//
////    @Override
////    public User getById(Integer id) {
////        return userRepo.findById(id).orElse(null);
////    }
//    
//    
//    @Override
//    public UserResponseDto getById(Integer id) {
//
//        User user = userRepo.findById(id).orElse(null);
//
//        AuthDto auth = authClient.getById(user.getAuthId());
//
//        UserResponseDto response = new UserResponseDto();
//
//        response.setUserId(user.getUserId());
//        response.setAuthId(user.getAuthId());
//        response.setName(user.getName());
//        response.setEmail(user.getEmail());
//        response.setPhone(user.getPhone());
//        response.setCity(user.getCity());
//        response.setStatus(user.getStatus());
//        response.setAuth(auth);
//
//        return response;
//    }
//
////    @Override
////    public User getByEmail(String email) {
////        return userRepo.findByEmail(email);
////    }
//
//    
//    @Override
//    public UserResponseDto getByEmail(String email) {
//
//        User user = userRepo.findByEmail(email);
//
//        AuthDto auth = authClient.getById(user.getAuthId());
//
//        UserResponseDto response = new UserResponseDto();
//
//        response.setUserId(user.getUserId());
//        response.setAuthId(user.getAuthId());
//        response.setName(user.getName());
//        response.setEmail(user.getEmail());
//        response.setPhone(user.getPhone());
//        response.setCity(user.getCity());
//        response.setStatus(user.getStatus());
//        response.setAuth(auth);
//
//        return response;
//    }
////    @Override
////    public List<User> getByName(String name) {
////        return userRepo.findByNameContaining(name);
////    }
//
//    @Override
//    public List<UserResponseDto> getByName(String name) {
//
//        List<User> users = userRepo.findByNameContaining(name);
//
//        return users.stream().map(user -> {
//
//            AuthDto auth = authClient.getById(user.getAuthId());
//
//            UserResponseDto response = new UserResponseDto();
//
//            response.setUserId(user.getUserId());
//            response.setAuthId(user.getAuthId());
//            response.setName(user.getName());
//            response.setEmail(user.getEmail());
//            response.setPhone(user.getPhone());
//            response.setCity(user.getCity());
//            response.setStatus(user.getStatus());
//            response.setAuth(auth);
//
//            return response;
//
//        }).collect(Collectors.toList());
//    }
////    @Override
////    public List<User> getByCity(String city) {
////        return userRepo.findByCity(city);
////    }
//    
//    @Override
//    public List<UserResponseDto> getByCity(String city) {
//
//        List<User> users = userRepo.findByCity(city);
//
//        return users.stream().map(user -> {
//
//            AuthDto auth = authClient.getById(user.getAuthId());
//
//            UserResponseDto response = new UserResponseDto();
//
//            response.setUserId(user.getUserId());
//            response.setAuthId(user.getAuthId());
//            response.setName(user.getName());
//            response.setEmail(user.getEmail());
//            response.setPhone(user.getPhone());
//            response.setCity(user.getCity());
//            response.setStatus(user.getStatus());
//            response.setAuth(auth);
//
//            return response;
//
//        }).collect(Collectors.toList());
//    }
//    
//    
//    @Override
//    public User getUserEntityById(Integer id) {
//        return userRepo.findById(id).orElse(null);
//    }
//}



// ================= SERVICE IMPLEMENTATION =================
package com.user.service.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.service.dto.UserResponseDto;
import com.user.service.entity.User;
import com.user.service.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User addUser(User user) {

        if(userRepo.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email Already Exists");
        }

        if(user.getPassword() == null || user.getPassword().length() < 6) {
            throw new RuntimeException("Password Must Be At Least 6 Characters");
        }

        if(user.getPhone() != null && user.getPhone().length() != 10) {
            throw new RuntimeException("Phone Number Must Be 10 Digits");
        }

        user.setRole("USER");
        user.setStatus("ACTIVE");

        return userRepo.save(user);
    }

    @Override
    public User updateUser(Integer id, User user) {

        User existingUser = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        existingUser.setName(user.getName());
        existingUser.setPhone(user.getPhone());
        existingUser.setCity(user.getCity());

        return userRepo.save(existingUser);
    }

    @Override
    public String deleteUser(Integer id) {

        if(!userRepo.existsById(id)) {
            throw new RuntimeException("User Not Found");
        }

        userRepo.deleteById(id);
        return "User Deleted Successfully";
    }

    @Override
    public List<UserResponseDto> viewAll() {

        return userRepo.findAll().stream().map(user -> {

            UserResponseDto dto = new UserResponseDto();

            dto.setUserId(user.getUserId());
            dto.setName(user.getName());
            dto.setEmail(user.getEmail());
            dto.setPhone(user.getPhone());
            dto.setCity(user.getCity());
            dto.setStatus(user.getStatus());

            return dto;

        }).collect(Collectors.toList());
    }

    @Override
    public UserResponseDto getById(Integer id) {

        User user = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        UserResponseDto dto = new UserResponseDto();

        dto.setUserId(user.getUserId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setPhone(user.getPhone());
        dto.setCity(user.getCity());
        dto.setStatus(user.getStatus());

        return dto;
    }

    @Override
    public UserResponseDto getByEmail(String email) {

        User user = userRepo.findByEmail(email);

        if(user == null) {
            throw new RuntimeException("User Not Found");
        }

        UserResponseDto dto = new UserResponseDto();

        dto.setUserId(user.getUserId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setPhone(user.getPhone());
        dto.setCity(user.getCity());
        dto.setStatus(user.getStatus());

        return dto;
    }

    @Override
    public List<UserResponseDto> getByName(String name) {

        return userRepo.findByNameContaining(name).stream().map(user -> {

            UserResponseDto dto = new UserResponseDto();

            dto.setUserId(user.getUserId());
            dto.setName(user.getName());
            dto.setEmail(user.getEmail());
            dto.setPhone(user.getPhone());
            dto.setCity(user.getCity());
            dto.setStatus(user.getStatus());

            return dto;

        }).collect(Collectors.toList());
    }

    @Override
    public List<UserResponseDto> getByCity(String city) {

        return userRepo.findByCity(city).stream().map(user -> {

            UserResponseDto dto = new UserResponseDto();

            dto.setUserId(user.getUserId());
            dto.setName(user.getName());
            dto.setEmail(user.getEmail());
            dto.setPhone(user.getPhone());
            dto.setCity(user.getCity());
            dto.setStatus(user.getStatus());

            return dto;

        }).collect(Collectors.toList());
    }

    @Override
    public User getUserEntityById(Integer id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User Not Found"));
    }

    @Override
    public User login(String email, String password) {

        User user = userRepo.findByEmail(email);

        if(user == null || !user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid Credentials");
        }

        return user;
    }
}