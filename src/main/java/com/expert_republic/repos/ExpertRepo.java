package com.expert_republic.repos;

import com.expert_republic.models.Expert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ExpertRepo extends JpaRepository<Expert, Long> {

    public Optional<Expert> findById(Long id);
}
