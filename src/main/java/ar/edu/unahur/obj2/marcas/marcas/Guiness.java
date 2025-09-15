package ar.edu.unahur.obj2.marcas.marcas;

import ar.edu.unahur.obj2.marcas.Marca;
import ar.edu.unahur.obj2.marcas.Reglamentacion;

public class Guiness extends Marca {

    public Guiness(Double contenidoDeLupudo, String pais) {
        super(contenidoDeLupudo, pais);
    }
    
    @Override
    public Double graduacionAlcoholica() {
        return Math.min(Reglamentacion.getInstance().getGraduacionCervezaNegra(), getContenidoDeLupulo() * 2); 
    }
}
