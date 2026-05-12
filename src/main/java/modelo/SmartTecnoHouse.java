package modelo;

public class SmartTecnoHouse {

    private Sensor[] sensores;
    private Actuador[] actuadores;
    private int numSensores;
    private int numActuadores;

    public SmartTecnoHouse() {
        sensores = new Sensor[10];
        actuadores = new Actuador[10];
        numSensores = 0;
        numActuadores = 0;
    }

    public void añadirSensor(Sensor s) {
        if (numSensores < 10) {
            sensores[numSensores] = s;
            numSensores = numSensores + 1;
        }
    }

    public void añadirActuador(Actuador a) {
        if (numActuadores < 10) {
            actuadores[numActuadores] = a;
            numActuadores = numActuadores + 1;
        }
    }

    public void actualizarSensores() {
        for (int i = 0; i < numSensores; i++) {
            sensores[i].actualizarValor();
        }
    }

    public void mostrarEstado() {
        System.out.println("=== ESTADO DE LA CASA ===");

        System.out.println("Sensores:");
        for (int i = 0; i < numSensores; i++) {
            System.out.println("- " + sensores[i].getNombre() + ": " + sensores[i].getEstadoActual());
        }

        System.out.println("Actuadores:");
        for (int i = 0; i < numActuadores; i++) {
            System.out.println("- " + actuadores[i].getNombre() + ": " + actuadores[i].getEstadoActual());
        }
    }
}