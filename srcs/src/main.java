package src;

public class main {
    public static void main(String[] args){

        /*        try {
            SolverPolynomial solverPolynomial = new SolverPolynomial(args[0]);
            solverPolynomial.printReducedForm();
        } catch (Exception e) {
                System.out.println(e.getMessage());
        }*/

//        testsFromSubject();
        testsFromCheckList();
//        testsFromMe();
    }

    private static void testsFromMe() {
        SolverPolynomial solverPolynomial;
        System.out.println("----------TEST5_easy---------");
        solverPolynomial = new SolverPolynomial("- 3 * X^0 + 2 * X^1 + 1 * X^2 = 0");
        solverPolynomial.printReducedForm();
        System.out.println("As should be: -3 + 2 * X^1 + 1 * X^2 = 0");
        solverPolynomial.getSolution();
        System.out.println("------------------------------");
    }

    private static void testsFromCheckList() {
        SolverPolynomial solverPolynomial;
        System.out.println("----------TEST6_check---------");
        solverPolynomial = new SolverPolynomial("5 * X^0 = 5 * X^0");
        solverPolynomial.printReducedForm();
        System.out.println("As should be: 0 = 0");
        solverPolynomial.getSolution();

        System.out.println("----------TEST7_check---------");
        solverPolynomial = new SolverPolynomial("4 * X^0 = 8 * X^0");
        solverPolynomial.printReducedForm();
        solverPolynomial.getSolution();

        System.out.println("----------TEST8_check---------");
        solverPolynomial = new SolverPolynomial("5 * X^0 = 4 * X^0 + 7 * X^1");
        solverPolynomial.printReducedForm();
        solverPolynomial.getSolution();

        System.out.println("----------TEST9_check---------");
        solverPolynomial = new SolverPolynomial("5 * X^0 + 13 * X^1 + 3 * X^2 = 1 * X^0 + 1 * X^1");
        solverPolynomial.printReducedForm();
        solverPolynomial.getSolution();

        System.out.println("---------TEST10_check---------");
        solverPolynomial = new SolverPolynomial("6 * X^0 + 11 * X^1 + 5 * X^2 = 1 * X^0 + 1 * X^1");
        solverPolynomial.printReducedForm();
        solverPolynomial.getSolution();

        System.out.println("---------TEST11_check---------");
        solverPolynomial = new SolverPolynomial("5 * X^0 + 3 * X^1 + 3 * X^2 = 1 * X^0 + 0 * X^1");
        solverPolynomial.printReducedForm();
        solverPolynomial.getSolution();

        System.out.println("-------TEST12_check_last------");
        solverPolynomial = new SolverPolynomial("5 * X^0 + 1 * X^3 = 4 * X^0 + 2 * X^1 + 1 * X^3");
        solverPolynomial.printReducedForm();
        System.out.println("3 степень должена сократиться.");
        solverPolynomial.getSolution();

        System.out.println("-------TEST13_check_last------");
        solverPolynomial = new SolverPolynomial("5 * X^0 + 1 * X^15 = 4 * X^0 + 2 * X^1 + 2 * X^15");
        solverPolynomial.printReducedForm();
        System.out.println("15 степень не должена сократиться.");
        solverPolynomial.getSolution();
    }

    private static void testsFromSubject() {
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
    }
}
