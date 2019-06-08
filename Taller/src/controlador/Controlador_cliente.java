/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import modelo.Cliente;
import modelo.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Angel
 */
public class Controlador_cliente {
    
    String dni;
    String nombre;
    String apellido1;
    String apellido2;
    String direccion;
    int tlf;
    String log;
    //Para crear la sesion e iniciar la sesion en la BD
    SessionFactory sesion;
    Session session;
    Transaction tx;

    public Controlador_cliente(String dni, String nombre, String apellido1, String apellido2, String direccion, int tlf) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.direccion = direccion;
        this.tlf = tlf;
        try{
            //Por seguridad les paso valores cade vez que haga una accion
            this.sesion=HibernateUtil.createSessionFactory();
            this.session=sesion.openSession();
            this.tx=session.beginTransaction();
                Cliente cl=new Cliente(dni,nombre,apellido1,apellido2,direccion,tlf);
                session.save(cl);
            this.tx.commit();//Hacemos un commit
            this.session.close();//cerramos la sesion
            this.log="Cliente "+this.dni+" se ha insertado.";
        }catch(Exception e){
            this.log=e.getMessage();
        }
    }
    
    public Controlador_cliente(){}
    
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
    
    
    public void actualizar_Cliente(String Dniantiguo,String dni, String nombre, String apellido1, String apellido2, String direccion, int tlf) {
     try{
            //Por seguridad les paso valores cade vez que haga una accion
            this.sesion=HibernateUtil.createSessionFactory();
            this.session=sesion.openSession();
            this.tx=session.beginTransaction();
                        
            /*Cliente cl;
            cl=(Cliente)session.load(Cliente.class,Dniantiguo);
            cl.setDni(dni);
            cl.setNombre(nombre);
            cl.setApellido1(apellido1);
            cl.setApellido2(apellido2);
            cl.setDireccion(direccion);
            cl.setTlf(tlf);*/
            //session.update(cl);//Salvamos los datos
            session.createSQLQuery("update Cliente set dni='"+dni+"' , nombre='"+nombre+"',"+
                    "apellido1='"+apellido1+"',apellido2='"+apellido2+"',direccion='"+direccion+"',tlf="+tlf+" where dni='"+Dniantiguo+"'").executeUpdate();
            this.tx.commit();//Hacemos un commit
            this.session.close();//cerramos la sesion
            this.log="Cliente "+dni+" se ha actualizado.";
        }catch(Exception e){
            this.log=e.getMessage();
        }
    }
    
    //Para rellenar los campos de actualizacion**************************************************** 
    public void recogerDatosCliente(String dni_prop){
        //Por seguridad les paso valores cade vez que haga una accion
        this.sesion=HibernateUtil.createSessionFactory();
        this.session=sesion.openSession();
        //this.tx=session.beginTransaction();
        
        /*
        *Lo que debemos hacer es llamar a la clase automovil y automovilid
        *y sacar el vehiculo por su matricula despues desde este mismo metodo
        *rellenamos los valores de esta clase.
        *
        */
        
        Cliente cl;
        Query q=session.createQuery("from Cliente where dni='"+dni_prop+"'");
        List<Cliente> lista=q.list();
        Iterator <Cliente> iter =lista.iterator();
        while(iter.hasNext()){
            cl = iter.next();
            this.dni=cl.getDni();
            this.nombre=cl.getNombre();
            this.apellido1=cl.getApellido1();
            this.apellido2=cl.getApellido2();
            this.direccion=cl.getDireccion();
            this.tlf=cl.getTlf();
        }
        
        this.session.close();//cerramos la sesion
    }  
    
    public ArrayList<String> cargarClientes(){
       
        //Por seguridad les paso valores cade vez que haga una accion
        this.sesion=HibernateUtil.createSessionFactory();
        this.session=sesion.openSession();
        //this.tx=session.beginTransaction();

        Cliente au;
        ArrayList<String> listaDnis=new ArrayList<>();
        Query q=session.createQuery("from Cliente");
        List<Cliente> lista=q.list();

        //Obtenemos un iterador y recorremos la lista.
        Iterator <Cliente> iter =lista.iterator();
        while(iter.hasNext()){
           au = iter.next();
           listaDnis.add(au.getDni());
        }
        this.session.close();//cerramos la sesion
           
        return listaDnis;
    }
     
    public ArrayList<ArrayList<String>> consultaCliente(String dni){
    
        //Por seguridad les paso valores cade vez que haga una accion
        this.sesion=HibernateUtil.createSessionFactory();
        this.session=sesion.openSession();
        //this.tx=session.beginTransaction();

        Cliente au;
        ArrayList<ArrayList<String>> listaClientes=new ArrayList<>();
        Query q=session.createQuery("from Cliente where dni='"+dni+"'");
        List<Cliente> lista=q.list();
        int i=0;
        
        //Obtenemos un iterador y recorremos la lista.
        Iterator <Cliente> iter =lista.iterator();
        while(iter.hasNext()){
           au = iter.next();
           listaClientes.add(new ArrayList(i));
           listaClientes.get(i).add(au.getDni());
           listaClientes.get(i).add(au.getNombre());
           listaClientes.get(i).add(au.getApellido1()); 
           listaClientes.get(i).add(au.getApellido2());
           listaClientes.get(i).add(au.getDireccion());
           listaClientes.get(i).add(Integer.toString(au.getTlf()));
           i++;
        }
        this.session.close();//cerramos la sesion
           
        return listaClientes;
       
    }
    
    
    public void borrarCliente(String dni){
        //Por seguridad les paso valores cade vez que haga una accion
        this.sesion=HibernateUtil.createSessionFactory();
        this.session=sesion.openSession();
        this.tx=session.beginTransaction();
        try{
            Query q=session.createSQLQuery("delete from Cliente where dni='"+dni+"'");
            //Query q=session.createQuery("delete Cliente where dni='"+dni+"'");
            q.executeUpdate();
           this.log="Cliente borrado" ;
        }catch(Exception e){
            this.log=e.getMessage();
        }
        this.tx.commit();
        this.session.close();//cerramos la sesion
    }
}
