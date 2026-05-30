package modelo;

public interface Regla {
    void aplicar(Sensor[] sensores, Actuador[] actuadores);
}