package modelo;

public class ReglaVentilacionConfortable implements Regla {

    public ReglaVentilacionConfortable() {
    }

    @Override
    public void aplicar(Sensor[] sensores, Actuador[] actuadores) {
        System.out.println("Aplicando regla: Ventilación Confortable");

        // Buscar sensor de temperatura
        for (int i = 0; i < sensores.length; i++) {
            if (sensores[i] != null && sensores[i].getID().equals("temp")) {
                if (sensores[i].getValor() > 25.0) {
                    // Buscar ventilador y encenderlo
                    for (int j = 0; j < actuadores.length; j++) {
                        if (actuadores[j] != null && actuadores[j].getID().equals("fan")) {
                            actuadores[j].ejecutarAccion("ON");
                            System.out.println("→ Ventilador encendido (hace calor)");
                        }
                    }
                }
            }
        }
    }
}