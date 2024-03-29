package modelo;
// Generated 01-feb-2015 15:32:57 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Concesionario generated by hbm2java
 */
public class Concesionario  implements java.io.Serializable {


     private int codigo;
     private String nombre;
     private String direccion;
     private Set automovils = new HashSet(0);

    public Concesionario() {
    }

	
    public Concesionario(int codigo, String nombre, String direccion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
    }
    public Concesionario(int codigo, String nombre, String direccion, Set automovils) {
       this.codigo = codigo;
       this.nombre = nombre;
       this.direccion = direccion;
       this.automovils = automovils;
    }
   
    public int getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public Set getAutomovils() {
        return this.automovils;
    }
    
    public void setAutomovils(Set automovils) {
        this.automovils = automovils;
    }




}


