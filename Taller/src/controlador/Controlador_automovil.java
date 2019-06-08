/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import modelo.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
/**
 *
 * @author Angel
 */
public class Controlador_automovil {
    
    String modelo;
    String matricula;
    String color;
    String marca;
    int cod_concesionario;
    String dni_propietario;
    static String log;
    //Clases del modelo
    Automovil auto;
    
    
    //Para crear la sesion e iniciar la sesion en la BD
    SessionFactory sesion;
    Session session;
    Transaction tx;
       

    public Controlador_automovil(String matricula,String modelo, String color, String marca, int cod_concesionario, String dni_propietario) {
        this.modelo = modelo;
        this.matricula = matricula;
        this.color = color;
        this.marca = marca;
        this.cod_concesionario = cod_concesionario;
        this.dni_propietario = dni_propietario;
        
        try{
            //Por seguridad les paso valores cade vez que haga una accion
            this.sesion=HibernateUtil.createSessionFactory();
            this.session=sesion.openSession();
            this.tx=session.beginTransaction();
            
            //Tenemos que buscar el cliente y el concesionario al
            //que se refiere
            
            Cliente cl;
            cl=(Cliente)session.load(Cliente.class,(String)dni_propietario);
                        
            Concesionario co;
            co=(Concesionario)session.load(Concesionario.class,(int)cod_concesionario);
                        
            //Para insertar en la clases del modelo
            this.auto=new Automovil(matricula,cl,co,modelo,marca,color);
            
            session.save(this.auto);//Salvamos los datos
            this.tx.commit();//Hacemos un commit
            this.session.close();//cerramos la sesion
            this.log="Automovil "+this.matricula+" se ha insertado.";
        }catch(Exception e){
            this.log=e.getMessage();
        }
    }
    
    public Controlador_automovil(){}//Constructor por defecto
    

    //Contructor especifico para las actualizaciones
    public Controlador_automovil(String matricula){
       this.matricula=matricula;
    }

    public void actualizar_Automovil(String matriculaantigua,String matricula,String modelo, String color, String marca, int cod_concesionario, String dni_propietario){
     try{
            //Por seguridad les paso valores cade vez que haga una accion
            this.sesion=HibernateUtil.createSessionFactory();
            this.session=sesion.openSession();
            this.tx=session.beginTransaction();
            /*Automovil veh;   
            veh=(Automovil)session.load(Automovil.class,matriculaantigua);        
           
            Cliente cl;
            cl=(Cliente)session.load(Cliente.class,(String)dni_propietario);
                        
            Concesionario co;
            co=(Concesionario)session.load(Concesionario.class,(int)cod_concesionario);
                  
            veh.setCliente(cl);
            veh.setMatricula(matricula);
            veh.setConcesionario(co);
            veh.setColor(color);
            veh.setMarca(marca);
            veh.setModelo(modelo);
                        
            session.update(veh);//actualizamos los datos*/
            
            this.session.createSQLQuery("update Automovil set matricula='"+matricula+"',dni_propietario='"+dni_propietario+"',cod_concesionario="+cod_concesionario+","
                    + "modelo='"+modelo+"',marca='"+marca+"',color='"+color+"' where matricula='"+matriculaantigua+"'").executeUpdate();
            
            
            this.tx.commit();//Hacemos un commit
            this.session.close();//cerramos la sesion
            this.log="Automovil "+matriculaantigua+" se ha actualizado.";
        }catch(Exception e){
            this.log=e.getMessage();
        }
    }
    
    //Get & Set
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCod_concesionario() {
        return cod_concesionario;
    }

    public void setCod_concesionario(int cod_concesionario) {
        this.cod_concesionario = cod_concesionario;
    }

    public String getDni_propietario() {
        return dni_propietario;
    }

    public void setDni_propietario(String dni_propietario) {
        this.dni_propietario = dni_propietario;
    }
    
    public String getLog(){
        return this.log+"\n";
    }
    
    public void setLog(String cadena){
        this.log=cadena;
    }
    
