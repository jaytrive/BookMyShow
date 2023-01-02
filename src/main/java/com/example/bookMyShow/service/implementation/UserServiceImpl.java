package com.example.bookMyShow.service.implementation;

import com.example.bookMyShow.converter.UserConverter;
import com.example.bookMyShow.dto.requestDto.Userdto;
import com.example.bookMyShow.dto.responseDto.UserResponseDto;
import com.example.bookMyShow.model.User;
import com.example.bookMyShow.repository.UserRepository;
import com.example.bookMyShow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void addUser(Userdto userdto) {
        /*User u=new User();
        u.setName(userdto.getName());
        u.setMobile(userdto.getMobile());*/
        User u= UserConverter.dtoToEntity(userdto);
        userRepository.save(u);
    }

    @Override
    public UserResponseDto getUser(int id){
        User user=userRepository.findById(id).get();
        return UserConverter.entityToDto(user);
    }
}
