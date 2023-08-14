package controlempresas.entidadesdenegocio;

import java.util.ArrayList;


public class Rol {
    private int id;
    private String Nombre;
    private int top_aux;
    private ArrayList<Usuario> usuario;

    public Rol() {
    }

    public Rol(int id, String Nombre, int top_aux, ArrayList<Usuario> usuario) {
        this.id = id;
        this.Nombre = Nombre;
        this.top_aux = top_aux;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
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
