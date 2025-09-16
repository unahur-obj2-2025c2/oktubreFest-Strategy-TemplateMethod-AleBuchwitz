package ar.edu.unahur.obj2.marcas.carpas;

import ar.edu.unahur.obj2.marcas.marcas.Marca;
import ar.edu.unahur.obj2.marcas.persona.Persona;

public class CarpaCervecera implements Carpa {
    private Integer genteAdmitida;
    private Marca marcaDeCervezaQueVende;
    private Boolean musicaTradicional;
    private Integer cantidadDePersonasAdentro = 0;
    
    public CarpaCervecera(Integer genteAdmitida,Boolean musicaTradicional, Marca marcaDeCervezaQueVende) {
        this.genteAdmitida = genteAdmitida;
        this.marcaDeCervezaQueVende = marcaDeCervezaQueVende;
        this.musicaTradicional = musicaTradicional;
    }

    @Override
    public Integer genteAdmitida() {
        return genteAdmitida;
    }

    @Override
    public Marca marcaDeCervezaQueVende() {
        return marcaDeCervezaQueVende;
    }

    @Override
    public Boolean tieneMusicaTradicional() {
        return musicaTradicional;
    }
    
    @Override
    public Boolean dejarIngresarPersona(Persona persona) {
        if(cantidadDePersonasAdentro < genteAdmitida && !persona.estaEbrio()) {
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public Boolean puedeEntrar(Persona persona){
        if(this.dejarIngresarPersona(persona) && persona.quiereEntrarALaCarpa(this)) {
            cantidadDePersonasAdentro += 1;
            return true;
        }
        else {
            return false;
        }
    }
}
