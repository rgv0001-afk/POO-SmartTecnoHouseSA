import modelo.*;

public class Main
{

    public static void main(String[] args)
    {

        SmartTecnoHouse casa = new SmartTecnoHouse();

        //Crear sensores
        SensorTemperatura temp = new SensorTemperatura();
        SensorLuz luz = new SensorLuz();
        SensorPresencia pir = new SensorPresencia();
        SensorHumedad humedad = new SensorHumedad();

        // Crear  actuadores
        ActuadorBombilla bombilla = new ActuadorBombilla();
        ActuadorVentilador ventilador = new ActuadorVentilador();
        ActuadorPersiana persiana = new ActuadorPersiana();

        // Añadir a la casa
        casa.añadirSensor(temp);
        casa.añadirSensor(luz);
        casa.añadirSensor(pir);
        casa.añadirSensor(humedad);

        casa.añadirActuador(bombilla);
        casa.añadirActuador(ventilador);
        casa.añadirActuador(persiana);

        // Prueba
        casa.actualizarSensores();
        casa.mostrarEstado();
    }
}