package modelo;

public class ReglaVentilacionConfortable implements Regla {

    public ReglaVentilacionConfortable() {
    }

    @Override
    public void aplicar(Sensor[] sensores, Actuador[] actuadores) {
        System.out.println("=== REGLA VENTILACIÓN ===");

        for (int i = 0; i < sensores.length; i++) {
            if (sensores[i] != null && sensores[i].getID().equals("temp")) {
                double temp = sensores[i].getValor();
                System.out.println("Temperatura: " + temp);

                if (temp > 24.0) {
                    for (int j = 0; j < actuadores.length; j++) {
                        if (actuadores[j] != null && actuadores[j].getID().equals("fan")) {
                            actuadores[j].ejecutarAccion("ON");
                            System.out.println("→ VENTILADOR ENCENDIDO");
                        }
                    }
                } else {
                    for (int j = 0; j < actuadores.length; j++) {
                        if (actuadores[j] != null && actuadores[j].getID().equals("fan")) {
                            actuadores[j].ejecutarAccion("OFF");
                            System.out.println("→ VENTILADOR APAGADO");
                        }
                    }
                }
            }
        }
    }
}