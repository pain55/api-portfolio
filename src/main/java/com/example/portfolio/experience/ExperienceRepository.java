package com.example.portfolio.experience;

import com.example.portfolio.common.entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {

    Optional<List<Experience>> findAllByOrderByDisplayOrderAsc();
}
