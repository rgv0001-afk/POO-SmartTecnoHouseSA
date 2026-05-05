package modelo;

public class SensorLuz extends Sensor {

    public SensorLuz() {
        super("light", "Sensor de Luz");
    }

    @Override
    public void actualizarValor() {
        this.valor = Math.random() * 100; // 0 a 100 (porcentaje de luz)
    }
}