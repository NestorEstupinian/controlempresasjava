package controlempresas.entidadesdenegocio;

import java.util.ArrayList;


public class Rol {
    private int id;
    private int nombre;
    private int top_aux;
    private ArrayList<Usuario> usuario;
    
    public Rol() {
    }

    public Rol(int id, int nombre, int top_aux, ArrayList<Usuario> usuario) {
        this.id = id;
        this.nombre = nombre;
        this.top_aux = top_aux;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public int getTop_aux() {
        return top_aux;
    }

    public void setTop_aux(int top_aux) {
        this.top_aux = top_aux;
    }

    public ArrayList<Usuario> getUsuario() {
        return usuario;
    }

    public void setUsuario(ArrayList<Usuario> usuario) {
        this.usuario = usuario;
    }
    
    
}
