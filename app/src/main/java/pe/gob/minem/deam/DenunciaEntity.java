package pe.gob.minem.deam;

/**
 * Created by ronaldvelasquez on 10/12/16.
 */

public class DenunciaEntity {
    private int id;
    private String titulo;
    private String descripcion;
    private String nombreDenunciante;
    private String apellidoDenunciante;

    public DenunciaEntity(int id, String titulo, String descripcion, String nombreDenunciante, String apellidoDenunciante) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.nombreDenunciante = nombreDenunciante;
        this.apellidoDenunciante = apellidoDenunciante;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreDenunciante() {
        return nombreDenunciante;
    }

    public void setNombreDenunciante(String nombreDenunciante) {
        this.nombreDenunciante = nombreDenunciante;
    }

    public String getApellidoDenunciante() {
        return apellidoDenunciante;
    }

    public void setApellidoDenunciante(String apellidoDenunciante) {
        this.apellidoDenunciante = apellidoDenunciante;
    }
}
