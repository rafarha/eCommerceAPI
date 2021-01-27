package com.rafarha.ecommerce.service;

import com.rafarha.ecommerce.domain.User;
import com.rafarha.ecommerce.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override public User saveUser(final User pUser) {
	return userRepository.save(pUser);
    }

    @Override public List<User> searchAllUsers() {
	return userRepository.findAll(Sort.by("id"));
    }

    @Override public User searchUserById(final Long pId) {
	final Optional<User> user = userRepository.findById(pId);
	if (!user.isPresent()) {
	    return null;
	}
	return user.get();
    }

    @Override
    @Transactional
    public User updateUser(final Long pId, final User pUser) {
	final Optional<User> userOptional = userRepository.findById(pId);
	if (!userOptional.isPresent()) {
	    return null;
	}
	User user = userOptional.get();
	user.setUserName(pUser.getUserName());
	user.setUserCategory(pUser.getUserCategory());
	return user;
    }
}
