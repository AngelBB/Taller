/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import modelo.Automovil;
import modelo.HibernateUtil;
import modelo.Mecanico;
import modelo.Repara;
import modelo.ReparaId;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Angel
 */
public class Controlador_repara {
    String matricula;
    String dni_mecanico;
    int n_horas;
    String fecha;//Cuidado con la fecha
    //Porque la base de datos tiene formato americano
    //Para crear la sesion e iniciar la sesion en la BD
    SessionFactory sesion;
    Session session;

    public String getLog() {
        return log+"\n";
    }

    public void setLog(String log) {
        this.log = log;
    }
    Transaction tx;
    
    String log;
    //Para obtener la hora actual
    /*Date now = new Date();
    DateFormat df =  DateFormat.getDateInstance();
    String s =  df.format(now);*/

    public Controlador_repara(String matricula, String dni_mecanico, int n_horas, String fecha) {
        this.matricula = matricula;
        this.dni_mecanico = dni_mecanico;
        this.n_horas = n_horas;
        this.fecha = fecha;
    }
    
    public Controlador_repara(){}
    
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getDni_mecanico() {
        return dni_mecanico;
    }

    public void setDni_mecanico(String dni_mecanico) {
        this.dni_mecanico = dni_mecanico;
    }

    public int getN_horas() {
        return n_horas;
    }

