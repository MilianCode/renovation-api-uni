package org.example.renovatioapi.controller;

import org.example.renovatioapi.model.Step;
import org.example.renovatioapi.service.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/admin/panel")
public class AdminController {

    @Autowired
    private StepService service;

    @GetMapping
    public List<Step> getAll() {
        return service.getAll();
    }

    @PostMapping("/save")
    public Step save(@RequestBody Step step) {
        return service.save(step);
    }

    @PostMapping("/delete/{id}")
    public Long delete(@PathVariable(value = "id") Long id) {
        return service.delete(id);
    }

    @PostMapping("/update")
    public Step update(@RequestBody Step step) {
        return service.update(step);
    }

}