package ar.edu.unahur.obj2.marcas.jarra;

import ar.edu.unahur.obj2.marcas.marcas.Marca;

public class Jarra {
    private Double litros;
    private Marca marca;
    
    public Jarra(Double capacidadDeLitros, Marca marca) {
        this.litros = capacidadDeLitros;
        this.marca = marca;
    }

    public Double getLitros() {
        return litros;
    }

    public Marca getMarca() {
        return marca;
    }
    
    public Double contenidoDeAlcohol(){
        return litros * (marca.graduacionAlcoholica() / 100);
    }

    public String paisDeFabricacion() {
        return marca.getPaisDeFabricacion();
    }
}
