package com.rafarha.ecommerce.service;

import com.rafarha.ecommerce.domain.User;

import java.util.List;

public interface IUserService {

    public User saveUser(User pUser);

    List<User> searchAllUsers();

    User searchUserById(Long pId);

    User updateUser(Long pId, User pUser);
}
