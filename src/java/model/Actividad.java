package model;

import java.util.Date;

public class Actividad extends DatosGenerales{
    private int idActividad;
    private int tarea;

    public Actividad() {
    }

    public Actividad(int idActividad, int tarea, String titulo, String descripcion, Date fechaInicio, Date fechaFin) {
        super(titulo, descripcion, fechaInicio, fechaFin);
        this.idActividad = idActividad;
        this.tarea = tarea;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public int getTarea() {
        return tarea;
    }

    public void setTarea(int tarea) {
        this.tarea = tarea;
    }
    
}
