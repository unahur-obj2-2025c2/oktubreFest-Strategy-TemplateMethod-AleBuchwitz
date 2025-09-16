package ar.edu.unahur.obj2.marcas.persona;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.marcas.carpas.Carpa;
import ar.edu.unahur.obj2.marcas.jarra.Jarra;
import ar.edu.unahur.obj2.marcas.marcas.Marca;
import ar.edu.unahur.obj2.marcas.nacionalidad.Aleman;
import ar.edu.unahur.obj2.marcas.nacionalidad.Nacionalidad;

public class Persona {
    private Double peso;
    private List<Jarra> jarrasCompradas = new ArrayList<>();
    private Boolean leGustaMusicaTradicional;
    private Integer nivelDeAguante;
    private final Nacionalidad nacionalidad;

    public Persona(Double peso, Boolean leGustaMusicaTradicional, Integer nivelDeAguante,Nacionalidad nacionalidad) {
        this.peso = peso;
        this.leGustaMusicaTradicional = leGustaMusicaTradicional;
        this.nivelDeAguante = nivelDeAguante;
        this.nacionalidad = nacionalidad;
    }
    
    public Double getPeso() {
        return peso;
    }

    public Boolean getLeGustaMusicaTradicional() {
        return leGustaMusicaTradicional;
    }

    public Integer getNivelDeAguante() {
        return nivelDeAguante;
    }

    public Nacionalidad getNacionalidad() {
        return nacionalidad;
    }

    public Boolean estaEbrio() {
        return jarrasCompradas.stream().mapToDouble(j -> j.getLitros()).sum() * peso > this.getNivelDeAguante();
    }

    public Double totalAlcoholConsumido() {
        return jarrasCompradas.stream().mapToDouble(j -> j.getLitros()).sum();
    }

    public Boolean leGustaLaMarca(Marca marca) {
        return nacionalidad.leGustaLaMarcaDeCeeveza(marca);
    }

    public Boolean esAleman(){
        Nacionalidad aleman = new Aleman();
        return nacionalidad.getClass() == aleman.getClass();
    }

    public Boolean quiereEntrarALaCarpa(Carpa carpa){
        if(this.leGustaLaMarca(carpa.marcaDeCervezaQueVende()) && this.getLeGustaMusicaTradicional() && carpa.tieneMusicaTradicional()) {
            return true;
        }
        else if(this.leGustaLaMarca(carpa.marcaDeCervezaQueVende()) && !this.getLeGustaMusicaTradicional() && !carpa.tieneMusicaTradicional()){
            return true;
        }
        else if(this.leGustaLaMarca(carpa.marcaDeCervezaQueVende()) && this.getLeGustaMusicaTradicional() && carpa.tieneMusicaTradicional() && this.esAleman() && carpa.genteAdmitida() % 2 == 0){
            return true;
        }
        else if(this.leGustaLaMarca(carpa.marcaDeCervezaQueVende()) && !this.getLeGustaMusicaTradicional() && !carpa.tieneMusicaTradicional() && this.esAleman() && carpa.genteAdmitida() % 2 == 0){
            return true;
        }
        else{
            return false;
        }
    }
 }
