package GUI;

import javax.swing.*;

public class Panel extends JPanel {
    protected String titulo;

    public Panel(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }
}
