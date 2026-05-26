public class Main {

    public static void main(String[] args) {

        Dataset datos = new Dataset();

        RegresionLineal modelo = new RegresionLineal();

        modelo.calcularModelo(
                datos.advertising,
                datos.sales
        );

        modelo.mostrarEcuacion();

        double[] nuevosAdvertising = {
            35, 40, 45, 50, 60
        };

        System.out.println("\nPredicciones:");

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