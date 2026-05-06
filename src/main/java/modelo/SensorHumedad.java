package modelo;

public class SensorHumedad extends Sensor
{

    public SensorHumedad()
    {
        super("hum", "Sensor de Humedad");
    }

    @Override
    public void actualizarValor()
    {
        // Simulación de humedad (0 a 100%)
        this.valor = Math.random() * 100;
    }
}