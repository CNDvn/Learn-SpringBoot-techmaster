package com.cnd.voc.service;

import com.cnd.voc.entity.User;
import com.cnd.voc.model.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface UserService {
    public  List<UserDto> getListUser();
    public UserDto getUserById(int id);
    public List<UserDto> searchUserByName(String name);
    public UserDto craeteUser(User user);
}
