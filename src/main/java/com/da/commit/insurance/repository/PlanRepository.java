package com.da.commit.insurance.repository;

import com.da.commit.insurance.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository class to access Paket Entity on database
 */
@Repository
public interface PlanRepository extends JpaRepository<Plan, Integer> {
}
