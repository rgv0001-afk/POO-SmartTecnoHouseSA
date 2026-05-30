package modelo;

import java.io.*;

public class ReglaIluminacionAutomatica implements Regla {

    public ReglaIluminacionAutomatica() {
    }

    @Override
    public void aplicar(Sensor[] sensores, Actuador[] actuadores) {
        for (int i = 0; i < sensores.length; i++) {
            if (sensores[i] != null && sensores[i].getID().equals("light")) {
                double luz = sensores[i].getValor();

                for (int j = 0; j < actuadores.length; j++) {
                    if (actuadores[j] != null) {

                        // Bombilla
                        if (actuadores[j].getID().equals("bulb")) {
                            if (luz < 60.0) {
                                actuadores[j].ejecutarAccion("ON");
                                System.out.println("→ BOMBILLA ENCENDIDA");
                                registrarAccion("Bombilla -> ON (luz: " + luz + ")");
                            } else {
                                actuadores[j].ejecutarAccion("OFF");
                                System.out.println("→ BOMBILLA APAGADA");
                                registrarAccion("Bombilla -> OFF (luz: " + luz + ")");
                            }
                        }

                        // Persiana
                        if (actuadores[j].getID().equals("persiana")) {
                            if (luz > 70.0) {
                                actuadores[j].ejecutarAccion("UP");
                                System.out.println("→ PERSIANA SUBIDA (día)");
                                registrarAccion("Persiana -> UP (luz: " + luz + ")");
                            } else {
                                actuadores[j].ejecutarAccion("DOWN");
                                System.out.println("→ PERSIANA BAJADA (noche)");
                                registrarAccion("Persiana -> DOWN (luz: " + luz + ")");
                            }
                        }
                    }
                }
            }
        }
    }

    private void registrarAccion(String accion) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("actuadores.log", true))) {
            pw.println(new java.util.Date() + " - " + accion);
        } catch (Exception e) {
            // silencioso
        }
    }
}