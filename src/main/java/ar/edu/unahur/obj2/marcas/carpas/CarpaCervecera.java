package ar.edu.unahur.obj2.marcas.carpas;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.marcas.jarra.Jarra;
import ar.edu.unahur.obj2.marcas.marcas.Marca;
import ar.edu.unahur.obj2.marcas.nacionalidad.Nacionalidad;
import ar.edu.unahur.obj2.marcas.persona.Persona;

public class CarpaCervecera implements Carpa {
    private Integer genteAdmitida;
    private Marca marcaDeCervezaQueVende;
    private Boolean musicaTradicional;
    private Integer cantidadDePersonasAdentro = 0;
    private List<Persona> personasAdentro = new ArrayList<>();
    
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
            this.entrar(persona);
            return true;
        }
        else {
            throw new RuntimeException("No cumple las condiciones para ingresar.");
        }
    }

    @Override
    public void entrar(Persona persona){
        cantidadDePersonasAdentro += 1;
        personasAdentro.add(persona);
    }

    public void servirUnaJarraAPersona(Persona persona,Double litros) {
        Jarra jarra = new Jarra(litros, marcaDeCervezaQueVende);
        if(this.puedeEntrar(persona)) {
            persona.consumirJarra(jarra);
        }
        else {
            throw new RuntimeException("No se encuentra en la carpa");
        }
    }

    public Integer cantidadDeEbriosEmpedernidos() {
        return Integer.valueOf((int) personasAdentro.stream().filter(p -> p.esEbrioEmpedernido()).count());
    }

    public Boolean esHomogenea() {
        Nacionalidad nacionalidadDeLaPrimerPersona = personasAdentro.get(0).getNacionalidad();
        return personasAdentro.stream().allMatch(p -> p.getNacionalidad().equals(nacionalidadDeLaPrimerPersona));
    }
}
