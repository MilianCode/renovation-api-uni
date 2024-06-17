package org.example.renovatioapi.service.impl;

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
}
