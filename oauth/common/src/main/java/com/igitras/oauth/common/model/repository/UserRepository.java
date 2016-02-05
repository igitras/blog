package com.igitras.oauth.common.model.repository;

import com.igitras.oauth.common.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author mason
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByLogin(String login);
}
