package com.example.mc.application.web;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.mc.application.config.auth.dto.SessionUser;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class UserControllerTest {


    @Autowired
    private TestRestTemplate restTemplate;

	@Test
	public void testLogin() {
	     //when
        SessionUser body=this.restTemplate.getForObject("/",SessionUser.class);

        //then
        assertThat(body.getEmail()).isNotEmpty();
        System.out.println(body.getEmail());
	}

}
