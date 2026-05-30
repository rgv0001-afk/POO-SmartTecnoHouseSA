package modelo;

public class ReglaVentilacionConfortable implements Regla {

    public ReglaVentilacionConfortable() {
    }

    @Override
    public void aplicar(Sensor[] sensores, Actuador[] actuadores) {
        System.out.println("Aplicando regla: Ventilación Confortable");
    }
}