    //Para rellenar los campos de actualizacion**************************************************** 
    public void recogerDatosVehiculo(String dni_prop, String matricula){
        //Por seguridad les paso valores cade vez que haga una accion
        this.sesion=HibernateUtil.createSessionFactory();
        this.session=sesion.openSession();
       // this.tx=session.beginTransaction();
        
        /*
        *Lo que debemos hacer es llamar a la clase automovil y automovilid
        *y sacar el vehiculo por su matricula despues desde este mismo metodo
        *rellenamos los valores de esta clase.
        *
        */
        
        Automovil au;
        Query q=session.createQuery("from Automovil where matricula= '"+matricula+"' and dni_propietario= '"+dni_prop+"'");
        
        List<Automovil> lista=q.list();
        Iterator <Automovil> iter =lista.iterator();
        while(iter.hasNext()){
            au = iter.next();
            this.marca=au.getMarca();
            this.color=au.getColor();
            this.modelo=au.getModelo();
            this.matricula=au.getMatricula();
            this.dni_propietario=au.getCliente().getDni();
            this.cod_concesionario=au.getConcesionario().getCodigo();
        }
        
        this.session.close();//cerramos la sesion
    }
    
    //Para rellenar los select*************************************************
    public ArrayList<String> cargarAutos(String dni){
       
        //Por seguridad les paso valores cade vez que haga una accion
        this.sesion=HibernateUtil.createSessionFactory();
        this.session=sesion.openSession();
        //this.tx=session.beginTransaction();

        Automovil au;
        ArrayList<String> listaMatriculas=new ArrayList<>();
        Query q;
        if(dni==null){
            q=session.createQuery("from Automovil");
        }else{
            q=session.createQuery("from Automovil where dni_propietario= '"+dni+"'");
        }
        List<Automovil> lista=q.list();

        //Obtenemos un iterador y recorremos la lista.
        Iterator <Automovil> iter =lista.iterator();
        while(iter.hasNext()){
           au = iter.next();
           listaMatriculas.add(au.getMatricula());
        }
        this.session.close();//cerramos la sesion
           
        return listaMatriculas;
    }
       
    public ArrayList<ArrayList<String>> consultaVehiculos(String matricula){
    
        //Por seguridad les paso valores cade vez que haga una accion
        this.sesion=HibernateUtil.createSessionFactory();
        this.session=sesion.openSession();
       // this.tx=session.beginTransaction();

        Automovil au;
        ArrayList<ArrayList<String>> listaAutos=new ArrayList<>();
        Query q=session.createQuery("from Automovil where matricula= '"+matricula+"'");
        List<Automovil> lista=q.list();
        int i=0;
        
        //Obtenemos un iterador y recorremos la lista.
        Iterator <Automovil> iter =lista.iterator();
        while(iter.hasNext()){
           au = iter.next();
           listaAutos.add(new ArrayList(i));
           listaAutos.get(i).add(au.getMatricula());
           listaAutos.get(i).add(au.getCliente().getDni());
           listaAutos.get(i).add(Integer.toString(au.getConcesionario().getCodigo()));
           listaAutos.get(i).add(au.getMarca());
           listaAutos.get(i).add(au.getModelo());
           listaAutos.get(i).add(au.getColor());        
           i++;
        }
        this.session.close();//cerramos la sesion
           
        return listaAutos;
       
    }
    
    public void borrarAuto(String matriucla){
        //Por seguridad les paso valores cade vez que haga una accion
        this.sesion=HibernateUtil.createSessionFactory();
        this.session=sesion.openSession();
        this.tx=session.beginTransaction();
        try{
           session.createSQLQuery("delete from Automovil where matricula='"+matriucla+"'").executeUpdate();            
           this.log="Vehiculo borrado" ;
        }catch(Exception e){
            this.log=e.getMessage();
        }
        this.tx.commit();
        this.session.close();//cerramos la sesion
    }
    
    public ArrayList<String>  cargarAllVehicles(){
        //Por seguridad les paso valores cade vez que haga una accion
        this.sesion=HibernateUtil.createSessionFactory();
        this.session=sesion.openSession();
        //this.tx=session.beginTransaction();

        Automovil au;
        ArrayList<String> listaMatriculas=new ArrayList<>();
        Query q;
       
            q=session.createQuery("from Automovil");
        
        List<Automovil> lista=q.list();

        //Obtenemos un iterador y recorremos la lista.
        Iterator <Automovil> iter =lista.iterator();
        while(iter.hasNext()){
           au = iter.next();
           listaMatriculas.add(au.getMatricula());
        }
        this.session.close();//cerramos la sesion
           
        return listaMatriculas;
    
    
    }
    
}