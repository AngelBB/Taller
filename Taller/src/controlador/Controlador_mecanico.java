/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import modelo.Mecanico;
import modelo.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Angel
 */
public class Controlador_mecanico {
    
    String dni;
    String nombre;
    String apellido1;
    String apellido2;
    String direccion;
    int tlf;
    float salario;
    String contratacion;
    String log;
    //Para crear la sesion e iniciar la sesion en la BD
    SessionFactory sesion;
    Session session;
    Transaction tx;

    public Controlador_mecanico(String dni, String nombre, String apellido1, String apellido2, String direccion, int tlf, float salario,String contratacion) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.direccion = direccion;
        this.tlf = tlf;
        this.contratacion=contratacion;
        this.salario=salario;
        try{
            //Por seguridad les paso valores cade vez que haga una accion
            this.sesion=HibernateUtil.createSessionFactory();
            this.session=sesion.openSession();
            this.tx=session.beginTransaction();          
                Mecanico me=new Mecanico(dni,nombre,apellido1,apellido2,direccion,tlf,salario,contratacion);
                session.save(me);
            this.tx.commit();//Hacemos un commit
            this.session.close();//cerramos la sesion
            this.log="Mecanico "+this.dni+" se ha insertado.";
        }catch(Exception e){
            this.log=e.getMessage();
        }
    }
    
    public Controlador_mecanico(){}
    
    public String getLog() {
        return log+"\n";
    }

    public void setLog(String log) {
        this.log = log;
    }
    
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTlf() {
        return tlf;
    }

    public void setTlf(int tlf) {
        this.tlf = tlf;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getContratacion() {
        return contratacion;
    }

    public void setContratacion(String contratacion) {
        this.contratacion = contratacion;
    }
    
    
    public void actualizar_Mecanico(String Dniantiguo,String dni, String nombre, String apellido1, String apellido2, String direccion, int tlf, float salario, String contratacion) {
     try{
            //Por seguridad les paso valores cade vez que haga una accion
            this.sesion=HibernateUtil.createSessionFactory();
            this.session=sesion.openSession();
            this.tx=session.beginTransaction();
                        
           /* Mecanico cl;
            cl=(Mecanico)session.load(Mecanico.class,Dniantiguo);
            cl.setDni(dni);
            cl.setNombre(nombre);
            cl.setApellido1(apellido1);
            cl.setApellido2(apellido2);
            cl.setDireccion(direccion);
            cl.setTelefono(tlf);
            cl.setSalario(salario);
            cl.setContratacion(contratacion);
            session.update(cl);//Salvamos los datos*/
            session.createSQLQuery("update Mecanico set dni='"+dni+"',nombre='"+nombre+"',apellido1='"+apellido1+"'"+
                    ",apellido2='"+apellido2+"',direccion='"+direccion+"',telefono="+tlf+",salario="+salario+",contratacion='"+contratacion+"'"+
                    "where dni='"+Dniantiguo+"'").executeUpdate();
            this.tx.commit();//Hacemos un commit
            this.session.close();//cerramos la sesion
            this.log="Mecanico "+Dniantiguo+" se ha actualizado.";
        }catch(Exception e){
            this.log=e.getMessage();
        }
    }
    
    //Para rellenar los campos de actualizacion**************************************************** 
    public void recogerDatosMecanico(String dni_prop){
        //Por seguridad les paso valores cade vez que haga una accion
        this.sesion=HibernateUtil.createSessionFactory();
        this.session=sesion.openSession();
        this.tx=session.beginTransaction();
        
        /*
        *Lo que debemos hacer es llamar a la clase automovil y automovilid
        *y sacar el vehiculo por su matricula despues desde este mismo metodo
        *rellenamos los valores de esta clase.
        *
        */
        
        Mecanico cl;
        Query q=session.createQuery("from Mecanico where dni= '"+dni_prop+"'");
        List<Mecanico> lista=q.list();
        Iterator <Mecanico> iter =lista.iterator();
        while(iter.hasNext()){
            cl = iter.next();
            this.dni=cl.getDni();
            this.nombre=cl.getNombre();
            this.apellido1=cl.getApellido1();
            this.apellido2=cl.getApellido2();
            this.direccion=cl.getDireccion();
            this.tlf=cl.getTelefono();
            this.salario=cl.getSalario();
            this.contratacion=cl.getContratacion();
        }
        
        this.session.close();//cerramos la sesion
    }  
    
    public ArrayList<String> cargarMecanicos(){
       
        //Por seguridad les paso valores cade vez que haga una accion
        this.sesion=HibernateUtil.createSessionFactory();
        this.session=sesion.openSession();
        this.tx=session.beginTransaction();

        Mecanico au;
        ArrayList<String> listaDnis=new ArrayList<>();
        Query q=session.createQuery("from Mecanico");
        List<Mecanico> lista=q.list();

        //Obtenemos un iterador y recorremos la lista.
        Iterator <Mecanico> iter =lista.iterator();
        while(iter.hasNext()){
           au = iter.next();
           listaDnis.add(au.getDni());
        }
        this.session.close();//cerramos la sesion
           
        return listaDnis;
    }
     
    public ArrayList<ArrayList<String>> consultaMecanico(String dni){
    
        //Por seguridad les paso valores cade vez que haga una accion
        this.sesion=HibernateUtil.createSessionFactory();
        this.session=sesion.openSession();
        this.tx=session.beginTransaction();

        Mecanico au;
        ArrayList<ArrayList<String>> listaMecanicos=new ArrayList<>();
        Query q=session.createQuery("from Mecanico where dni= '"+dni+"'");
        List<Mecanico> lista=q.list();
        int i=0;
        
        //Obtenemos un iterador y recorremos la lista.
        Iterator <Mecanico> iter =lista.iterator();
        while(iter.hasNext()){
           au = iter.next();
           listaMecanicos.add(new ArrayList(i));
           listaMecanicos.get(i).add(au.getDni());
           listaMecanicos.get(i).add(au.getNombre());
           listaMecanicos.get(i).add(au.getApellido1()); 
           listaMecanicos.get(i).add(au.getApellido2());
           listaMecanicos.get(i).add(au.getDireccion());
           listaMecanicos.get(i).add(Integer.toString(au.getTelefono()));
           listaMecanicos.get(i).add(Float.toString(au.getSalario()));
           listaMecanicos.get(i).add(au.getContratacion());
           i++;
        }
        this.session.close();//cerramos la sesion
           
        return listaMecanicos;
       
    }
    
    
    public void borrarMecanico(String dni){
        //Por seguridad les paso valores cade vez que haga una accion
        this.sesion=HibernateUtil.createSessionFactory();
        this.session=sesion.openSession();
        this.tx=session.beginTransaction();
        try{
           session.createSQLQuery("delete from Mecanico where dni='"+dni+"'").executeUpdate();
           this.log="Mecanico borrado" ;
        }catch(Exception e){
            this.log=e.getMessage();
        }
        this.tx.commit();
        this.session.close();//cerramos la sesion
    }
            
    
    
    
    
    
    
    
    
    
    
    
    
}
