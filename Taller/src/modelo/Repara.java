package modelo;
// Generated 01-feb-2015 15:32:57 by Hibernate Tools 4.3.1



/**
 * Repara generated by hbm2java
 */
public class Repara  implements java.io.Serializable {


     private ReparaId id;
     private Automovil automovil;
     private Mecanico mecanico;

    public Repara() {
    }

    public Repara(ReparaId id, Automovil automovil, Mecanico mecanico) {
       this.id = id;
       this.automovil = automovil;
       this.mecanico = mecanico;
    }
   
    public ReparaId getId() {
        return this.id;
    }
    
    public void setId(ReparaId id) {
        this.id = id;
    }
    public Automovil getAutomovil() {
        return this.automovil;
    }
    
    public void setAutomovil(Automovil automovil) {
        this.automovil = automovil;
    }
    public Mecanico getMecanico() {
        return this.mecanico;
    }
    
    public void setMecanico(Mecanico mecanico) {
        this.mecanico = mecanico;
    }




}


