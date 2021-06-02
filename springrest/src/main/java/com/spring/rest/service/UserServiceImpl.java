package com.spring.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.rest.model.Users;

@Service
public class UserServiceImpl implements UserService {

	List<Users> ul=new ArrayList<>();
	
	public UserServiceImpl() {

		ul.add(new Users( 1, "Saif", "India"));
		ul.add(new Users( 2, "Saif1", "EastBengal"));
		ul.add(new Users( 3, "Saif2", "Assam"));
		ul.add(new Users( 4, "Saif3", "Gopalpur"));
		ul.add(new Users( 5, "Saif4", "Dakineswar"));
		
	}

	@Override
	public List<Users> getUsers() {
		return ul;
	}
	@Override
	public Users getUserById(int id) {
		Users c=null;
		for(Users u : ul) {
			if(u.getId()==id) {
				c= u;
				break;
			}
		}
		return c;
	}

	@Override
	public Users addUser(Users user) {
		// TODO Auto-generated method stub
		this.ul.add(user);
		return user;
	}

	@Override
	public Users updateUser(Users user,int id) {
		for(Users u : ul) {
			if (u.getId()==id) {

				if(user.getName()!=null) {
					u.setName(user.getName());
				}
				if(user.getAddress()!=null) {
					u.setAddress(user.getAddress());
				}
				return u;
			}
		}
		return null;
	}

	@Override
	public String deleteAll() {
		this.ul.clear();
		return "deleted all users";
	}

	@Override
	public String deleteById(int id) {
		int count=0;
		for (Users u: ul) {
			if(u.getId()==id) {
				ul.remove(count);
				return "successfully removed user id "+id;
			}
			count++;
		}
		return "user not found";
	}

}
