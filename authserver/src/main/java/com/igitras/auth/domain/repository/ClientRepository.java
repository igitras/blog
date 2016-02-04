package com.igitras.auth.domain.repository;

import com.igitras.auth.domain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author mason
 */
public interface ClientRepository extends JpaRepository<Client, Long> {

}
