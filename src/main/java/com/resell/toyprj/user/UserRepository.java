package com.resell.toyprj.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
