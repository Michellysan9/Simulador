public class Edificio {
    // Atributos comunes para todos los edificios
    private String nombre;
    private int costo;
    private int beneficio;
    private int poblacionImpacto;
    private int consumoAgua;
    private int consumoEnergia;

    // Constructor
    public Edificio(String nombre, int costo, int beneficio, int poblacionImpacto, int consumoAgua, int consumoEnergia) {
        this.nombre = nombre;
        this.costo = costo;
        this.beneficio = beneficio;
        this.poblacionImpacto = poblacionImpacto;
        this.consumoAgua = consumoAgua;
        this.consumoEnergia = consumoEnergia;
    }

    // Getters para acceder a los atributos
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
}
