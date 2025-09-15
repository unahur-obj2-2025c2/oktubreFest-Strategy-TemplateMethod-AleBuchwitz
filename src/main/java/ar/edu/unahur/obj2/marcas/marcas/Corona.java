package ar.edu.unahur.obj2.marcas.marcas;

public class Corona extends Marca {

    public Corona(Double contenidoDeLupudo, String pais) {
        super(contenidoDeLupudo, pais);
    }

    @Override
    public Double graduacionAlcoholica() {
        return 10.0;
    }

}
