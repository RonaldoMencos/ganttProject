package model;

import java.util.Date;

public class Proyecto extends DatosGenerales {
    private int idProyecto;
    private int empresa;

    public Proyecto() {
    }

    public Proyecto(int idProyecto, int empresa, String titulo, String descripcion, Date fechaInicio, Date fechaFin) {
        super(titulo, descripcion, fechaInicio, fechaFin);
        this.idProyecto = idProyecto;
        this.empresa = empresa;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }
    
}
