package com.shos.gestion.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.shos.gestion.entities.AppUser;
import com.shos.gestion.service.AccountService;


@Service
@Component
public class UserDetailsServiceImp implements UserDetailsService {

	private AccountService accountService;

	public UserDetailsServiceImp(AccountService accountService) {
		this.accountService = accountService;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser appUser = accountService.loadUserByUsername(username);
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		appUser.getAppRoles().forEach(r -> {
			authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
		});
		return new User(appUser.getUsername(), appUser.getPassword(), authorities);
	}

}