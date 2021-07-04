package com.cnd.voc.service;

import com.cnd.voc.entity.User;
import com.cnd.voc.exception.NotFoundException;
import com.cnd.voc.model.dto.UserDto;
import com.cnd.voc.model.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    private static List<User> users = new ArrayList<User>();

    static {
        users.add(new User(1, "Nguyễn Thị Mộng", "mong@gmail.com", "080526656", "avata.jpg", "123456789"));
        users.add(new User(2, "Nguyễn Thị Nhật", "nhat@gmail.com", "080526656", "avata.jpg", "123456789"));
        users.add(new User(3, "Nguyễn Hồng Đào", "dao@gmail.com", "080526656", "avata.jpg", "123456789"));
        users.add(new User(4, "Nguyễn Phạm Anh Khôi", "khoi@gmail.com", "080526656", "avata.jpg", "123456789"));
        users.add(new User(5, "Phạm Thị Tuyến", "tuyen@gmail.com", "080526656", "avata.jpg", "123456789"));
    }

    @Override
    public List<UserDto> getListUser() {
        List<UserDto> result = new ArrayList<>();
        for(User user : users){
            result.add(UserMapper.toUserDto(user));
        }
        return result;
    }

    @Override
    public UserDto getUserById(int id) {
        for(User user : users)
            if(user.getId() == id)
                return UserMapper.toUserDto(user);

        throw new NotFoundException("User không tồn tại trong hệ thống");
    }

    @Override
    public List<UserDto> searchUserByName(String name) {
        List<UserDto> result = new ArrayList<>();
        for(User user : users)
            if(user.getName().contains(name))
                result.add(UserMapper.toUserDto(user));

        return result;
    }

    @Override
    public UserDto craeteUser(User user) {
        user.setId(users.size());
        users.add(user);
        return UserMapper.toUserDto(user);
    }
}
