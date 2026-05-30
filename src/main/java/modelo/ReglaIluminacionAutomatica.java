package modelo;

public class ReglaIluminacionAutomatica implements Regla {

    public ReglaIluminacionAutomatica() {
    }

    @Override
    public void aplicar(Sensor[] sensores, Actuador[] actuadores) {
        System.out.println("=== REGLA ILUMINACIÓN ===");

        for (int i = 0; i < sensores.length; i++) {
            if (sensores[i] != null && sensores[i].getID().equals("light")) {
                double luz = sensores[i].getValor();
                System.out.println("Luz detectada: " + luz);

                for (int j = 0; j < actuadores.length; j++) {
                    if (actuadores[j] != null) {

                        // Control de la bombilla
                        if (actuadores[j].getID().equals("bulb")) {
                            if (luz < 60.0) {
                                actuadores[j].ejecutarAccion("ON");
                                System.out.println("→ BOMBILLA ENCENDIDA");
                            } else {
                                actuadores[j].ejecutarAccion("OFF");
                                System.out.println("→ BOMBILLA APAGADA");
                            }
                        }

                        // Control de la persiana (nuevo)
                        if (actuadores[j].getID().equals("persiana")) {
                            if (luz > 70.0) {           // mucha luz = día
                                actuadores[j].ejecutarAccion("UP");
                                System.out.println("→ PERSIANA SUBIDA (día)");
                            } else {
                                actuadores[j].ejecutarAccion("DOWN");
                                System.out.println("→ PERSIANA BAJADA (noche)");
                            }
                        }
                    }
                }
            }
        }
    }
}