package com.expert_republic.repos;

import com.expert_republic.models.Expert;
import com.expert_republic.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

    public Optional<User> findById(Long id);
    public User findByEmail(String email);
}
