package ar.edu.unahur.obj2.marcas.jarra;

import ar.edu.unahur.obj2.marcas.Marca;

public class Jarra {
    private Double capacidadDeLitros;
    private Marca marca;
    
    public Jarra(Double capacidadDeLitros, Marca marca) {
        this.capacidadDeLitros = capacidadDeLitros;
        this.marca = marca;
    }

    public Double getCapacidadDeLitros() {
        return capacidadDeLitros;
    }

    public Marca getMarca() {
        return marca;
    }
    
}
