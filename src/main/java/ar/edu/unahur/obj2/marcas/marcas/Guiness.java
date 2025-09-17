package ar.edu.unahur.obj2.marcas.marcas;

import ar.edu.unahur.obj2.marcas.Reglamentacion;

public class Guiness extends Marca {

    public Guiness(Double contenidoDeLupudo) {
        super(contenidoDeLupudo);
        paisDeFabricacion = "Belgica";
    }
    
    @Override
    public Double graduacionAlcoholica() {
        return Math.min(Reglamentacion.getInstance().getGraduacionCervezaNegra(), getContenidoDeLupulo() * 2); 
    }
}
