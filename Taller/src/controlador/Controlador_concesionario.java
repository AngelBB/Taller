/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import modelo.Concesionario;
import modelo.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Angel
 */
public class Controlador_concesionario {
    int cod_concesionario;
    String nombre;
    String direccion;
    String log;
    SessionFactory sesion;
    Session session;
    Transaction tx;
    
    public String getLog() {
        return log+"\n";
    }

    public void setLog(String log) {
        this.log = log;
    }
    

    public Controlador_concesionario(int cod_concesionario, String nombre, String direccion) {
        this.cod_concesionario = cod_concesionario;
        this.nombre = nombre;
        this.direccion = direccion;
        try{
            //Por seguridad les paso valores cade vez que haga una accion
            this.sesion=HibernateUtil.createSessionFactory();
            this.session=sesion.openSession();
            this.tx=session.beginTransaction();
                Concesionario co=new Concesionario(cod_concesionario,nombre,direccion);
                session.save(co);
            this.tx.commit();//Hacemos un commit
            this.session.close();//cerramos la sesion
            this.log="Concesionario "+this.cod_concesionario+" se ha insertado.";
        }catch(Exception e){
            this.log=e.getMessage();
        }
    }
    public Controlador_concesionario(){}
    
    public int getCod_concesionario() {
        return cod_concesionario;
    }

    public void setCod_concesionario(int cod_concesionario) {
        this.cod_concesionario = cod_concesionario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public void actualizar_Concesionario(int codantiguo,int cod, String nombre, String direccion) {
     try{
            //Por seguridad les paso valores cade vez que haga una accion
            this.sesion=HibernateUtil.createSessionFactory();
            this.session=sesion.openSession();
            this.tx=session.beginTransaction();
                        
            /*Concesionario co;
            co=(Concesionario)session.load(Concesionario.class,codantiguo);
            co.setCodigo(cod);
            co.setNombre(nombre);
            co.setDireccion(direccion);
            session.update(co);//Salvamos los datos*/
            this.session.createSQLQuery("update Concesionario set codigo="+cod+",nombre='"+nombre+"',direccion='"+direccion+"' where codigo="+codantiguo).executeUpdate();
            this.tx.commit();//Hacemos un commit
            this.session.close();//cerramos la sesion
            this.log="Concesionario "+codantiguo+" se ha actualizado.";
        }catch(Exception e){
            this.log=e.getMessage();
        }
    }
    
    //Para rellenar los campos de actualizacion**************************************************** 
    public void recogerDatosConcesionario(int cod){
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
        
        Concesionario cl;
        Query q=session.createQuery("from Concesionario where codigo= "+cod);
        List<Concesionario> lista=q.list();
        Iterator <Concesionario> iter =lista.iterator();
        while(iter.hasNext()){
            cl = iter.next();
            this.cod_concesionario=cl.getCodigo();
            this.nombre=cl.getNombre();
            this.direccion=cl.getDireccion();
        }
        
        this.session.close();//cerramos la sesion
    }  
    
    public ArrayList<Integer> cargarConcesionarios(){
       
        //Por seguridad les paso valores cade vez que haga una accion
        this.sesion=HibernateUtil.createSessionFactory();
        this.session=sesion.openSession();
       // this.tx=session.beginTransaction();

        Concesionario au;
        ArrayList<Integer> listaDnis=new ArrayList<>();
        Query q=session.createQuery("from Concesionario");
        List<Concesionario> lista=q.list();

        //Obtenemos un iterador y recorremos la lista.
        Iterator <Concesionario> iter =lista.iterator();
        while(iter.hasNext()){
           au = iter.next();
           listaDnis.add(au.getCodigo());
        }
        this.session.close();//cerramos la sesion
           
        return listaDnis;
    }
     
    public ArrayList<ArrayList<String>> consultaConcesionario(int cod){
    
        //Por seguridad les paso valores cade vez que haga una accion
        this.sesion=HibernateUtil.createSessionFactory();
        this.session=sesion.openSession();
        //this.tx=session.beginTransaction();

        Concesionario au;
        ArrayList<ArrayList<String>> listaConcesionarios=new ArrayList<>();
        Query q=session.createQuery("from Concesionario where codigo= "+cod);
        List<Concesionario> lista=q.list();
        int i=0;
        
        //Obtenemos un iterador y recorremos la lista.
        Iterator <Concesionario> iter =lista.iterator();
        while(iter.hasNext()){
           au = iter.next();
           listaConcesionarios.add(new ArrayList(i));
           listaConcesionarios.get(i).add(Integer.toString(au.getCodigo()));
           listaConcesionarios.get(i).add(au.getNombre());
           listaConcesionarios.get(i).add(au.getDireccion()); 
           i++;
        }
        this.session.close();//cerramos la sesion
           
        return listaConcesionarios;
       
    }
    
    
    public void borrarConcesionario(String cod){
        //Por seguridad les paso valores cade vez que haga una accion
        this.sesion=HibernateUtil.createSessionFactory();
        this.session=sesion.openSession();
        this.tx=session.beginTransaction();
        try{
            Query q=session.createSQLQuery("delete from Concesionario where codigo="+cod);
            q.executeUpdate();
           this.log="Concesionario borrado" ;
        }catch(Exception e){
            this.log=e.getMessage();
        }
        this.tx.commit();
        this.session.close();//cerramos la sesion
    }
}
