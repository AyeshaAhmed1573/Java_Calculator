package com.example.demo.service.impl;

import com.example.demo.service.CalculatorService;
import com.example.demo.dto.CalculationRequest;
import com.example.demo.dto.CalculationResponse;
import org.springframework.stereotype.Service;


@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public CalculationResponse calculate(CalculationRequest request){
        double a= request.a();
        double b= request.b();
        if (request.op()==null || request.op().isBlank()){
            return new CalculationResponse(a,b,null,null, "correct operation is required");

        }
        String op= request.op().trim().toUpperCase();


         switch(op){
            case "+":
                return new CalculationResponse(a,b,op,a+b, "success");
            case "-" :
                return new CalculationResponse(a,b,op,a-b, "success");
            case "*" :
                return new CalculationResponse(a,b,op,a*b, "success");
            case "/" :
                if (b==0){
                    return new CalculationResponse(a,b,op,null, "cannot divide by 0");
                }
                else{
                    return new CalculationResponse(a,b,op,a/b, "success");
                }
            default:
                return new CalculationResponse(a,b,op,null, "proper expression requird"+op);

        }


    }

}
