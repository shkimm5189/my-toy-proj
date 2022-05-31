package com.resell.toyprj.user;

import com.resell.toyprj.user.User;
import com.resell.toyprj.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = false)
    public Long join(User user) {
        validateDuplicateUser(user);
        userRepository.save(user);
        return user.getId();
    }
    private void validateDuplicateUser(User user) {
        List<User> findUsers = userRepository.findByAccount(user.getAccount());
        if (!findUsers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    public List<User> findUsers() {
        return userRepository.findAll();
    }

    public User findUser(Long id) {
        return userRepository.findOne(id);
    }

    @Transactional(readOnly = false)
    public Long update(Long userId, User updateParam) {
        userRepository.update(userId, updateParam);
        return userId;
    }

}
