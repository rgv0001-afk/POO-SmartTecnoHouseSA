package modelo;

public class SensorTemperatura extends Sensor {

    public SensorTemperatura() {
        super("temp", "Sensor de Temperatura");
    }

    @Override
    public void actualizarValor() {
        // Simulación simple (lo visto en clase)
        this.valor = 20.0 + Math.random() * 15; // entre 20 y 35
    }
}