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
import repository.EmpresaRepository;
import repository.UsuarioRepository;

/**
 *
 * @author oscar
 */
@WebService(serviceName = "WebServiceSvc")
public class WebServiceSvc {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "insertarActividad")
    public int insertarActividad(@WebParam(name = "titulo") String titulo, @WebParam(name = "descripcion") String descripcion, @WebParam(name = "fechaInicio") String fechaInicio,
            @WebParam(name = "fechaFin") String fechaFin, @WebParam(name = "tarea") int tarea) throws ParseException {
        Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(fechaInicio);
        Date date2 = new SimpleDateFormat("dd-MM-yyyy").parse(fechaFin);
        ActividadRepository actividad = new ActividadRepository();
        return actividad.insertar(titulo, descripcion, date1, date2, tarea);
    }

    @WebMethod(operationName = "actualizarActividad")
    public int actualizarActividad(@WebParam(name = "titulo") String titulo, @WebParam(name = "descripcion") String descripcion, @WebParam(name = "fechaInicio") String fechaInicio,
            @WebParam(name = "fechaFin") String fechaFin, @WebParam(name = "tarea") int tarea, @WebParam(name = "idActividad") int idActividad) throws ParseException {
        Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(fechaInicio);
        Date date2 = new SimpleDateFormat("dd-MM-yyyy").parse(fechaFin);
        ActividadRepository actividad = new ActividadRepository();
        return actividad.actualizar(titulo, descripcion, date1, date2, tarea, idActividad);
    }

    @WebMethod(operationName = "eliminarActividad")
    public int eliminarActividad(@WebParam(name = "idActividad") int idActividad) throws ParseException {
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

    @WebMethod(operationName = "insertarUsuario")
    public int insertarUsuario(@WebParam(name = "nombre") String nombre, @WebParam(name = "apellido") String apellido,
            @WebParam(name = "email") String email, @WebParam(name = "password") String password) {
        UsuarioRepository u = new UsuarioRepository();
        return u.insertar_usuario(nombre, apellido, email, password);
    }

    @WebMethod(operationName = "actualizarUsuario")
    public int actualizarUsuario(@WebParam(name = "nombre") String nombre, @WebParam(name = "apellido") String apellido,
            @WebParam(name = "email") String email, @WebParam(name = "password") String password,
            @WebParam(name = "idUsuario") int idUsuario) {
        UsuarioRepository u = new UsuarioRepository();
        return u.actualizar_usuario(nombre, apellido, email, password, idUsuario);
    }

    @WebMethod(operationName = "eliminarUsuario")
    public int eliminarUsuario(@WebParam(name = "idUsuario") int idUsuario) {
        UsuarioRepository u = new UsuarioRepository();
        return u.eliminar(idUsuario);
    }

    @WebMethod(operationName = "insertarEmpresa")
    public int insertarEmpresa(@WebParam(name = "nombre") String nombre, @WebParam(name = "direccion") String direccion,
            @WebParam(name = "email") String email, @WebParam(name = "telefono") String telefono) {
        EmpresaRepository e = new EmpresaRepository();
        return e.insertar_Empresa(nombre, direccion, email, telefono);
    }

    @WebMethod(operationName = "actualizarEmpresa")
    public int actualizarEmpresa(@WebParam(name = "nombre") String nombre, @WebParam(name = "direccion") String direccion,
            @WebParam(name = "email") String email, @WebParam(name = "telefono") String telefono,
            @WebParam(name = "idEmpresa") int idEmpresa) {
        EmpresaRepository e = new EmpresaRepository();
        return e.actualizar_Empresa(idEmpresa, nombre, direccion, email, telefono);
    }

    @WebMethod(operationName = "eliminarEmpresa")
    public int eliminarEmpresa(@WebParam(name = "idEmpresa") int idEmpresa) {
        EmpresaRepository e = new EmpresaRepository();
        return e.eliminar_Empresa(idEmpresa);
    }
}
