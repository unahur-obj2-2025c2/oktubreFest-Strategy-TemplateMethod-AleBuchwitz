package ar.edu.unahur.obj2.marcas;

public class Reglamentacion {
    private static final Reglamentacion INSTANCE = new Reglamentacion();
    private Double graduacionCervezaNegra;

    public static Reglamentacion getInstance(){
        return INSTANCE;
    }

    public Double getGraduacionCervezaNegra(){
        return graduacionCervezaNegra;
    }

    public void setGraduacionCervezaNegra(Double graduacion){
        graduacionCervezaNegra = graduacion;
    }
}
