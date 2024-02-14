package com.smsMagic.UserClientApi.Repository;

import com.smsMagic.UserClientApi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
