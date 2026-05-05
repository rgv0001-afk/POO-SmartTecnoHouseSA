package modelo;

public class SensorPresencia extends Sensor {

    public SensorPresencia() {
        super("pir", "Sensor de Presencia");
    }

    @Override
    public void actualizarValor() {
        // 0 = no hay nadie 1 = hay alguien
        this.valor = Math.random() > 0.5 ? 1.0 : 0.0;
    }
}