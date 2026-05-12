package modelo;

public class ActuadorPersiana extends Actuador {

    public ActuadorPersiana() {
        super("persiana", "Persiana Motorizada");
    }

    @Override
    public void ejecutarAccion(String accion) {
        if (accion.equals("UP")) {
            this.estado = "UP";
        } else if (accion.equals("DOWN")) {
            this.estado = "DOWN";
        } else if (accion.equals("STOP")) {
            this.estado = "STOP";
        }
    }

    @Override
    public String[] getAccionesPosibles() {
        String[] acciones = new String[3];
        acciones[0] = "UP";
        acciones[1] = "DOWN";
        acciones[2] = "STOP";
        return acciones;
    }
}