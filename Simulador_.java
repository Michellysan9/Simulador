import java.util.ArrayList;
import java.util.Scanner;

public class Simulador_ {
    // Atributos del simulador
    private static int presupuesto = 10000;
    private static int crecimiento = 0;
    private static int poblacion = 0;
    private static int agua = 500;
    private static int energia = 300;
    private static ArrayList<Edificio> edificios = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nPresupuesto: " + presupuesto + " | Crecimiento: " + crecimiento +
                               " | Población: " + poblacion + " | Agua: " + agua + " | Energía: " + energia);
            System.out.println("1. Construir Vivienda");
            System.out.println("2. Construir Tienda");
            System.out.println("3. Construir Fábrica");
            System.out.println("4. Mostrar Edificios");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    construirEdificio(new Edificio("Vivienda", 1000, 50, 80, 30, 20));
                    break;
                case 2:
                    construirEdificio(new Edificio("Tienda", 1000, 200, 30, 50, 40));
                    break;
                case 3:
                    construirEdificio(new Edificio("Fábrica", 1500, 400, 15, 100, 80));
                    break;
                case 4:
                    mostrarEdificios();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 5);

        scanner.close();
    }

    private static void construirEdificio(Edificio edificio) {
        if (presupuesto >= edificio.getCosto() && agua >= edificio.getConsumoAgua() && energia >= edificio.getConsumoEnergia()) {
            presupuesto -= edificio.getCosto();
            crecimiento += edificio.getBeneficio();
            poblacion += edificio.getPoblacionImpacto();
            agua -= edificio.getConsumoAgua();
            energia -= edificio.getConsumoEnergia();
            edificios.add(edificio);
            System.out.println("Construido: " + edificio.getNombre());
        } else {
            System.out.println("No hay suficiente presupuesto o recursos para construir este edificio.");
        }
    }

    private static void mostrarEdificios() {
        if (edificios.isEmpty()) {
            System.out.println("No hay edificios construidos.");
        } else {
            System.out.println("Edificios construidos:");
            for (Edificio edificio : edificios) {
                System.out.println("Edificio: " + edificio.getNombre() + " | Costo: " + edificio.getCosto() +
                                   " | Beneficio: " + edificio.getBeneficio() + " | Impacto Población: " +
                                   edificio.getPoblacionImpacto() + " | Consumo Agua: " + edificio.getConsumoAgua() +
                                   " | Consumo Energía: " + edificio.getConsumoEnergia());
            }
        }
    }
}
