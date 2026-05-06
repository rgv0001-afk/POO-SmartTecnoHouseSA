package modelo;

public class ActuadorVentilador extends Actuador
{

    public ActuadorVentilador()
    {
        super("fan", "Ventilador");
    }

    @Override
    public void ejecutarAccion(String accion)
    {
        if (accion.equals("ON") || accion.equals("OFF") || accion.equals("HIGH"))
        {
            this.estado = accion;
        }
    }

    @Override
    public String[] getAccionesPosibles()
    {
        return new String[]{"ON", "OFF", "HIGH"};
    }
}