package com.savi.usermodule.repository;

import com.savi.usermodule.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

