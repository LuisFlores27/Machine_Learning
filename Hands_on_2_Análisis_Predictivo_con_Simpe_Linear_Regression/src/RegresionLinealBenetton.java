public class RegresionLinealBenetton {

    public static void main(String[] args) {

        // DATASET
        // X = Advertising
        // Y = Sales
        double[] advertising = {23, 26, 30, 34, 43, 48, 52, 57, 58};
        double[] sales = {651, 762, 856, 1063, 1190, 1298, 1421, 1440, 1518};

        // Numero total de datos
        int n = advertising.length;

        // VARIABLES PARA SUMATORIAS
        double sumX = 0;   // Σx
        double sumY = 0;   // Σy
        double sumXY = 0;  // Σ(x*y)
        double sumX2 = 0;  // Σ(x^2)


        // CALCULO DE SUMATORIAS
        for (int i = 0; i < n; i++) {

            sumX += advertising[i];                    // Suma de X
            sumY += sales[i];                          // Suma de Y
            sumXY += advertising[i] * sales[i];        // Suma de X*Y
            sumX2 += advertising[i] * advertising[i];  // Suma de X^2
        }


        // CÁLCULO DE B1 (Pendiente)
        // B1 = (nΣxy − ΣxΣy) / (nΣx^2 − (Σx)^2)
        double B1 = (n * sumXY - sumX * sumY) /
                    (n * sumX2 - Math.pow(sumX, 2));


        // CÁLCULO DE B0 (Intercepto)
        // B0 = ȳ − B1 * x̄
        double promedioX = sumX / n;   // Media de X
        double promedioY = sumY / n;   // Media de Y

        double B0 = promedioY - B1 * promedioX;


        // Modelo final:
        // y^ = B0 + B1x
        System.out.println("Ecuacion de Regresion Lineal:");
        System.out.printf("y^ = %.4f + %.4fx\n", B0, B1);


        // VALORES PARA PREDECIR
        double[] nuevosAdvertising = {35, 40, 45, 50, 60};

        System.out.println("\nPredicciones de Sales:");
        
        // Aplica la ecuacion a cada nuevo valor
        for (double x : nuevosAdvertising) {

            // Formula de prediccion:
            // y^ = B0 + B1x
            double prediccion = B0 + B1 * x;

            System.out.printf("Advertising: %.2f -> Sales estimadas: %.2f\n",
                    x, prediccion);
        }

    }
}
