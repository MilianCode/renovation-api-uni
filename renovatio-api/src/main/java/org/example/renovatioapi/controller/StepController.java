package org.example.renovatioapi.controller;

import org.example.renovatioapi.model.Step;
import org.example.renovatioapi.service.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/panel")
public class StepController {

    @Autowired
    private StepService service;

    @GetMapping
    public List<Step> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Step save(@RequestBody Step step) {
        return service.save(step);
    }

}
