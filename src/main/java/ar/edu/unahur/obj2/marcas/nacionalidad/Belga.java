package ar.edu.unahur.obj2.marcas.nacionalidad;

import ar.edu.unahur.obj2.marcas.marcas.Marca;

public class Belga implements Nacionalidad {

    @Override
    public Boolean leGustaLaMarcaDeCeeveza(Marca marca) {
        return marca.getContenidoDeLupulo() > 4;
    }

}
