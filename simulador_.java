import java.util.ArrayList;
import java.util.Scanner;

// Clase abstracta base Edificio
abstract class Edificio {
    protected String nombre;
    protected int costo;
    protected int beneficio;
    protected int poblacionImpacto;
    protected int consumoAgua; 
    protected int consumoEnergia; 

    public Edificio(String nombre, int costo, int beneficio, int poblacionImpacto, int consumoAgua, int consumoEnergia) {
        this.nombre = nombre;
        this.costo = costo;
        this.beneficio = beneficio;
        this.poblacionImpacto = poblacionImpacto;
        this.consumoAgua = consumoAgua;
        this.consumoEnergia = consumoEnergia;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCosto() {
        return costo;
    }

    public int getBeneficio() {
        return beneficio;
    }

    public int getPoblacionImpacto() {
        return poblacionImpacto;
    }

    public int getConsumoAgua() {
        return consumoAgua;
    }

    public int getConsumoEnergia() {
        return consumoEnergia;
    }

    public abstract void mostrarInfo();
}

// Clase Residencial
class Residencial extends Edificio {
    private static final int COSTO = 1000;
    private static final int BENEFICIO = 50;
    private static final int POBLACION_IMPACTO = 80;
    private static final int CONSUMO_AGUA = 30; // Consumo de agua
    private static final int CONSUMO_ENERGIA = 20; // Consumo de energía

    public Residencial() {
        super("Vivienda ", COSTO, BENEFICIO, POBLACION_IMPACTO, CONSUMO_AGUA, CONSUMO_ENERGIA);
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Edificio: " + nombre + " | Costo: " + costo + " | Beneficio: " + beneficio + 
                           " | Impacto Población: " + poblacionImpacto + " | Consumo Agua: " + consumoAgua +
                           " | Consumo Energía: " + consumoEnergia);
    }
}

// Clase Comercial
class Comercial extends Edificio {
    private static final int COSTO = 1000;
    private static final int BENEFICIO = 200;
    private static final int POBLACION_IMPACTO = 30;
    private static final int CONSUMO_AGUA = 50; 
    private static final int CONSUMO_ENERGIA = 40; 

    public Comercial() {
        super("Tienda", COSTO, BENEFICIO, POBLACION_IMPACTO, CONSUMO_AGUA, CONSUMO_ENERGIA);
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Edificio: " + nombre + " | Costo: " + costo + " | Beneficio: " + beneficio + 
                           " | Impacto Población: " + poblacionImpacto + " | Consumo Agua: " + consumoAgua +
                           " | Consumo Energía: " + consumoEnergia);
    }
}

// Clase Industrial
class Industrial extends Edificio {
    private static final int COSTO = 1500;
    private static final int BENEFICIO = 400;
    private static final int POBLACION_IMPACTO = 15;
    private static final int CONSUMO_AGUA = 100; 
    private static final int CONSUMO_ENERGIA = 80; 

    public Industrial() {
        super("Fábrica", COSTO, BENEFICIO, POBLACION_IMPACTO, CONSUMO_AGUA, CONSUMO_ENERGIA);
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Edificio: " + nombre + " | Costo: " + costo + " | Beneficio: " + beneficio + 
                           " | Impacto Población: " + poblacionImpacto + " | Consumo Agua: " + consumoAgua +
                           " | Consumo Energía: " + consumoEnergia);
    }
}

// Clase principal simulador_
public class simulador_ {
    private static int presupuesto = 10000; // Presupuesto inicial
    private static int crecimiento = 0; // Crecimiento inicial de la ciudad
    private static int poblacion = 0; // Población inicial
    private static int agua = 500; // Cantidad inicial de agua
    private static int energia = 300; // Cantidad inicial de energía
    private static ArrayList<Edificio> edificios = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nPresupuesto: " + presupuesto + " | Crecimiento: " + crecimiento + 
                               " | Población: " + poblacion + " | Agua: " + agua + " | Energía: " + energia);
            System.out.println("1. Construir Vivienda ");
            System.out.println("2. Construir Tienda");
            System.out.println("3. Construir Fábrica");
            System.out.println("4. Mostrar Edificios");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    construirEdificio(new Residencial());
                    break;
                case 2:
                    construirEdificio(new Comercial());
                    break;
                case 3:
                    construirEdificio(new Industrial());
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

    // Método para construir un edificio y actualizar los valores de la simulación
    private static void construirEdificio(Edificio edificio) {
        if (presupuesto >= edificio.getCosto() && agua >= edificio.getConsumoAgua() && energia >= edificio.getConsumoEnergia()) {
            presupuesto -= edificio.getCosto();
            crecimiento += edificio.getBeneficio();
            poblacion += edificio.getPoblacionImpacto();
            agua -= edificio.getConsumoAgua(); // Reducir agua disponible
            energia -= edificio.getConsumoEnergia(); // Reducir energía disponible
            edificios.add(edificio);
            System.out.println("Construido: " + edificio.getNombre());
        } else {
            System.out.println("No hay suficiente presupuesto o recursos para construir este edificio.");
        }
    }

    // Método para mostrar la lista de edificios construidos y su impacto
    private static void mostrarEdificios() {
        if (edificios.isEmpty()) {
            System.out.println("No hay edificios construidos.");
        } else {
            System.out.println("Edificios construidos:");
            for (Edificio edificio : edificios) {
                edificio.mostrarInfo();
            }
        }
    }
}
