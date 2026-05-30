package modelo;

public class ReglaIluminacionAutomatica implements Regla
{

    public ReglaIluminacionAutomatica()
    {
    }

    @Override
    public void aplicar(Sensor[] sensores, Actuador[] actuadores)
    {
        System.out.println("Aplicando regla: Iluminación Automática");

        // Buscamos el sensor de luz
        for (int i = 0; i < sensores.length; i++)
        {
            if (sensores[i] != null && sensores[i].getID().equals("light"))
            {
                if (sensores[i].getValor() < 30.0)
                {
                    // Buscamos la bombilla y la encendemos
                    for (int j = 0; j < actuadores.length; j++) {
                        if (actuadores[j] != null && actuadores[j].getID().equals("bulb"))
                        {
                            actuadores[j].ejecutarAccion("ON");
                            System.out.println("→ Bombilla encendida (está oscuro)");
                        }
                    }
                }
            }
        }
    }
}