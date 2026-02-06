package github.com.WellingtonMBraganca.rest_with_springboot_and_java.math;

public class SimpleMath {
    public Double sum(double n1, double n2) {
        return n1 + n2;
    }

    public Double subtraction(double n1, double n2) {
        return n1 - n2;
    }

    public Double division(double n1, double n2) {
        return n1 / n2;
    }

    public Double multiplication(double n1, double n2) {
        return n1 * n2;
    }

    public Double mean(double n1, double n2) {
        return (n1 + n2) / 2;
    }

    public Double squareRoot(double n) {
        return Math.sqrt(n);
    }
}
