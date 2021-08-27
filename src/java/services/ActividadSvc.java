/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import model.Actividad;
import repository.ActividadRepository;

/**
 *
 * @author oscar
 */
@WebService(serviceName = "ActividadSvc")
public class ActividadSvc {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "insertar")
    public int insertar(@WebParam(name = "titulo") String titulo, @WebParam(name = "descripcion") String descripcion, @WebParam(name = "fechaInicio") String fechaInicio,
            @WebParam(name = "fechaFin") String fechaFin,@WebParam(name = "tarea") int tarea) throws ParseException {
        Date date1=new SimpleDateFormat("dd-MM-yyyy").parse(fechaInicio);  
        Date date2=new SimpleDateFormat("dd-MM-yyyy").parse(fechaFin); 
        ActividadRepository actividad = new ActividadRepository();
        return actividad.insertar(titulo, descripcion, date1, date2,tarea);
    }
    
    @WebMethod(operationName = "actualizar")
    public int actualizar(@WebParam(name = "titulo") String titulo, @WebParam(name = "descripcion") String descripcion, @WebParam(name = "fechaInicio") String fechaInicio,
            @WebParam(name = "fechaFin") String fechaFin,@WebParam(name = "tarea") int tarea,@WebParam(name = "idActividad") int idActividad) throws ParseException {
        Date date1=new SimpleDateFormat("dd-MM-yyyy").parse(fechaInicio);  
        Date date2=new SimpleDateFormat("dd-MM-yyyy").parse(fechaFin); 
        ActividadRepository actividad = new ActividadRepository();
        return actividad.actualizar(titulo, descripcion, date1, date2,tarea,idActividad);
    }
    
    @WebMethod(operationName = "eliminar")
    public int eliminar(@WebParam(name = "idActividad") int idActividad) throws ParseException {
        ActividadRepository actividad = new ActividadRepository();
        return actividad.eliminar(idActividad);
    }
    
    @WebMethod(operationName = "listarActividades")
    public List<Actividad> listarActividades() throws ParseException {
        ActividadRepository actividad = new ActividadRepository();      
        return actividad.listarActividades();
    }
    
    @WebMethod(operationName = "listarActividadPorId")
    public Actividad listarActividadPorId(@WebParam(name = "idActividad") int idActividad) throws ParseException {
        ActividadRepository actividad = new ActividadRepository();      
        return actividad.listarActividadPorId(idActividad);
    }
}

