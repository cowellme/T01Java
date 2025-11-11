package org;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var vertexCount = 3;
        var xNumbers = new double[vertexCount];
        var yNumbers = new double[vertexCount];
        var result = ParseNumbers(xNumbers, yNumbers, vertexCount);
        if(result == 0 && isTriangle(xNumbers, yNumbers)){
            var perimeter = CalculatePerimeter(xNumbers, yNumbers);

            if(perimeter == 0)
                System.out.printf("It's not a triangle%n");
            else
                System.out.printf("%.3f%n", perimeter);
        }
        else System.out.printf("It's not a triangle%n");
    }

    private static double CalculatePerimeter(double[] xNumbers, double[] yNumbers) {
        var result = .0;

        try {
            result += Math.sqrt(Math.pow(xNumbers[1] - xNumbers[0], 2) + Math.pow(yNumbers[1] - yNumbers[0], 2));
            result += Math.sqrt(Math.pow(xNumbers[2] - xNumbers[1], 2) + Math.pow(yNumbers[2] - yNumbers[1], 2));
            result += Math.sqrt(Math.pow(xNumbers[0] - xNumbers[2], 2) + Math.pow(yNumbers[0] - yNumbers[2], 2));
        }
        catch (Exception e){
            System.out.printf(e.getMessage() + '\n');
            return 0;
        }

        return result;
    }

    public static boolean isTriangle(double[] xNumbers, double[] yNumbers) {
        // Вычисляем площадь треугольника по формуле
        double area = Math.abs((xNumbers[0] * (yNumbers[1] - yNumbers[2]) + xNumbers[1] * (yNumbers[2] - yNumbers[0]) + xNumbers[2] * (yNumbers[0] - yNumbers[1])) / 2.0
        );

        // Если площадь близка к нулю - точки на одной прямой
        return area > 1e-10; // учитываем погрешность вычислений
    }

    private static int ParseNumbers(double[] xNumbers, double[] yNumbers, int vertexCount){
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        try {

            System.out.println("input " + vertexCount + " vertex (x y):");
            for (int i = 0; i < vertexCount; i++) {
                xNumbers[i] = scanner.nextDouble();
                yNumbers[i] = scanner.nextDouble();
            }

        }
        catch (Exception e){
            scanner.close();
            System.out.printf(e.getMessage() + '\n');
            return -1;
        }
        finally {
            scanner.close();
        }

        return 0;
    }

}