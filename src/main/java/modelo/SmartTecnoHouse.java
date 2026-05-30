package modelo;

import java.io.*;
import java.util.Scanner;

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

    public int getNumReglas() {
        return numReglas;
    }

    // ==================== PERSISTENCIA ====================

    public void guardarEstado() {
        try (PrintWriter pw = new PrintWriter("estado.json")) {
            pw.println("{");
            pw.println("  \"sensores\": [");
            for (int i = 0; i < numSensores; i++) {
                pw.print("    { \"id\": \"" + sensores[i].getID() + "\", \"nombre\": \"" + sensores[i].getNombre() + "\", \"valor\": " + sensores[i].getValor() + " }");
                if (i < numSensores - 1) pw.println(",");
                else pw.println();
            }
            pw.println("  ],");
            pw.println("  \"actuadores\": [");
            for (int i = 0; i < numActuadores; i++) {
                pw.print("    { \"id\": \"" + actuadores[i].getID() + "\", \"nombre\": \"" + actuadores[i].getNombre() + "\", \"estado\": \"" + actuadores[i].getEstadoActual() + "\" }");
                if (i < numActuadores - 1) pw.println(",");
                else pw.println();
            }
            pw.println("  ]");
            pw.println("}");
            System.out.println("Estado guardado en estado.json");
        } catch (Exception e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    public void cargarEstado() {
        File file = new File("estado.json");
        if (!file.exists()) {
            System.out.println("No existe estado.json (primera ejecución)");
            return;
        }

        try (Scanner scanner = new Scanner(file)) {
            System.out.println("Estado cargado correctamente desde estado.json");
                   } catch (Exception e) {
            System.out.println("Error al cargar estado: " + e.getMessage());
        }
    }
    // Metodo para registrar acciones en actuadores.log
    public void registrarAccion(String accion) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("actuadores.log", true))) {
            String linea = new java.util.Date() + " - " + accion;
            pw.println(linea);
            System.out.println("LOG: " + linea);
        } catch (Exception e) {
            System.out.println("Error al escribir en actuadores.log");
        }
    }
}