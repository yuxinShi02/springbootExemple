package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;

@RestController
@RequestMapping(value="users")
public class UserController {
	//建立线程安全的MAP, map<id, user>
    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>()); 
    
    //TODO: add method get list of user
    @RequestMapping(value="/", method=RequestMethod.GET)
    public List<User> getListUser(){
    	List<User> lsUsers = new ArrayList<>(users.values());
    	return lsUsers;
    }
    
    //TODO: add method post a user in collections
    @RequestMapping(value="/", method=RequestMethod.POST)
    public String addUser(@ModelAttribute User user){
    	users.put(user.getId(), user);
    	return "add success";
    }
    
    //TODO: add method get user by id and by get
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable Long id){
    	User user = users.get(id);
    	return user;
    }
    
    //TODO: add method update a user by put
    @RequestMapping(value="/", method = RequestMethod.PUT)
    public String updateUser(@ModelAttribute User user){
    	User userToUpdate = users.get(user.getId());
    	userToUpdate.setAge(user.getAge());
    	userToUpdate.setName(user.getName());
    	userToUpdate.setRole(user.getRole());
    	return "update success";
    }
    //TODO: add method delete a user by id
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public String delUser(@PathVariable Long id){
    	users.remove(id);
    	return "delete success!";
    }
}
