package modelo;

public class ActuadorBombilla extends Actuador
{
    public ActuadorBombilla()
        {
        super("bulb", "Bombilla");
        }

    @Override
    public void ejecutarAccion(String accion)
    {
        if (accion.equals("ON") || accion.equals("OFF")) 
        {
            this.estado = accion;
        }
    }

    @Override
    public String[] getAccionesPosibles()
        {
        return new String[]{"ON", "OFF"};
        }
}