package com.pedroaugust8.service.resources;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.pedroaugust8.common.models.User;
import com.pedroaugust8.service.resources.UserResource;
import com.pedroaugust8.common.interfaces.UserService;
import com.pedroaugust8.common.exceptions.UserException;

public class UserResourceTest {
	private UserResource target;
	private List<User> mockList;
	private UserService service;
	private List<User> actualList;

	@SuppressWarnings("unchecked")
	@Before
	public void setup(){
		mockList = mock(List.class);
		service = mock(UserService.class);
		
		when(service.list()).thenReturn(mockList);
		target = new UserResource(service);
	}
	
	@Test
	public void save() throws UserException{
		User User = new User();	
		target.create(User);	
		verify(service).save(User);
	}
	
	@Test
	public void list(){
		actualList = target.getUsers();
		Assert.assertEquals(mockList, actualList);
	}
	
	
	@Test
	public void delete() throws UserException{	
		target.delete("1");
		verify(service).delete("1");	
	} 
	
	@Test
	public void get() {	
		target.get("1");
		verify(service).get("1");	
	} 
	
	
}