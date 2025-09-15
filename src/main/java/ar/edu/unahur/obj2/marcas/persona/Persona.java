package ar.edu.unahur.obj2.marcas.persona;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.marcas.jarra.Jarra;
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
        return jarrasCompradas.stream().mapToDouble(j -> j.getCapacidadDeLitros()).sum() * peso > this.getNivelDeAguante();
    }
 }
