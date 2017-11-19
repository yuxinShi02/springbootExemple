package com.example.demo;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.controller.UserController;

/**
 * @Test
 * Spring MVC测试框架提供了对服务器端和客户端（基于RestTemplate的客户端）提供了支持。
 * @author yuxin
 *
 */
@RunWith(SpringJUnit4ClassRunner.class) 
@SpringBootTest(classes = MockServletContext.class) 
//@WebAppConfiguration：测试环境使用，用来表示测试环境使用的ApplicationContext将是WebApplicationContext类型的；value指定web应用的根；
@WebAppConfiguration
public class UserControllerTests {
	private MockMvc mvc;
	
	@Before
	public void setup(){
		mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
	}
	
	@Test
	public void testUserController() throws Exception{
		RequestBuilder requestBuilder = null; 
		
		//检查 users 等于空值
		requestBuilder = get("/users/");
		mvc.perform(requestBuilder).andExpect(status().isOk()).andExpect(content().string(equalTo("[]")));
		
		//加入一个user
		requestBuilder = post("/users/").param("id", "1").
				param("name", "zoe").param("age", "50").param("role", "Admin");
		mvc.perform(requestBuilder).andExpect(content().string(equalTo("add success")));
				//.string(equalTo("[{\"id\":1,\"name\":\"zoe\",\"age\":50, \"role\":\"Admin\"}]")));
		
		//查询一个user by id
		requestBuilder = get("/users/1");
		mvc.perform(requestBuilder).andExpect(content()
				.string(equalTo("{\"id\":1,\"name\":\"zoe\",\"age\":50,\"role\":\"Admin\"}")));
		
		//更新一个user
		requestBuilder = put("/users/").param("id", "1").
				param("name", "yu").param("age", "6").param("role", "kid");
		mvc.perform(requestBuilder).andExpect(content().string(equalTo("update success")));
		
		//删除user
		requestBuilder = delete("/users/1");
		mvc.perform(requestBuilder).andExpect(content().string(equalTo("delete success!")));
	}

}

