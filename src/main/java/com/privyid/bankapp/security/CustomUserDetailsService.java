package com.privyid.bankapp.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Set;

import java.util.stream.Collectors;
import com.privyid.bankapp.model.User;
import com.privyid.bankapp.model.UserBalance;
import com.privyid.bankapp.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
       User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
               .orElseThrow(() ->
                       new UsernameNotFoundException("User not found with username or email:" + usernameOrEmail));
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(), mapUserBalancesToAuthorities(user.getUserbalances()));
    }

    private Collection< ? extends GrantedAuthority> mapUserBalancesToAuthorities(Set<UserBalance> user_balances){
        return user_balances.stream().map(user_balance -> new SimpleGrantedAuthority(user_balance.getBalance())).collect(Collectors.toList());
    }
}