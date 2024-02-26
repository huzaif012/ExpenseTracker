package com.huzaif.ExpenseTracker.security;

import com.huzaif.ExpenseTracker.entity.User;
import com.huzaif.ExpenseTracker.service.ExpenseTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    ExpenseTrackerService expenseTrackerService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = expenseTrackerService.findUserByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("User Not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),user.getRoles());
    }
}
