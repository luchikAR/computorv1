package src;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class SolverPolynomial {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	private static final double ZERO = 0.0;
	DecimalFormat decimalFormat = new DecimalFormat("#.######");
	private HashMap<Integer, Double> other_degree = new HashMap<>();
	private Double value_degree0;
	private Double value_degree1;
	private Double value_degree2;

	boolean initSuccess;

	SolverPolynomial() {
		initSuccess = false;
	}

	SolverPolynomial(String inputString) {
		init(inputString);
	}

	public void init(String inputString) {
		value_degree0 = value_degree1 = value_degree2 = ZERO;
		initSuccess = false;
		String[] splitArgs = inputString.split(" ");
		Double multiplier = 1.0;
		boolean isRightSide = false;

		for (String arg : splitArgs) {
			if (isNumeric(arg)) {
				multiplier = multiplier.equals(-1.0) ? Double.parseDouble(arg) * -1 : Double.parseDouble(arg);
			} else if ("=".equals(arg)) {
				if (isRightSide)
					printError("Не верное выражение: '='");
				isRightSide = true;
			} else if ("-".equals(arg)) {
				multiplier *= -1;
			} else if (arg.contains("X^")) {
				arg = arg.replace("X^", "");
				try {
					Integer degree = arg.isEmpty() ? 0 : Integer.parseInt(arg);
					if (isRightSide)
						multiplier *= -1;
					addValueDegree(degree, multiplier);
					multiplier = 1.0;
				} catch (NumberFormatException e) {
					printError("Не верный формат степени: " + arg + ".\nОжидается X^[0-2]");
					return;
				}
			}
		}
		for (Map.Entry<Integer, Double> entry : other_degree.entrySet()) {
			if (!entry.getValue().equals(0.0)) {
				printError("Polynomial degree: " + entry.getKey() + ".");
				printError("The polynomial degree is strictly greater than 2, I can't solve.");
				return;
			}
		}
		initSuccess = true;
	}

	public void printReducedForm() {
		if (!initSuccess) {
			printError("Было задано не верное уравнение. I can't print reduced form.");
			return;
		}

		boolean isNeedPrintPlus = false;
		String reducedForm = "";
		int degree = maxDegree();

		System.out.print(ANSI_YELLOW + "Reduced form: ");
		if (degree == -1) {
			reducedForm += "0 ";
		}
		if (!value_degree0.equals(ZERO)) {
			reducedForm += decimalFormat.format(value_degree0) + " * X^0 ";
			isNeedPrintPlus = true;
		}

		if (value_degree1 > ZERO) {
			if (isNeedPrintPlus)
				reducedForm += "+ " + decimalFormat.format(value_degree1) + " * X^1 ";
			else
				reducedForm += decimalFormat.format(value_degree1) + " * X^1 ";
			isNeedPrintPlus = true;
		} else if (value_degree1 < ZERO) {
			if (isNeedPrintPlus)
				reducedForm += "- " + decimalFormat.format(value_degree1 * -1) + " * X^1 ";
			else
				reducedForm += decimalFormat.format(value_degree1) + " * X^1 ";
			isNeedPrintPlus = true;
		}

		if (value_degree2 > ZERO) {
			if (isNeedPrintPlus)
				reducedForm += "+ " + decimalFormat.format(value_degree2) + " * X^2 ";
			else
				reducedForm += decimalFormat.format(value_degree2) + " * X^2 ";
			isNeedPrintPlus = true;
		} else if (value_degree2 < ZERO) {
			if (isNeedPrintPlus)
				reducedForm += "- " + decimalFormat.format(value_degree2 * -1) + " * X^2 ";
			else
				reducedForm += decimalFormat.format(value_degree2 * -1) + " * X^2 ";
			isNeedPrintPlus = true;
		}
		reducedForm += "= 0";
		System.out.println(reducedForm);
		degree = degree == -1 ? 0 : degree;
		System.out.println("Polynomial degree: " + degree + ANSI_RESET);
	}

	private void printError(String message) {
		System.out.println(ANSI_RED + message + ANSI_RESET);
	}

	public void getSolution() {
		if (!initSuccess) {
			printError("Было задано не верное уравнение. I can't solve.");
			return;
		}

		System.out.print(ANSI_GREEN);
		if (value_degree0.equals(0.0) && value_degree1.equals(0.0) && value_degree2.equals(0.0)) {
			System.out.println("Any real number is a solution!");
		} else if (value_degree1.equals(0.0) && value_degree2.equals(0.0)) {
			System.out.println("there is no solution!");
		} else if (value_degree2.equals(0.0))
			linearEquation();
		else
			quadraticEquation();
		System.out.print(ANSI_RESET);
	}

	private void linearEquation() {
		double answer = (-1 * value_degree0) / value_degree1;
		System.out.println("The solution is:");
		System.out.println(decimalFormat.format(answer));
	}

	private void quadraticEquation() {
		double d = value_degree1 * value_degree1 - (4 * value_degree0 * value_degree2);

		double sqrt = sqrt(d);
		if (sqrt < 0) {
			System.out.println("Так как дискриминант меньше нуля, то уравнение не имеет действительных решений.");
		} else if (sqrt == 0.0) {
			double answer1 = (-value_degree1) / (2 * value_degree2);
			System.out.println("Дискриминант равен нулю, следовательно существует только одно решение:");
			System.out.println(decimalFormat.format(answer1));
		} else if (sqrt > 0) {
			System.out.println("Discriminant is strictly positive, the two solutions are:");
			double answer1 = (-value_degree1 - sqrt) / (2 * value_degree2);
			double answer2 = (-value_degree1 + sqrt) / (2 * value_degree2);
			System.out.println(decimalFormat.format(answer1));
			System.out.println(decimalFormat.format(answer2));
		}
	}

	private double sqrt(double x) {
		double y = (1 + x) / 2; // first approximation
		double z = 0;
		if (x <= 0)
			return x;
		while (fabs(y - z) > 0.00000000001) { // desired precision
			z = y;
			y = (y + x / y) / 2;
		}
		return y;
	}

	private double fabs(double v) {
		if (v < 0) {
			return (v * -1);
		}
		return v;
	}

	private int maxDegree() {
		if (!value_degree2.equals(0.0))
			return 2;
		if (!value_degree1.equals(0.0))
			return 1;
		if (!value_degree0.equals(0.0))
			return 0;
		return -1;
	}

	private void addValueDegree(Integer degree, Double multiplier) {
		switch (degree) {
			case 0:
				value_degree0 += multiplier;
				break;
			case 1:
				value_degree1 += multiplier;
				break;
			case 2:
				value_degree2 += multiplier;
				break;
			default:
				Double value = other_degree.get(degree) == null ? 0.0 : other_degree.get(degree);
				other_degree.put(degree, value + multiplier);
				break;
		}
	}

	private static boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
