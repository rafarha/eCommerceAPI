package com.rafarha.ecommerce.repository;

import com.rafarha.ecommerce.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
}
