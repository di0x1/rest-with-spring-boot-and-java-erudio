package br.com.di0x1.math;

import br.com.di0x1.request.converters.NumberConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public class SimpleMath {

    public Double sum(Double numberOne, Double numberTwo) {
        return numberOne + numberTwo;
    }

    public Double subtration(Double numberOne, Double numberTwo) {
        return numberOne - numberTwo;
    }

    public Double multiplication(Double numberOne, Double numberTwo) {
        return numberOne * numberTwo;
    }

    public Double division(Double numberOne, Double numberTwo) {
        return numberOne / numberTwo;
    }

    public Double mean (Double numberOne, Double numberTwo) {
        return sum(numberOne, numberTwo) / 2;
    }

    public Double squareroot (Double number) {
        return NumberConverter.raizQuadradaAproximada(number);
    }



}
