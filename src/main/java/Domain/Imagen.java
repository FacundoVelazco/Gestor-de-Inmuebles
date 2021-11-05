package Domain;

import javax.swing.*;

public class Imagen {


    private Integer id;
    private ImageIcon imagen;
    private String nombreArchivo;
    private Inmueble inmuebleAsociado;

    public ImageIcon getImagen() {
        return imagen;
    }

    public void setImagen(ImageIcon imagen) {
        this.imagen = imagen;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Inmueble getInmuebleAsociado() {
        return inmuebleAsociado;
    }

    public void setInmuebleAsociado(Inmueble inmuebleAsociado) {
        this.inmuebleAsociado = inmuebleAsociado;
    }
}
