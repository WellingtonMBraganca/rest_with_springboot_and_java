package github.com.WellingtonMBraganca.rest_with_springboot_and_java.controllers;

import github.com.WellingtonMBraganca.rest_with_springboot_and_java.exceptions.UnsuportedMathOperationException;
import github.com.WellingtonMBraganca.rest_with_springboot_and_java.math.SimpleMath;
import github.com.WellingtonMBraganca.rest_with_springboot_and_java.request.converters.NumberConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    private SimpleMath simpleMath = new SimpleMath();

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        numericValidation(numberOne, numberTwo);
        return simpleMath.sum(NumberConverter.stringToDouble(numberOne), NumberConverter.stringToDouble(numberTwo));
    }

    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        numericValidation(numberOne, numberTwo);
        return simpleMath.subtraction(NumberConverter.stringToDouble(numberOne), NumberConverter.stringToDouble(numberTwo));
    }

    @RequestMapping("/division/{numberOne}/{numberTwo}")
    public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        if(numberTwo.equals("0")) throw new UnsuportedMathOperationException("Impossible division by zero.");
        numericValidation(numberOne, numberTwo);
        return simpleMath.division(NumberConverter.stringToDouble(numberOne), NumberConverter.stringToDouble(numberTwo));
    }

    @RequestMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo){
        numericValidation(numberOne, numberTwo);
        return simpleMath.multiplication(NumberConverter.stringToDouble(numberOne), NumberConverter.stringToDouble(numberTwo));
    }

    @RequestMapping("/mean/{numberOne}/{numberTwo}")
    public Double media(@PathVariable("numberOne")String numberOne, @PathVariable("numberTwo")String numberTwo){
        numericValidation(numberOne, numberTwo);
        return (simpleMath.sum(NumberConverter.stringToDouble(numberOne), NumberConverter.stringToDouble(numberTwo)) / 2);
    }

    @RequestMapping("/sqrt/{number}")
    public Double squareRoot(@PathVariable("number")String number){
        numericValidation(number);
        return Math.sqrt(NumberConverter.stringToDouble(number));
    }

    private void numericValidation(String numberOne, String numberTwo) {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw new UnsuportedMathOperationException("Use numeric values only.");
    }

    private void numericValidation(String numberOne) {
        if (!NumberConverter.isNumeric(numberOne))
            throw new UnsuportedMathOperationException("Use numeric values only.");
    }

}
