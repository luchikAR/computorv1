package src;

public class main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static void main(String[] args){

        /*        try {
            SolverPolynomial solverPolynomial = new SolverPolynomial(args[0]);
            solverPolynomial.printReducedForm();
        } catch (Exception e) {
                System.out.println(e.getMessage());
        }*/

        SolverPolynomial solverPolynomial;
        System.out.println("-------------TEST-------------");
        solverPolynomial = new SolverPolynomial("5 * X^0 + 4 * X^1 - 9.3 * X^2 = 1 * X^0");
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
/*        System.out.println("----------TEST4_bonus---------");
        solverPolynomial = new SolverPolynomial("5 + 4 * X + X^2= X^2");
        solverPolynomial.printReducedForm();
        System.out.println("As should be: 5 + 4 * X = 0");
        solverPolynomial.getSolution();*/
        System.out.println("----------TEST5_easy---------");
        solverPolynomial = new SolverPolynomial("- 3 * X^0 + 2 * X^1 + 1 * X^2 = 0");
        solverPolynomial.printReducedForm();
        System.out.println("As should be: -3 + 2 * X^1 + 1 * X^2 = 0");
        solverPolynomial.getSolution();
        System.out.println("------------------------------");

        System.out.println("----------TEST6_check---------");
        solverPolynomial = new SolverPolynomial("5 * X^0 = 5 * X^0");
        solverPolynomial.printReducedForm();
        System.out.println("As should be: 0 = 0");
        solverPolynomial.getSolution();
        System.out.println("------------------------------");

    }
}
