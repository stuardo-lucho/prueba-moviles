package moviles.apps.miprimeraapp;

import java.io.Serializable;

public class Curso implements Serializable {

    private String nombre;

    public Curso(String nombre) {
        this.nombre = nombre;
    }

    public Curso() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
