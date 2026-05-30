package controlador;

import modelo.*;

public class Controlador {

    private SmartTecnoHouse casa;

    public Controlador() {
        casa = new SmartTecnoHouse();

        // Crear sensores
        SensorTemperatura temp = new SensorTemperatura();
        SensorLuz luz = new SensorLuz();
        SensorPresencia pir = new SensorPresencia();
        SensorHumedad humedad = new SensorHumedad();

        // Crear actuadores
        ActuadorBombilla bombilla = new ActuadorBombilla();
        ActuadorVentilador ventilador = new ActuadorVentilador();
        ActuadorPersiana persiana = new ActuadorPersiana();

        // Añadirlos a la casa
        casa.añadirSensor(temp);
        casa.añadirSensor(luz);
        casa.añadirSensor(pir);
        casa.añadirSensor(humedad);

        casa.añadirActuador(bombilla);
        casa.añadirActuador(ventilador);
        casa.añadirActuador(persiana);
    }

    public SmartTecnoHouse getCasa() {
        return casa;
    }

    public void actualizarTodo() {
        casa.actualizarSensores();
        casa.aplicarReglas();
    }
}