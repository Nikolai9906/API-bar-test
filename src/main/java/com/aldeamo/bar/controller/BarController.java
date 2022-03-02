package com.aldeamo.bar.controller;

import com.aldeamo.bar.repository.document.GlassesArray;
import com.aldeamo.bar.service.BarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping()
public class BarController {

    @Autowired
    BarService barService;


    @GetMapping("/operation")
    @ResponseBody
    public List<Integer> create(@RequestParam (name = "iteration", value = "iteration") int iteration, @RequestParam (name = "idArray", value = "idArray") int idArray ) throws Exception {
            return barService.primeOperation(iteration,idArray);
    }

    @GetMapping( "/{id}" )
    public List<Integer> findById(@PathVariable int id) {
        return barService.findById(id);
    }
}
