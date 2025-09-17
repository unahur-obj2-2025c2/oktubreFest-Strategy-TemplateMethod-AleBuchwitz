package ar.edu.unahur.obj2.marcas.carpas;

import ar.edu.unahur.obj2.marcas.marcas.Marca;
import ar.edu.unahur.obj2.marcas.persona.Persona;

public interface Carpa {
    public Boolean tieneMusicaTradicional();
    public Marca marcaDeCervezaQueVende();
    public Integer genteAdmitida();
    public Boolean dejarIngresarPersona(Persona persona);
    public Boolean puedeEntrar(Persona persona);
    public void entrar(Persona persona);
    public Boolean esHomogenea();
}
