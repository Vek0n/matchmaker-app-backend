package com.skaczmarek.matchmakerappbackend.controller;

import com.skaczmarek.matchmakerappbackend.domain.User;
import com.skaczmarek.matchmakerappbackend.domain.UserBuilder;
import com.skaczmarek.matchmakerappbackend.domain.UserDTO;
import com.skaczmarek.matchmakerappbackend.service.JwtUserDetailsService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.BDDMockito.given;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@RunWith(SpringRunner.class)
@WebMvcTest(JwtAuthenticationController.class)
@ComponentScan(basePackages = {"com.skaczmarek.matchmakerappbackend"})
class JwtAuthenticationControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private JwtUserDetailsService jwtUserDetailsServiceMock;

    @Test
    void registerUser() throws Exception{
        User givenUser = new UserBuilder().defaultUser().build();

        given(jwtUserDetailsServiceMock.save(any(UserDTO.class))).willReturn(givenUser);

        mvc.perform(post("/register")
                .content(
                "{\"username\":\"Grzmot\"," +
                " \"password\":\"pass\"}")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value(givenUser.getUsername()));
    }
}
