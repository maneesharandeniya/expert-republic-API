package com.expertrepublic.repos;

import com.expertrepublic.domain.Expert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ExpertRepo extends JpaRepository<Expert, Long> {

    public Optional<Expert> findById(Long id);
    public Expert findByEmail(String email);
}
