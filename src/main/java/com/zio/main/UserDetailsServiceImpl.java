package com.zio.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.zio.models.CustomUserDetails;
import com.zio.models.PracownikHr;
import com.zio.repositories.PracownikHrRepository;
import com.zio.services.MyAspect;

import ch.qos.logback.classic.Logger;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	
	@Autowired
	PracownikHrRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Logger logger = (Logger) LoggerFactory.getLogger(UserDetailsServiceImpl.class);
		
		PracownikHr pracwownikOptional = repository.findByLogin(username);
		CustomUserDetails cud = new CustomUserDetails(pracwownikOptional);
		GrantedAuthority authority = new SimpleGrantedAuthority(cud.getRole());
		logger.info("usrDetailsRepository"+cud.getRole());
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(authority);
		return new User(cud.getLogin(), cud.getHaslo(), authorities);
	}

}
