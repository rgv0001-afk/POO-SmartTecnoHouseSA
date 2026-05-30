package modelo;

import java.io.*;

public class ReglaVentilacionConfortable implements Regla {

    public ReglaVentilacionConfortable() {
    }

    @Override
    public void aplicar(Sensor[] sensores, Actuador[] actuadores) {
        for (int i = 0; i < sensores.length; i++) {
            if (sensores[i] != null && sensores[i].getID().equals("temp")) {
                double temp = sensores[i].getValor();

                for (int j = 0; j < actuadores.length; j++) {
                    if (actuadores[j] != null && actuadores[j].getID().equals("fan")) {
                        if (temp > 24.0) {
                            actuadores[j].ejecutarAccion("ON");
                            System.out.println("→ VENTILADOR ENCENDIDO");
                            registrarAccion("Ventilador -> ON (temperatura: " + temp + ")");
                        } else {
                            actuadores[j].ejecutarAccion("OFF");
                            System.out.println("→ VENTILADOR APAGADO");
                            registrarAccion("Ventilador -> OFF (temperatura: " + temp + ")");
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