package com.slyvka.repositories;

import com.slyvka.model.LandlordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LandlordRepository extends JpaRepository<LandlordEntity, Integer> {
}
