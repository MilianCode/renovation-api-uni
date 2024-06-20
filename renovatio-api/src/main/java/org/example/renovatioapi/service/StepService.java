package org.example.renovatioapi.service;

import org.example.renovatioapi.model.Step;
import java.util.List;

public interface StepService {
    List<Step> getAll();

    Step save(Step step);

    void delete(Long id);

    Step update(Step step);

    Step getById(Long id);
}
