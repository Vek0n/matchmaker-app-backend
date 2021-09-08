package com.skaczmarek.matchmakerappbackend.service;


import com.skaczmarek.matchmakerappbackend.domain.User;
import com.skaczmarek.matchmakerappbackend.domain.UserBuilder;
import com.skaczmarek.matchmakerappbackend.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;


import com.skaczmarek.matchmakerappbackend.config.JwtTokenUtil;
import com.skaczmarek.matchmakerappbackend.domain.*;
import com.skaczmarek.matchmakerappbackend.service.JwtUserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.mockito.BDDMockito.given;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@ExtendWith(MockitoExtension.class)
class JwtUserServiceTest {

    @Mock
    UserRepository userRepositoryMock;

    @Mock
    private PasswordEncoder bcryptEncoderMock;

    @InjectMocks
    JwtUserService jwtUserServiceMock;


    @Test
    void shouldSaveUser(){
        //Given
        User givenUser = new UserBuilder().defaultUser().build();
        UserDTO givenUserDTO = new UserDTOBuilder().defaultUser().build();
        given(userRepositoryMock.save(any(User.class))).willReturn(givenUser);
        given(bcryptEncoderMock.encode(any(CharSequence.class))).willReturn("testPassword");
        //When
        User result = jwtUserServiceMock.save(givenUserDTO);
        //Then
        assertEquals(result, givenUser);
    }


    @Test
    void shouldLoadUserByUsername(){
        //Given
        User givenUser = new UserBuilder().defaultUser().build();
        given(userRepositoryMock.findByUsername(any(String.class))).willReturn(givenUser);
        //When
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(givenUser.getUsername(), givenUser.getPassword(),
                new ArrayList<>());
        UserDetails result = jwtUserServiceMock.loadUserByUsername(givenUser.getUsername());
        //Then
        assertEquals(result, userDetails);
    }


}
