package ar.edu.unahur.obj2.marcas.marcas;

import ar.edu.unahur.obj2.marcas.Marca;

public class Corona extends Marca {

    public Corona(Double contenidoDeLupudo, String pais) {
        super(contenidoDeLupudo, pais);
    }

    @Override
    public Double graduacionAlcoholica() {
        return 0.1;
    }

}
