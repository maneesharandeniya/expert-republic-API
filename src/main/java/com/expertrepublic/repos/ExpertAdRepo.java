package com.expertrepublic.repos;


import com.expertrepublic.domain.ExpertAd;
import com.expertrepublic.dto.ExpertAdCommonDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExpertAdRepo extends JpaRepository<ExpertAd, Long> {

   /* @Query(value = "SELECT s.id, s.title, s.cost, s.description FROM service s",
            nativeQuery = true)
    List<ExpertAdCommonDto> findPostExpertAdAll();*/

   // List<ExpertAd> findByUserEmail(String email);

}
