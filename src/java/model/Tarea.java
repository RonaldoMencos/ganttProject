package model;

import java.util.Date;


public class Tarea extends DatosGenerales {
    private int idTarea;
    private int proyecto;

    public Tarea() {
    }

    public Tarea(int idTarea, int proyecto, String titulo, String descripcion, Date fechaInicio, Date fechaFin) {
        super(titulo, descripcion, fechaInicio, fechaFin);
        this.idTarea = idTarea;
        this.proyecto = proyecto;
    }

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public int getProyecto() {
        return proyecto;
    }

    public void setProyecto(int proyecto) {
        this.proyecto = proyecto;
    }
    
}
