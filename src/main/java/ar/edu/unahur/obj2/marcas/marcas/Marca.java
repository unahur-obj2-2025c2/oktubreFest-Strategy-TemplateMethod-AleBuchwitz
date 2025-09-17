package ar.edu.unahur.obj2.marcas.marcas;

public abstract class Marca {
    protected Double contenidoDeLupulo;
    protected String paisDeFabricacion;

    public Marca(Double contenidoDeLupulo) {
        this.contenidoDeLupulo = contenidoDeLupulo;
    }

    public abstract Double graduacionAlcoholica();

    public Double getContenidoDeLupulo() {
        return contenidoDeLupulo;
    }

    public String getPaisDeFabricacion() {
        return paisDeFabricacion;
    }
}
