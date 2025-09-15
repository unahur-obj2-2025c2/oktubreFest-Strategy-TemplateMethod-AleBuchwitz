package ar.edu.unahur.obj2.marcas.nacionalidad;

import ar.edu.unahur.obj2.marcas.marcas.Marca;

public class Checo implements Nacionalidad {

    @Override
    public Boolean leGustaLaMarcaDeCeeveza(Marca marca) {
        return marca.graduacionAlcoholica() > 8;
    }

}
