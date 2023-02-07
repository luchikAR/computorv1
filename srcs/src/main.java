package src;

import java.util.*;

public class main {

    public static void main(String[] args){

        System.out.println("-------------TEST-------------");
        SolverPolynomial solverPolynomial = new SolverPolynomial("5 * X^0 + 4 * X^1 - 9.3 * X^2 = 1 * X^0");
        solverPolynomial.printReducedForm();
        System.out.println("As should be: 4 * X^0 + 4 * X^1 - 9.3 * X^2 = 0");
        solverPolynomial.getSolution();
        System.out.println("-------------TEST2------------");
        solverPolynomial = new SolverPolynomial("5 * X^0 + 4 * X^1 = 4 * X^0");
        solverPolynomial.printReducedForm();
        System.out.println("As should be: 1 * X^0 + 4 * X^1 = 0");
        solverPolynomial.getSolution();
        System.out.println("-------------TEST3------------");
        solverPolynomial = new SolverPolynomial("8 * X^0 - 6 * X^1 + 0 * X^2 - 5.6 * X^3 = 3 * X^0");
        solverPolynomial.printReducedForm();
        System.out.println("As should be: 5 * X^0 - 6 * X^1 + 0 * X^2 - 5.6 * X^3 = 0");
        solverPolynomial.getSolution();
//        System.out.println("----------TEST4_bonus---------");
//        solverPolynomial = new SolverPolynomial("5 + 4 * X + X^2= X^2");
//        solverPolynomial.printReducedForm();
//        System.out.println("As should be: 5 + 4 * X = 0");
//        solverPolynomial.getSolution();
        System.out.println("----------TEST5_easy---------");
        solverPolynomial = new SolverPolynomial("- 3 * X^0 + 2 * X^1 + 1 * X^2 = 0");
        solverPolynomial.printReducedForm();
        System.out.println("As should be: -3 + 2 * X^1 + 1 * X^2 = 0");
        solverPolynomial.getSolution();
        System.out.println("------------------------------");

//        try {
//            SolverPolynomial solverPolynomial = new SolverPolynomial(args[0]);
//            solverPolynomial.printReducedForm();
//        } catch (Exception e) {
//                System.out.println(e.getMessage());
//        }
    }
}
