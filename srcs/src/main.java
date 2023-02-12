

public class main {
	public static void main(String[] args) {

		String input = String.join(" ", args);
		try {
            SolverPolynomial solverPolynomial = new SolverPolynomial(input);
			solverPolynomial.printReducedForm();
			solverPolynomial.getSolution();
        } catch (Exception e) {
                System.out.println(e.getMessage());
        }

//        testsFromSubject();
//		testsFromCheckList();
//		testsFromCheckListBonus();
//		testsErrors();
//        testsFromMe();
	}

	private static void testsErrors() {
		SolverPolynomial solverPolynomial;
		System.out.println("----------TEST15_error---------");
		printTrueSolution("As should be: 1 = 0");
		solverPolynomial = new SolverPolynomial("1 = 0");
		solverPolynomial.printReducedForm();
		solverPolynomial.getSolution();
		printTrueSolution("Нет решения.");
		System.out.println("----------TEST17_error---------");
		printTrueSolution("пустая строка");
		solverPolynomial = new SolverPolynomial("");
		solverPolynomial.printReducedForm();
		solverPolynomial.getSolution();
		System.out.println("----------TEST18_error---------");
		printTrueSolution("пустая строка");
		solverPolynomial = new SolverPolynomial("       ");
		solverPolynomial.printReducedForm();
		solverPolynomial.getSolution();
		System.out.println("----------TEST19_error---------");
		printTrueSolution("ti pupsik");
		solverPolynomial = new SolverPolynomial("ti pupsik");
		solverPolynomial.printReducedForm();
		solverPolynomial.getSolution();
	}

	private static void testsFromCheckListBonus() {
		SolverPolynomial solverPolynomial;
		System.out.println("----------TEST14_bonus---------");
		printTrueSolution("As should be: 5 + 4 * X = 0");
		solverPolynomial = new SolverPolynomial("5 + 4 * X + X^2 = X^2");
		solverPolynomial.printReducedForm();
        solverPolynomial.getSolution();
	}

	private static void testsFromMe() {
		SolverPolynomial solverPolynomial;
		System.out.println("----------TEST5_easy---------");
		printTrueSolution("As should be: -3 + 2 * X^1 + 1 * X^2 = 0");
		solverPolynomial = new SolverPolynomial("- 3 * X^0 + 2 * X^1 + 1 * X^2 = 0");
		solverPolynomial.printReducedForm();
		solverPolynomial.getSolution();
		System.out.println("----------TEST16_error---------");
		printTrueSolution("As should be: X^2 = 0");
		solverPolynomial = new SolverPolynomial("X^2 = 0");
		solverPolynomial.printReducedForm();
		solverPolynomial.getSolution();
		printTrueSolution("0");
	}

	private static void testsFromCheckList() {
		SolverPolynomial solverPolynomial;
		System.out.println("----------TEST6_check---------");
		printTrueSolution("As should be: 0 = 0");
		solverPolynomial = new SolverPolynomial("5 * X^0 = 5 * X^0");
		solverPolynomial.printReducedForm();
		solverPolynomial.getSolution();

		System.out.println("----------TEST7_check---------");
		printTrueSolution("Нет решения");
		solverPolynomial = new SolverPolynomial("4 * X^0 = 8 * X^0");
		solverPolynomial.printReducedForm();
		solverPolynomial.getSolution();

		System.out.println("----------TEST8_check---------");
		printTrueSolution("Линейное уравнение. 1 решение");
		solverPolynomial = new SolverPolynomial("5 * X^0 = 4 * X^0 + 7 * X^1");
		solverPolynomial.printReducedForm();
		solverPolynomial.getSolution();
		printTrueSolution("0,142857");

		System.out.println("----------TEST9_check---------");
		printTrueSolution("Квадратное уравнение. 2 решение");
		solverPolynomial = new SolverPolynomial("5 * X^0 + 13 * X^1 + 3 * X^2 = 1 * X^0 + 1 * X^1");
		solverPolynomial.printReducedForm();
		solverPolynomial.getSolution();
		printTrueSolution("-3.632993\n-0.367006");

		System.out.println("---------TEST10_check---------");
		printTrueSolution("Квадратное уравнение. 1 решение");
		solverPolynomial = new SolverPolynomial("6 * X^0 + 11 * X^1 + 5 * X^2 = 1 * X^0 + 1 * X^1");
		solverPolynomial.printReducedForm();
		solverPolynomial.getSolution();
		printTrueSolution("-1");

		System.out.println("---------TEST11_check---------");
		printTrueSolution("Квадратное уравнение. 0 решений");
		solverPolynomial = new SolverPolynomial("5 * X^0 + 3 * X^1 + 3 * X^2 = 1 * X^0 + 0 * X^1");
		solverPolynomial.printReducedForm();
		solverPolynomial.getSolution();

		System.out.println("-------TEST12_check_last------");
		printTrueSolution("3 степень должена сократиться.");
		solverPolynomial = new SolverPolynomial("5 * X^0 + 1 * X^3 = 4 * X^0 + 2 * X^1 + 1 * X^3");
		solverPolynomial.printReducedForm();
		solverPolynomial.getSolution();
		printTrueSolution("0,5");

		System.out.println("-------TEST13_check_last------");
		printTrueSolution("15 степень не должена сократиться.");
		solverPolynomial = new SolverPolynomial("5 * X^0 + 1 * X^15 = 4 * X^0 + 2 * X^1 + 2 * X^15");
		solverPolynomial.printReducedForm();
		solverPolynomial.getSolution();
	}

	private static void testsFromSubject() {
		SolverPolynomial solverPolynomial;
		System.out.println("-------------TEST-------------");
		printTrueSolution("As should be: 4 * X^0 + 4 * X^1 - 9.3 * X^2 = 0");
		solverPolynomial = new SolverPolynomial("5 * X^0 + 4 * X^1 - 9.3 * X^2 = 1 * X^0");
		solverPolynomial.printReducedForm();
		solverPolynomial.getSolution();
		printTrueSolution("0.905239\n-0.475131");
		System.out.println("-------------TEST2------------");
		printTrueSolution("As should be: 1 * X^0 + 4 * X^1 = 0");
		solverPolynomial = new SolverPolynomial("5 * X^0 + 4 * X^1 = 4 * X^0");
		solverPolynomial.printReducedForm();
		solverPolynomial.getSolution();
		printTrueSolution("-0.25");
		System.out.println("-------------TEST3------------");
		printTrueSolution("As should be: 5 * X^0 - 6 * X^1 + 0 * X^2 - 5.6 * X^3 = 0");
		solverPolynomial = new SolverPolynomial("8 * X^0 - 6 * X^1 + 0 * X^2 - 5.6 * X^3 = 3 * X^0");
		solverPolynomial.printReducedForm();
		solverPolynomial.getSolution();
		printTrueSolution("The polynomial degree is strictly greater than 2, I can't solve.");
	}

	private static void printTrueSolution(String str) {
		System.out.println(SolverPolynomial.ANSI_PURPLE + str + SolverPolynomial.ANSI_RESET);
	}
}
