package ar.edu.unahur.obj2.marcas.jarra;

import ar.edu.unahur.obj2.marcas.carpas.Carpa;
import ar.edu.unahur.obj2.marcas.marcas.Marca;

public class Jarra {
    private Double litros;
    private Marca marca;
    private Carpa carpa;
    
    public Jarra(Double capacidadDeLitros, Marca marca, Carpa carpa) {
        this.litros = capacidadDeLitros;
        this.marca = marca;
        this.carpa = carpa;
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

    public Carpa getCarpa() {
        return carpa;
    }
}
