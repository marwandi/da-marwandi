package com.da.commit.insurance.repository;

import com.da.commit.insurance.entity.Premi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository class to access Premi Entity on database
 */
@Repository
public interface PremiRepository extends JpaRepository<Premi, Integer> {
}
