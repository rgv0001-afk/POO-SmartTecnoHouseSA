package modelo;

public class SensorHumedad extends Sensor {

    public SensorHumedad() {
        super("hum", "Sensor de Humedad");
    }

    @Override
    public void actualizarValor() {
        this.valor = Math.random() * 100;   // valor entre 0 y 100
    }
}