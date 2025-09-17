package ar.edu.unahur.obj2.marcas.marcas;

public class Corona extends Marca {

    public Corona(Double contenidoDeLupudo) {
        super(contenidoDeLupudo);
        paisDeFabricacion = "Alemania";
    }

    @Override
    public Double graduacionAlcoholica() {
        return 10.0;
    }

}
