package org.example.renovatioapi.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.renovatioapi.dao.StepRepository;
import org.example.renovatioapi.model.Step;
import org.example.renovatioapi.service.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StepServiceImpl implements StepService {

    @Autowired
    private StepRepository stepRepository;

    @Override
    public List<Step> getAll() {
        return stepRepository.findAll();
    }

    @Override
    public Step save(Step step) {
        return stepRepository.save(step);
    }

    @Transactional
    @Override
    public Long delete(Long id) {
        stepRepository.deleteById(id);
        return id;
    }

    @Override
    public Step update(Step step) {
        Step step1 = stepRepository.getReferenceById(step.getId());
        step1.setDescription(step.getDescription());
        step1.setSrc(step.getSrc());
        return stepRepository.save(step1);
    }

    @Override
    public Step getById(Long id) {
        return null;
    }
}
