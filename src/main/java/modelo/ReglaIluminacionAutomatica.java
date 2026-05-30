package modelo;

public class ReglaIluminacionAutomatica implements Regla {

    public ReglaIluminacionAutomatica() {
    }

    @Override
    public void aplicar(Sensor[] sensores, Actuador[] actuadores) {
        System.out.println("Aplicando regla: Iluminación Automática");
    }
}