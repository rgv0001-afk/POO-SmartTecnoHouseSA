package vista;

import controlador.Controlador;

public class Vista {

    private Controlador controlador;

    public Vista() {
        controlador = new Controlador();
    }

    public void mostrar() {
        controlador.actualizarTodo();
        controlador.getCasa().mostrarEstado();
    }
}