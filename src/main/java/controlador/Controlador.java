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

        // Añadir dispositivos
        casa.añadirSensor(temp);
        casa.añadirSensor(luz);
        casa.añadirSensor(pir);
        casa.añadirSensor(humedad);

        casa.añadirActuador(bombilla);
        casa.añadirActuador(ventilador);
        casa.añadirActuador(persiana);

        // Añadir reglas
        ReglaVentilacionConfortable regla1 = new ReglaVentilacionConfortable();
        ReglaIluminacionAutomatica regla2 = new ReglaIluminacionAutomatica();

        casa.añadirRegla(regla1);
        casa.añadirRegla(regla2);

        System.out.println("Sistema iniciado correctamente con " + casa.getNumReglas() + " reglas");
    }

    public SmartTecnoHouse getCasa() {
        return casa;
    }

    public void actualizarTodo() {
        casa.actualizarSensores();
        casa.aplicarReglas();
    }
}