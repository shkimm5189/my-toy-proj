package com.resell.toyprj.user;

import com.resell.toyprj.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryImp extends JpaRepository<User, Long> {
}
