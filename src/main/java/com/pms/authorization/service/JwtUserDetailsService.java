package com.pms.authorization.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pms.authorization.model.MyUserDeails;
import com.pms.authorization.model.User;
import com.pms.authorization.repository.UserDao;

import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;

@Service 
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {
	
	private static final Logger log = (Logger) org.slf4j.LoggerFactory.getLogger(JwtUserDetailsService.class);
	
	@Autowired
	private UserDao userDao;

	@SuppressWarnings("unused")
	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String userName) {
		/** fetching user by userName, if user is null the throw exception, otherwise
		 * return user
		 */
		User user = userDao.findByUserName(userName);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + userName);
		}
		log.info("User found");
		log.info("user successfully located");
	//	org.springframework.security.core.userdetails.User u=new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),new ArrayList<>());
		
		return new MyUserDeails(user);
		//return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),new ArrayList<>());
	}

}