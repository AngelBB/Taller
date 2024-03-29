package modelo;
// Generated 01-feb-2015 15:32:57 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Mecanico generated by hbm2java
 */
public class Mecanico  implements java.io.Serializable {


     private String dni;
     private String nombre;
     private String apellido1;
     private String apellido2;
     private String direccion;
     private int telefono;
     private float salario;
     private String contratacion;
     private Set reparas = new HashSet(0);

    public Mecanico() {
    }

	
    public Mecanico(String dni, String nombre, String apellido1, String apellido2, String direccion, int telefono, float salario, String contratacion) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.direccion = direccion;
        this.telefono = telefono;
        this.salario = salario;
        this.contratacion = contratacion;
    }
    public Mecanico(String dni, String nombre, String apellido1, String apellido2, String direccion, int telefono, float salario, String contratacion, Set reparas) {
       this.dni = dni;
       this.nombre = nombre;
       this.apellido1 = apellido1;
       this.apellido2 = apellido2;
       this.direccion = direccion;
       this.telefono = telefono;
       this.salario = salario;
       this.contratacion = contratacion;
       this.reparas = reparas;
    }
   
    public String getDni() {
        return this.dni;
    }
    
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido1() {
        return this.apellido1;
    }
    
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }
    public String getApellido2() {
        return this.apellido2;
    }
    
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public int getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    public float getSalario() {
        return this.salario;
    }
    
    public void setSalario(float salario) {
        this.salario = salario;
    }
    public String getContratacion() {
        return this.contratacion;
    }
    
    public void setContratacion(String contratacion) {
        this.contratacion = contratacion;
    }
    public Set getReparas() {
        return this.reparas;
    }
    
    public void setReparas(Set reparas) {
        this.reparas = reparas;
    }




}


