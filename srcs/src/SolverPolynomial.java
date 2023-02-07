package src;

import java.text.DecimalFormat;

public class SolverPolynomial {

//    private ArrayList<Integer> elements_degree2 = new ArrayList<Integer>();
//    private ArrayList<Integer> elements_degree1 = new ArrayList<Integer>();
//    private ArrayList<Integer> elements_degree0 = new ArrayList<Integer>();

    private static final double ZERO = 0.0;
    DecimalFormat decimalFormat = new DecimalFormat("#.#");
    private Double value_degree0;
    private Double value_degree1;
    private Double value_degree2;
    SolverPolynomial() {
    }

    SolverPolynomial(String inputString) {
        init(inputString);
    }

    public void init(String inputString) {
        value_degree0 = value_degree1 = value_degree2 = ZERO;
        String[] splitArgs = inputString.split(" ");
        Double multiplier = 1.0;
        boolean isRightSide = false;

        for (String arg : splitArgs) {
            if (isNumeric(arg)) {
                multiplier = multiplier.equals(-1.0) ? Double.parseDouble(arg) * -1 : Double.parseDouble(arg);
            } else if("=".equals(arg)) {
                if (isRightSide)
                    System.out.printf("Не верное выражение: '='");
                isRightSide = true;
            } else if("-".equals(arg)) {
                multiplier *= -1;
            } else if (arg.contains("X^")) {
                arg = arg.replace("X^", "");
                try {
                    Integer degree = arg.isEmpty() ? 1 : Integer.parseInt(arg);
                    if (degree.doubleValue() > 2) {
                        System.out.println("Polynomial degree: " + degree + ".\nThe polynomial degree is strictly greater than 2, I can't solve.");
                        return;
                    }
                    if (isRightSide)
                        multiplier *= -1;
                    addValueDegree(degree, multiplier);
                    multiplier = 1.0;
                } catch (NumberFormatException e) {
                    System.out.println("Не верный формат степени: " + arg + ".\nОжидается X^[0-2]");
                    return;
                }
            }
        }
    }

    public void printReducedForm() {
        boolean isNeedPrintPlus = false;

        System.out.print("Reduced form: ");
        if (maxDegree() == -1) {
            System.out.println("Не верное выражение: отсутствует степень"); // не точно. может решение - любое?
        }
        if (!value_degree0.equals(ZERO)) {
            System.out.print(decimalFormat.format(value_degree0) + " * X^0 ");
            isNeedPrintPlus = true;
        }

        if (value_degree1 > ZERO) {
            if (isNeedPrintPlus)
                System.out.print("+ " + decimalFormat.format(value_degree1) + " * X^1 ");
            else
                System.out.print(decimalFormat.format(value_degree1) + " * X^1 ");
            isNeedPrintPlus = true;
        } else if (value_degree1 < ZERO) {
            if (isNeedPrintPlus)
                System.out.print("- " + decimalFormat.format(value_degree1 * -1) + " * X^1 ");
            else
                System.out.print(decimalFormat.format(value_degree1) + " * X^1 ");
            isNeedPrintPlus = true;
        }

        if (value_degree2 > ZERO) {
            if (isNeedPrintPlus)
                System.out.print("+ " + decimalFormat.format(value_degree2) + " * X^2 ");
            else
                System.out.print(decimalFormat.format(value_degree2) + " * X^2 ");
            isNeedPrintPlus = true;
        } else if (value_degree2 < ZERO) {
            if (isNeedPrintPlus)
                System.out.print("- " + decimalFormat.format(value_degree2 * -1) + " * X^2 ");
            else
                System.out.print(decimalFormat.format(value_degree2 * -1) + " * X^2 ");
            isNeedPrintPlus = true;
        }
        System.out.println("= 0");
        System.out.println("Polynomial degree: " + maxDegree());
    }

    public void getSolution() {
        double d = value_degree1 * value_degree1 - (4 * value_degree0 * value_degree2);

        double sqrt = sqrt(d);
//        System.out.println("корень из " + d + " = " + sqrt);
        if (sqrt < 0) {
            System.out.println("Так как дискриминант меньше нуля, то уравнение не имеет действительных решений.");
        }
        else if (sqrt > 0) {
            System.out.println("Так как дискриминант больше нуля то, квадратное уравнение имеет два действительных корня:");
            double answer1 = ( -value_degree1 - sqrt ) / 2 * value_degree2;
            double answer2 = ( -value_degree1 + sqrt ) / 2 * value_degree2;
//            System.out.println("x1 = " + decimalFormat.format(answer1));
//            System.out.println("x2 = " + decimalFormat.format(answer2));
            System.out.println("x1 = " + answer1);
            System.out.println("x2 = " + answer2);
        }
    }

    private double sqrt(double x) {
        double y = (1+x)/2; // first approximation
        double z = 0;
        if (x <= 0)
            return 0;  // if negative number maybe throw exception?
        while (fabs(y-z) > 0.00000000001) { // desired precision
            z = y;
            y = (y + x/y) / 2;
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
        if (!value_degree2.equals(0))
            return 2;
        if (!value_degree1.equals(0))
            return 1;
        if (!value_degree0.equals(0))
            return 0;
        return -1;
    }

    private void addValueDegree(Integer degree, Double multiplier) {
        switch (degree) {
            case 0: value_degree0 += multiplier; break;
            case 1: value_degree1 += multiplier; break;
            case 2: value_degree2 += multiplier; break;
        }
    }

    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}