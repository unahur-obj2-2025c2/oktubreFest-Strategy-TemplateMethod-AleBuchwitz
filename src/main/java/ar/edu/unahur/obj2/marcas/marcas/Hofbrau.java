package ar.edu.unahur.obj2.marcas.marcas;

import ar.edu.unahur.obj2.marcas.Reglamentacion;

public class Hofbrau extends Marca {

    public Hofbrau(Double contenidoDeLupudo, String pais) {
        super(contenidoDeLupudo, pais);
    }

    @Override
    public Double graduacionAlcoholica() {
        return Math.min(Reglamentacion.getInstance().getGraduacionCervezaNegra(), this.getContenidoDeLupudo()) * 1.25;
    }

    private Double getContenidoDeLupudo() {
        return contenidoDeLupulo;
    }
}
