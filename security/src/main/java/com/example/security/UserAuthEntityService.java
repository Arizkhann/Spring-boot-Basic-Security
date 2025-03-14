package com.example.security;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserAuthEntityService implements UserDetailsService {

    private final UserAuthEntityRepository userAuthEntityRepository;

    //save method

    public UserDetails save(UserAuthEntity userAuthEntity){
       return userAuthEntityRepository.save(userAuthEntity);
    }




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userAuthEntityRepository.findByName(username).orElseThrow(()->new RuntimeException("user not found"));
    }
}
