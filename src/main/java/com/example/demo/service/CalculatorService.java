package com.example.demo.service;
import com.example.demo.dto.CalculationRequest;
import com.example.demo.dto.CalculationResponse;


public interface CalculatorService {
     CalculationResponse calculate(CalculationRequest request);
}
