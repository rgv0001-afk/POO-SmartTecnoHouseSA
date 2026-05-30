package modelo;

public class ReglaIluminacionAutomatica implements Regla {

    public ReglaIluminacionAutomatica() {
        // Constructor
    }

    @Override
    public void aplicar() {
        System.out.println("Aplicando regla: Iluminación Automática");
        // logica
    }
}