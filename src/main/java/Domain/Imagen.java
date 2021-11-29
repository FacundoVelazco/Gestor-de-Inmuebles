package Domain;



import javax.persistence.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.awt.*;



@Entity
@Table(name = "imagen")
public class Imagen {


    @Id
    @Column(name = "id_imagen")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Lob
    @Column(name = "imagen")
    private byte[] imagen;

    @Column(name = "descripcion")
    private String nombreArchivo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_inmueble")
    private Inmueble inmuebleAsociado;

    private BufferedImage toBufferedImage(Image im){
        BufferedImage bi = new BufferedImage(im.getWidth(null),im.getHeight(null),BufferedImage.TYPE_INT_RGB);
        Graphics bg = bi.getGraphics();
        bg.drawImage(im, 0, 0, null);
        bg.dispose();
        return bi;
    }


    public ImageIcon getImagen() {
        return new ImageIcon(imagen);
    }

    public void setImagen(ImageIcon imagen) throws Exception { //TODO anda a saber si esto anda XD
        BufferedImage buffered = toBufferedImage(imagen.getImage());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(buffered, "jpg", baos);
        this.imagen = baos.toByteArray();
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

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Imagen){
            return ((Imagen) obj).getNombreArchivo() == this.nombreArchivo;
        }

        return super.equals(obj);
    }

}
