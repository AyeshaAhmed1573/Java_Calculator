package com.example.demo.controller;

import com.example.demo.service.CalculatorService;
import com.example.demo.dto.CalculationRequest;
import com.example.demo.dto.CalculationResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService=calculatorService;
    }
    @PostMapping
    public CalculationResponse calculate(@RequestBody CalculationRequest request){
        return calculatorService.calculate(request);

    }
    @GetMapping("/{op}")
    public CalculationResponse calculate(@PathVariable String op,
                               @RequestParam double a,
                               @RequestParam double b
                               ) {
        return calculatorService.calculate(new CalculationRequest(a, b, op));


    };
}
