package modelo;

public class SmartTecnoHouse
{

    private Sensor[] sensores;
    private Actuador[] actuadores;
    private Regla[] reglas;

    private int numSensores;
    private int numActuadores;
    private int numReglas;

    public SmartTecnoHouse()
    {
        sensores = new Sensor[10];
        actuadores = new Actuador[10];
        reglas = new Regla[10];
        numSensores = 0;
        numActuadores = 0;
        numReglas = 0;
    }

    public void añadirSensor(Sensor s)
    {
        if (numSensores < 10) {
            sensores[numSensores] = s;
            numSensores = numSensores + 1;
        }
    }

    public void añadirActuador(Actuador a)
    {
        if (numActuadores < 10) {
            actuadores[numActuadores] = a;
            numActuadores = numActuadores + 1;
        }
    }

    public void añadirRegla(Regla r)
    {
        if (numReglas < 10) {
            reglas[numReglas] = r;
            numReglas = numReglas + 1;
        }
    }

    public void actualizarSensores()
    {
        for (int i = 0; i < numSensores; i++) {
            sensores[i].actualizarValor();
        }
    }

    public void aplicarReglas()
    {
        for (int i = 0; i < numReglas; i++) {
            reglas[i].aplicar(sensores, actuadores);
        }
    }

    public void mostrarEstado()
    {
        System.out.println("=== ESTADO DE LA CASA ===");

        System.out.println("Sensores:");
        for (int i = 0; i < numSensores; i++)
        {
            System.out.println("- " + sensores[i].getNombre() + ": " + sensores[i].getEstadoActual());
        }

        System.out.println("Actuadores:");
        for (int i = 0; i < numActuadores; i++)
        {
            System.out.println("- " + actuadores[i].getNombre() + ": " + actuadores[i].getEstadoActual());
        }
    }
}