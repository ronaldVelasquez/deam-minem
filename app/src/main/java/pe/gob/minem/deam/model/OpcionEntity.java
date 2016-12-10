package pe.gob.minem.deam.model;

/**
 * Created by ronaldvelasquez on 10/12/16.
 */

public class OpcionEntity {
    private int id;
    private String titulo;
    private String desripcion;

    public OpcionEntity(int id, String titulo, String desripcion) {
        this.id = id;
        this.titulo = titulo;
        this.desripcion = desripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDesripcion() {
        return desripcion;
    }

    public void setDesripcion(String desripcion) {
        this.desripcion = desripcion;
    }
}
