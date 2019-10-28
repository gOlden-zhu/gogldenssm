package com.alone.service.impl;

import com.alone.dao.IUserDao;
import com.alone.domain.Role;
import com.alone.domain.UserInfo;
import com.alone.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:_AloneBoy
 * @date:2019/10/28
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {


    @Autowired
    private IUserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userDao.findByUsername(username);
        User user =new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),userInfo.getStatus()==0?false:true,true,true,true,getAuthority(userInfo.getRoles()));
        return user;
    }

    public List<SimpleGrantedAuthority> getAuthority(List<Role> roleList){
        List<SimpleGrantedAuthority> authorities=new ArrayList<>();
        for (Role role : roleList) {
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }

        return authorities;
    }
}
