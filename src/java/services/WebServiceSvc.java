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
import model.Empresa;
import model.Proyecto;
import model.Tarea;
import model.Usuario;
import repository.ActividadRepository;
import repository.EmpresaRepository;
import repository.ProyectoRepository;
import repository.TareaRepository;
import repository.UsuarioRepository;

/**
 *
 * @author oscar
 */
@WebService(serviceName = "WebServiceSvc")
public class WebServiceSvc {

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
    
    @WebMethod(operationName = "listarActividadesPorTarea")
    public List<Actividad> listarActividadesPorTarea(@WebParam(name = "tarea") int tarea) throws ParseException {
        ActividadRepository actividad = new ActividadRepository();
        return actividad.listarActividadesPorProyecto(tarea);
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
    
     @WebMethod(operationName = "listarUsuarios")
    public List<Usuario> listarUsuarios() throws ParseException {
        UsuarioRepository u = new UsuarioRepository();
        return u.listarUsuario();
    }

    @WebMethod(operationName = "listarUsuarioPorId")
    public Usuario listarUsuarioPorId(@WebParam(name = "idUsuario") int idUsuario) throws ParseException {
         UsuarioRepository u = new UsuarioRepository();
        return u.listarUsuarioPorId(idUsuario);
    }
    
    @WebMethod(operationName = "autenticarUsuario")
    public Usuario autenticarUsuario(@WebParam(name = "email") String email, @WebParam(name = "password") String password) throws ParseException {
         UsuarioRepository u = new UsuarioRepository();
        return u.autenticar(email, password);
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
    
    @WebMethod(operationName = "listarEmpresas")
    public List<Empresa> listarEmpresas() throws ParseException {
    EmpresaRepository e = new EmpresaRepository();
    return e.listarEmpresas();
    }

    @WebMethod(operationName = "listarEmpresaPorId")
    public Empresa listarEmpresaPorId(@WebParam(name = "idEmpresa") int idEmpresa) throws ParseException {
        EmpresaRepository e = new EmpresaRepository();
        return e.listarEmpresaPorId(idEmpresa);
    }
    
    @WebMethod(operationName = "insertarProyecto")
    public int insertarProyecto(@WebParam(name = "titulo") String titulo, @WebParam(name = "descripcion") String descripcion, @WebParam(name = "fechaInicio") String fechaInicio,
            @WebParam(name = "fechaFin") String fechaFin, @WebParam(name = "empresa") int empresa) throws ParseException {
        Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(fechaInicio);
        Date date2 = new SimpleDateFormat("dd-MM-yyyy").parse(fechaFin);
        ProyectoRepository proyecto = new ProyectoRepository();
        return proyecto.insertar_Proyecto(empresa,titulo,descripcion,date1,date2);
    }

    @WebMethod(operationName = "actualizarProyecto")
    public int actualizarProyecto(@WebParam(name = "titulo") String titulo, @WebParam(name = "descripcion") String descripcion, @WebParam(name = "fechaInicio") String fechaInicio,
            @WebParam(name = "fechaFin") String fechaFin, @WebParam(name = "empresa") int empresa, @WebParam(name = "idProyecto") int idProyecto) throws ParseException {
        Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(fechaInicio);
        Date date2 = new SimpleDateFormat("dd-MM-yyyy").parse(fechaFin);
        ProyectoRepository p = new ProyectoRepository();
        return p.actualizar_Proyecto(idProyecto, empresa, titulo, descripcion, date1,date2);
    }

    @WebMethod(operationName = "eliminarProyecto")
    public int eliminarProyecto(@WebParam(name = "idProyecto") int idProyecto) {
        ProyectoRepository p = new ProyectoRepository();
        return p.eliminar_Proyecto(idProyecto);
    }
    
    @WebMethod(operationName = "listarProyectos")
    public List<Proyecto> listarProyectos() throws ParseException {
        ProyectoRepository p = new ProyectoRepository();
        return p.listarProyectos();
    }

    @WebMethod(operationName = "listarProyectoPorId")
    public Proyecto listarProyectoPorId(@WebParam(name = "idProyecto") int idProyecto) throws ParseException {
        ProyectoRepository p = new ProyectoRepository();
        return p.listarProyectoPorId(idProyecto);
    }
    
    @WebMethod(operationName = "insertarTarea")
    public int insertarTarea(@WebParam(name = "titulo") String titulo, @WebParam(name = "descripcion") String descripcion, @WebParam(name = "fechaInicio") String fechaInicio,
            @WebParam(name = "fechaFin") String fechaFin, @WebParam(name = "proyecto") int proyecto) throws ParseException {
        Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(fechaInicio);
        Date date2 = new SimpleDateFormat("dd-MM-yyyy").parse(fechaFin);
        TareaRepository tarea = new TareaRepository();
        return tarea.insertar(proyecto,titulo, descripcion, date1, date2);
    }

    @WebMethod(operationName = "actualizarTarea")
    public int actualizarTarea(@WebParam(name = "titulo") String titulo, @WebParam(name = "descripcion") String descripcion, @WebParam(name = "fechaInicio") String fechaInicio,
            @WebParam(name = "fechaFin") String fechaFin, @WebParam(name = "proyecto") int proyecto, @WebParam(name = "idTarea") int idTarea) throws ParseException {
        Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(fechaInicio);
        Date date2 = new SimpleDateFormat("dd-MM-yyyy").parse(fechaFin);
        TareaRepository tarea = new TareaRepository();
        return tarea.actualizar(idTarea,proyecto,titulo, descripcion, date1, date2);
    }

    @WebMethod(operationName = "eliminarTarea")
    public int eliminarTarea(@WebParam(name = "idTarea") int idTarea) throws ParseException {
        TareaRepository tarea = new TareaRepository();
        return tarea.eliminar(idTarea);
    }

    @WebMethod(operationName = "listarTareas")
    public List<Tarea> listarTareas() throws ParseException {
        TareaRepository tarea = new TareaRepository();
        return tarea.listarTareas();
    }

    @WebMethod(operationName = "listarTareaPorId")
    public Tarea listarTareaPorId(@WebParam(name = "idTarea") int idTarea) throws ParseException {
        TareaRepository tarea = new TareaRepository();
        return tarea.listarTareaPorId(idTarea);
    }
    
    @WebMethod(operationName = "listarTareasPorProyecto")
    public List<Tarea> listarTareasPorProyecto(@WebParam(name = "proyecto") int proyecto) throws ParseException {
        TareaRepository tarea = new TareaRepository();
        return tarea.listarTareasPorProyecto(proyecto);
    }
    
}
