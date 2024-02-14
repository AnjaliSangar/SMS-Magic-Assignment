package com.smsMagic.UserClientApi.Repository;

import com.smsMagic.UserClientApi.entity.ClientUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientUsersRepository extends JpaRepository<ClientUsers, Long> {
}
