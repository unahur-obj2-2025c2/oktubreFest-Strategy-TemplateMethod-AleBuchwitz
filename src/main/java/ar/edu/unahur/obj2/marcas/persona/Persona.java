package ar.edu.unahur.obj2.marcas.persona;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private Boolean estaAdentroDeUnaCarpa = false;

    public Persona(Double peso, Boolean leGustaMusicaTradicional, Integer nivelDeAguante,Nacionalidad nacionalidad) {
        this.peso = peso;
        this.leGustaMusicaTradicional = leGustaMusicaTradicional;
        this.nivelDeAguante = nivelDeAguante;
        this.nacionalidad = nacionalidad;
    }
    
    public List<Jarra> getJarrasCompradas(){
        return jarrasCompradas;
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

    public Boolean getEstaAdentroDeUnaCarpa() {
        return estaAdentroDeUnaCarpa;
    }

    public void consumirJarra(Jarra jarra) {
        jarrasCompradas.add(jarra);
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

    public void entrarAlaCarpa() {
        estaAdentroDeUnaCarpa = true;
    }

    public void salirDeLaCarpa() {
        estaAdentroDeUnaCarpa = false;
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

    public Boolean esEbrioEmpedernido() {
        return jarrasCompradas.stream().allMatch(j -> j.getLitros() >= 1);
    }

    public Boolean esPatriota() {
        return jarrasCompradas.stream().allMatch(j -> j.paisDeFabricacion() == nacionalidad.paisDeNacimiento());
    }

    public Boolean estaEntrandoEnElVicio() {
        Double litrosDeLaPrimerJarra = jarrasCompradas.get(0).getLitros();
        return jarrasCompradas.stream().allMatch(j -> litrosDeLaPrimerJarra >= j.getLitros());
    }

    public List<Carpa> carpasQueLeSirvieronCerveza() {
        List<Carpa> carpasDondeCompreCervezas = new ArrayList<>();
        for(Jarra jarra : jarrasCompradas){
            if(!carpasDondeCompreCervezas.contains(jarra.getCarpa())) {
                carpasDondeCompreCervezas.add(jarra.getCarpa());
            }
        }
        return carpasDondeCompreCervezas;
    }

    public Set<Marca> marcasQueCompro() {
        Set<Marca> marcasCompradas = new HashSet<>();
        for(Jarra jarra : jarrasCompradas) {
            marcasCompradas.add(jarra.getMarca());
        }
        return marcasCompradas;
    }

    public Boolean sonCompatiblescon_(Persona persona) {
        Set<Marca> coincidencias = new HashSet<>(this.marcasQueCompro());
        coincidencias.retainAll(persona.marcasQueCompro());
        Set<Marca> diferencias = new HashSet<>(persona.marcasQueCompro());
        diferencias.removeAll(coincidencias);
        return coincidencias.size() > diferencias.size();
    }
 }
