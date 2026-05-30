package modelo;

public class SmartTecnoHouse {

    private Sensor[] sensores;
    private Actuador[] actuadores;
    private Regla[] reglas;

    private int numSensores;
    private int numActuadores;
    private int numReglas;

    public SmartTecnoHouse() {
        sensores = new Sensor[10];
        actuadores = new Actuador[10];
        reglas = new Regla[10];
        numSensores = 0;
        numActuadores = 0;
        numReglas = 0;
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

    public void añadirRegla(Regla r) {
        if (numReglas < 10) {
            reglas[numReglas] = r;
            numReglas = numReglas + 1;
        }
    }

    public void actualizarSensores() {
        for (int i = 0; i < numSensores; i++) {
            sensores[i].actualizarValor();
        }
    }

    public void aplicarReglas() {
        for (int i = 0; i < numReglas; i++) {
            reglas[i].aplicar(sensores, actuadores);
        }
    }

    public String getEstadoComoString() {
        String texto = "=== ESTADO DE LA CASA ===\n\nSensores:\n";

        for (int i = 0; i < numSensores; i++) {
            texto += "- " + sensores[i].getNombre() + ": " + sensores[i].getEstadoActual() + "\n";
        }

        texto += "\nActuadores:\n";
        for (int i = 0; i < numActuadores; i++) {
            texto += "- " + actuadores[i].getNombre() + ": " + actuadores[i].getEstadoActual() + "\n";
        }

        return texto;
    }

    // Método auxiliar para saber cuántas reglas hay
    public int getNumReglas() {
        return numReglas;
    }
}