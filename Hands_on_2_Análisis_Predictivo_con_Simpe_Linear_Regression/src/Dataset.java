/*
 * Clase Dataset
 * -------------------------
 * Esta clase únicamente almacena los datos del problema.
 * 
 * X = Advertising
 * Y = Sales
 */

public class Dataset {

    // Valores de Advertising (Variable independiente X)
    public double[] advertising = {
        23, 26, 30, 34, 43, 48, 52, 57, 58
    };

    // Valores de Sales (Variable dependiente Y)
    public double[] sales = {
        651, 762, 856, 1063, 1190,
        1298, 1421, 1440, 1518
    };
}

/*
 * Clase RegresionLineal
 * --------------------------------
 * Esta clase se encarga de:
 * 
 * 1. Calcular los coeficientes B0 y B1
 * 2. Construir la ecuación de regresión
 * 3. Realizar predicciones
 */

public class RegresionLineal {

    // Coeficientes de la ecuación
    private double B0;
    private double B1;

    /*
     * Método para calcular el modelo matemático
     * usando Regresión Lineal Simple.
     */
    public void calcularModelo(double[] x, double[] y) {

        // Número total de datos
        int n = x.length;

        // Variables para sumatorias
        double sumX = 0;
        double sumY = 0;
        double sumXY = 0;
        double sumX2 = 0;

        // ========================================
        // Cálculo de sumatorias
        // ========================================
        for (int i = 0; i < n; i++) {

            sumX += x[i];           // Σx
            sumY += y[i];           // Σy
            sumXY += x[i] * y[i];   // Σxy
            sumX2 += x[i] * x[i];   // Σx²
        }

        // ========================================
        // Fórmula de B1 (Pendiente)
        // ========================================
        B1 = (n * sumXY - sumX * sumY) /
             (n * sumX2 - Math.pow(sumX, 2));

        // ========================================
        // Promedios
        // ========================================
        double promedioX = sumX / n;
        double promedioY = sumY / n;

        // ========================================
        // Fórmula de B0 (Intercepto)
        // ========================================
        B0 = promedioY - B1 * promedioX;
    }

    /*
     * Método para imprimir la ecuación final.
     */
    public void mostrarEcuacion() {

        System.out.println("==================================");
        System.out.println("Ecuación de Regresión Lineal:");
        System.out.printf("y^ = %.4f + %.4fx\n", B0, B1);
        System.out.println("==================================");
    }

    /*
     * Método para realizar predicciones.
     * 
     * Fórmula:
     * y^ = B0 + B1x
     */
    public double predecir(double x) {

        return B0 + B1 * x;
    }
}

/*
 * Clase Main
 * --------------------------------
 * Esta clase ejecuta todo el programa.
 */

public class Main {

    public static void main(String[] args) {

        // ========================================
        // Crear objeto Dataset
        // ========================================
        Dataset datos = new Dataset();

        // ========================================
        // Crear objeto de Regresión Lineal
        // ========================================
        RegresionLineal modelo = new RegresionLineal();

        // ========================================
        // Entrenar modelo con los datos
        // ========================================
        modelo.calcularModelo(
                datos.advertising,
                datos.sales
        );

        // ========================================
        // Mostrar ecuación de regresión
        // ========================================
        modelo.mostrarEcuacion();

        // ========================================
        // Nuevos valores de Advertising
        // para realizar predicciones
        // ========================================
        double[] nuevosAdvertising = {
            35, 40, 45, 50, 60
        };

        System.out.println("\nPredicciones:");

        // ========================================
        // Calcular e imprimir predicciones
        // ========================================
        for (double x : nuevosAdvertising) {

            double prediccion = modelo.predecir(x);

            System.out.printf(
                "Advertising: %.2f -> Sales estimadas: %.2f\n",
                x,
                prediccion
            );
        }

        System.out.println("==================================");
    }
}