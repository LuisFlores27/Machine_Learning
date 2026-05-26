public class RegresionLineal {

    /*
     * B0 = Intercepto
     * Representa el punto donde la linea cruza el eje Y
    */
    private double B0;

    /*
     * B1 = Pendiente
     * Representa cuanto aumentan las ventas cuando aumenta la publicidad
     */
    private double B1;

    public void calcularModelo(double[] x, double[] y) {

        int n = x.length; //Cantidad total de datos

        double sumX = 0; // Suma de todos los valores X
        double sumY = 0; // Suma de todos los valores Y
        double sumXY = 0; // Suma de X multiplicado por Y
        double sumX2 = 0; // Suma de X al cuadrado

        for (int i = 0; i < n; i++) {

            sumX += x[i]; // Acumula valores de X
            sumY += y[i]; // Acumula valores de Y
            sumXY += x[i] * y[i]; // Multiplica X por Y
            sumX2 += x[i] * x[i]; // Calcula X²
        }

         /*
         * Calculo de B1 (Pendiente)
         * 
         * Formula: B1 = (nΣxy − ΣxΣy) / (nΣx² − (Σx)²)
         */
        B1 = (n * sumXY - sumX * sumY) /
             (n * sumX2 - Math.pow(sumX, 2));

        //Cálculo de promedios.
        double promedioX = sumX / n;
        double promedioY = sumY / n;

         /*
         * Calculo de B0 (Intercepto)
         *
         * Formula: B0 = promedioY - B1(promedioX)
         */
        B0 = promedioY - B1 * promedioX;
    }

    public void mostrarEcuacion() {

        System.out.println("==================================");
        System.out.println("Ecuación de Regresión Lineal:");
        System.out.printf("y^ = %.4f + %.4fx\n", B0, B1);
        System.out.println("==================================");
    }

    public double predecir(double x) {

        /*
         * Formula de prediccion:
         * 
         * y^ = B0 + B1x
         */
        return B0 + B1 * x;
    }
}