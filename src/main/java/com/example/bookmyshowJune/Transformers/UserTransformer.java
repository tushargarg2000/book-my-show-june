package com.example.bookmyshowJune.Transformers;

import com.example.bookmyshowJune.Dtos.RequestDto.AddUserDto;
import com.example.bookmyshowJune.Dtos.ResponseDtos.UserResponseDto;
import com.example.bookmyshowJune.Models.User;

public class UserTransformer {

    public static User convertDtoToEntity(AddUserDto userDto){

        User userObj = User.builder().age(userDto.getAge()).email(userDto.getEmailId()).mobNo(userDto.getMobNo())
                        .name(userDto.getName()).build();
        return userObj;
    }

    public static UserResponseDto convertEntityToDto(User user){

        UserResponseDto userResponseDto = UserResponseDto.builder().age(user.getAge()).name(user.getName())
                                                .mobNo(user.getMobNo()).build();
        return userResponseDto;
    }


}
