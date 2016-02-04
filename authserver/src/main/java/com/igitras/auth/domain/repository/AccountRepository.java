package com.igitras.auth.domain.repository;

import com.igitras.auth.domain.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author mason
 */
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByLogin(String login);
}
