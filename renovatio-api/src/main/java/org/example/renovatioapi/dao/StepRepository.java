package org.example.renovatioapi.dao;

import org.example.renovatioapi.model.Step;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StepRepository extends JpaRepository<Step, Long> {

    List<Step> findAllByOrderByIdAsc();
}
