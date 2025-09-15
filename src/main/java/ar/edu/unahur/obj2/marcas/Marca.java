package ar.edu.unahur.obj2.marcas;

public abstract class Marca {
    protected Double contenidoDeLupulo;
    protected String paisDeFabricacion;

    public Marca(Double contenidoDeLupulo, String paisDeFabricacion) {
        this.contenidoDeLupulo = contenidoDeLupulo;
        this.paisDeFabricacion = paisDeFabricacion;
    }

    public abstract Double graduacionAlcoholica();

    public Double getContenidoDeLupulo() {
        return contenidoDeLupulo;
    }

    public String getPaisDeFabricacion() {
        return paisDeFabricacion;
    }
}
