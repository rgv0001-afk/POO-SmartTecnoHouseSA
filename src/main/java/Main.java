package main;

import modelo.*;

public class Main
{

    public static void main(String[] args) {

        SmartTecnoHouse casa = new SmartTecnoHouse();

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

        // Probar
        casa.actualizarSensores();
        casa.aplicarReglas();
        casa.mostrarEstado();
    }
}