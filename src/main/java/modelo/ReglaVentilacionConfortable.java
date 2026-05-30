package modelo;

public class ReglaVentilacionConfortable implements Regla {

    public ReglaVentilacionConfortable() {
        // Constructor vacío
    }

    @Override
    public void aplicar() {
        System.out.println("Aplicando regla: Ventilación Confortable");
        // logica
    }
}