    public void setN_horas(int n_horas) {
        this.n_horas = n_horas;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    //Insertar**********************************************************
    public void insertar_Reparacion(String matricula, String mecanico, int n_horas, String fecha){
       /* Automovil au;
        Mecanico me;
        Repara rep;
        ReparaId repID;
        Date fecha_formateada=null;*/
             
        //Por seguridad les paso valores cade vez que haga una accion
        this.sesion=HibernateUtil.createSessionFactory();
        this.session=sesion.openSession();
        this.tx=session.beginTransaction();
        
        String [] fecha_sql=fecha.split("-");
        String fechaBuena=fecha_sql[2]+"-"+fecha_sql[1]+"-"+fecha_sql[0];
        this.session.createSQLQuery("insert into Repara values('"+mecanico+"','"+matricula+"',"+n_horas+",'"+fechaBuena+"')").executeUpdate();
        
       /* au=(Automovil)session.load(Automovil.class,matricula);
        me=(Mecanico)session.load(Mecanico.class,mecanico);
        rep=new Repara(new ReparaId(matricula,mecanico,n_horas,fecha_formateada),au,me);*/
    
       // session.save(rep);
        this.tx.commit();//Hacemos un commit
        this.session.close();//cerramos la sesion
        this.log="La reparacion se ha insertado.";
    }
     
    //Actualizar**********************************************************
    public void actualizar_Reparacion(String matricula,String mecanico,int n_horas, String fecha_nueva,String fecha_antigua){
     try{
            //Por seguridad les paso valores cade vez que haga una accion
            this.sesion=HibernateUtil.createSessionFactory();
            this.session=sesion.openSession();
            this.tx=session.beginTransaction();
            
            if(!"".equals(matricula) && !"".equals(fecha_antigua)){
                String [] fecha_sql_ant=fecha_antigua.split("-");
                String fechaBuena_ant=fecha_sql_ant[2]+"-"+fecha_sql_ant[1]+"-"+fecha_sql_ant[0];
                
                String [] fecha_sql_nu=fecha_nueva.split("-");
                String fechaBuena_nu=fecha_sql_nu[2]+"-"+fecha_sql_nu[1]+"-"+fecha_sql_nu[0];
                
                this.session.createSQLQuery("update Repara set dni_mecanico='"+mecanico+"',"
                        +"num_horas="+n_horas+", fecha='"+fechaBuena_nu+"'"+
                        "where matricula='"+matricula+"' and fecha='"+fechaBuena_ant+"'").executeUpdate();
                
                this.log="Reparacion actualizada";
            }else{
                this.log="Debes elegir selecionar los dos selects";
            }
               
            this.tx.commit();//Hacemos un commit
            this.session.close();//cerramos la sesion
            
        }catch(Exception e){
            this.log=e.getMessage();
        }
    }
    //para añadir a la clase propia **********************************************************
    public void recogerDatosReparacion(String fecha, String mat){
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
        
        //Clases necesarias
        Repara rep;
        
        String [] fecha_sql_nu=fecha.split("-");
        String fechaBuena_nu=fecha_sql_nu[2]+"-"+fecha_sql_nu[1]+"-"+fecha_sql_nu[0];
                      
        Query q=session.createQuery("from Repara where matricula= '"+mat+"' and fecha= '"+fechaBuena_nu+"'");
        List<Repara> lista=q.list();
        Iterator <Repara> iter =lista.iterator();
        while(iter.hasNext()){
            rep = iter.next();
            this.dni_mecanico=rep.getId().getDniMecanico();
            
            
            String [] fecha_sql_nuu=rep.getId().getFecha().toString().split("-");
            String fechaBuena_nuu=fecha_sql_nuu[2]+"-"+fecha_sql_nuu[1]+"-"+fecha_sql_nuu[0];
            this.fecha=fechaBuena_nuu;
            
            
            this.matricula=rep.getId().getMatricula();
            this.n_horas=rep.getId().getNumHoras();
        }
        this.session.close();//cerramos la sesion
    }
    
    //Para rellenar los select*************************************************
    public ArrayList<String> cargarReparacionesMatriculas(){
       
        //Por seguridad les paso valores cade vez que haga una accion
        this.sesion=HibernateUtil.createSessionFactory();
        this.session=sesion.openSession();
        //this.tx=session.beginTransaction();

        Repara au;
        ArrayList<String> listaMatriculas=new ArrayList<>();
        Query q=session.createQuery("from Repara ");
        List<Repara> lista=q.list();

        //Obtenemos un iterador y recorremos la lista.
        Iterator <Repara> iter =lista.iterator();
        while(iter.hasNext()){
           au = iter.next();
           listaMatriculas.add(au.getAutomovil().getMatricula());
        }
        this.session.close();//cerramos la sesion
           
        return listaMatriculas;
    }
    
    public ArrayList<String> cargarReparacionesMecanicos(String mat){
       
        //Por seguridad les paso valores cade vez que haga una accion
        this.sesion=HibernateUtil.createSessionFactory();
        this.session=sesion.openSession();
        //this.tx=session.beginTransaction();

        Repara au;
        ArrayList<String> listaDNIs=new ArrayList<>();
        Query q=session.createQuery("from Repara where matricula= '"+mat+"'");
        List<Repara> lista=q.list();

        //Obtenemos un iterador y recorremos la lista.
        Iterator <Repara> iter =lista.iterator();
        while(iter.hasNext()){
           au = iter.next();
           listaDNIs.add(au.getId().getDniMecanico());
        }
        this.session.close();//cerramos la sesion
           
        return listaDNIs;
    }
    
    public ArrayList<String> cargarReparacionesMecanicosSP(){
       
        //Por seguridad les paso valores cade vez que haga una accion
        this.sesion=HibernateUtil.createSessionFactory();
        this.session=sesion.openSession();
        //this.tx=session.beginTransaction();

        Repara au;
        ArrayList<String> listaDNIs=new ArrayList<>();
        Query q=session.createQuery("from Repara");
        List<Repara> lista=q.list();

        //Obtenemos un iterador y recorremos la lista.
        Iterator <Repara> iter =lista.iterator();
        while(iter.hasNext()){
           au = iter.next();
           listaDNIs.add(au.getId().getDniMecanico());
        }
        this.session.close();//cerramos la sesion
           
        return listaDNIs;
    }
    
    
    //Consulta******************************************************************
    public ArrayList<ArrayList<String>> consultaReparaciones(String matricula,String fecha){
    
        //Por seguridad les paso valores cade vez que haga una accion
        this.sesion=HibernateUtil.createSessionFactory();
        this.session=sesion.openSession();
        //this.tx=session.beginTransaction();

        String [] fecha_sql_nu=fecha.split("-");
        String fechaBuena_nu=fecha_sql_nu[2]+"-"+fecha_sql_nu[1]+"-"+fecha_sql_nu[0];
        
        
        Repara au;
        ArrayList<ArrayList<String>> listaAutos=new ArrayList<>();
        Query q=session.createQuery("from Repara where matricula= '"+matricula+"' and fecha= '"+fechaBuena_nu+"'");
        List<Repara> lista=q.list();
        int i=0;
        
        //Obtenemos un iterador y recorremos la lista.
        Iterator <Repara> iter =lista.iterator();
        while(iter.hasNext()){
           au = iter.next();
           listaAutos.add(new ArrayList(i));
           listaAutos.get(i).add(au.getId().getMatricula());
           listaAutos.get(i).add(au.getId().getDniMecanico());
           listaAutos.get(i).add(Integer.toString(au.getId().getNumHoras()));
           listaAutos.get(i).add(au.getId().getFecha().toString());
           i++;
        }
        this.session.close();//cerramos la sesion
        return listaAutos;
    }
    
    //Borrar**********************************************************
    public void borrarReparacion(String matricuca,String fecha){
        //Por seguridad les paso valores cade vez que haga una accion
        this.sesion=HibernateUtil.createSessionFactory();
        this.session=sesion.openSession();
        this.tx=session.beginTransaction();
        try{
            String [] fecha_sql_nu=fecha.split("-");
            String fechaBuena_nu=fecha_sql_nu[2]+"-"+fecha_sql_nu[1]+"-"+fecha_sql_nu[0];
            session.createSQLQuery("delete from Repara where matricula='"+matricuca+"' and fecha='"+fechaBuena_nu+"'").executeUpdate();
            this.log="Reparacion borrada" ;
        }catch(Exception e){
            this.log=e.getMessage();
        }
        this.tx.commit();
        this.session.close();//cerramos la sesion
    }
    
    
    
     public ArrayList<String> cargarReparacionFecha(){
       
        //Por seguridad les paso valores cade vez que haga una accion
        this.sesion=HibernateUtil.createSessionFactory();
        this.session=sesion.openSession();
        //this.tx=session.beginTransaction();

        Repara au;
        ArrayList<String> listaFechas=new ArrayList<>();
        Iterator <Repara> iter=session.createQuery("select from Repara").iterate();
       
        //Obtenemos un iterador y recorremos la lista.
        while(iter.hasNext()){
           au = iter.next();
            String fecha=au.getId().getFecha().toString();
            String []fechaBuena=fecha.split("-");
            String fechaEsp =fechaBuena[2]+"-"+fechaBuena[1]+"-"+fechaBuena[0];
           
            listaFechas.add(fechaEsp);
        }
        this.session.close();//cerramos la sesion
           
        //Para borrar los duplicados
        HashSet hs = new HashSet(); 
        hs.addAll(listaFechas); 
        listaFechas.clear(); 
        listaFechas.addAll(hs);

        return listaFechas;
    }
    
    public ArrayList<String> cargarMatriculasXFecha(String fecha){
       
        //Por seguridad les paso valores cade vez que haga una accion
        this.sesion=HibernateUtil.createSessionFactory();
        this.session=sesion.openSession();
        //this.tx=session.beginTransaction();
        String [] fecha_sql_nu=fecha.split("-");
        String fechaBuena_nu=fecha_sql_nu[2]+"-"+fecha_sql_nu[1]+"-"+fecha_sql_nu[0];
        
        Repara au;
        ArrayList<String> listaMatriculas=new ArrayList<>();
        Query q=session.createQuery("from Repara where fecha='"+fechaBuena_nu+"'");
        List<Repara> lista=q.list();

        //Obtenemos un iterador y recorremos la lista.
        Iterator <Repara> iter =lista.iterator();
        while(iter.hasNext()){
           au = iter.next();
           listaMatriculas.add(au.getId().getMatricula());
        }
        this.session.close();//cerramos la sesion
           
        return listaMatriculas;
    }
}