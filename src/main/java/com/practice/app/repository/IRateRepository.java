package com.practice.app.repository;

import com.practice.app.model.RateEntityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IRateRepository extends JpaRepository<RateEntityModel, Long> {

}
