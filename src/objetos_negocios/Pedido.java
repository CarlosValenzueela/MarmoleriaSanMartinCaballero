/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos_negocios;

/**
 *
 * @author Gilberto Verdugo
 */
public class Pedido {
    private Integer id_lugar;
    private String nombre;
    private String direccion;      
    private Float latitud;
    private Float longitud;   

    public Pedido(Integer id_lugar, String nombre, String direccion) {
        this.id_lugar = id_lugar;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Pedido(Integer id_lugar, String nombre, String direccion, Float latitud, Float longitud) {
        this.id_lugar = id_lugar;
        this.nombre = nombre;
        this.direccion = direccion;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public Pedido(Integer id_lugar) {
        this.id_lugar = id_lugar;
    }

    
    public Pedido(String nombre, String direccion, Float latitud, Float longitud) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public Integer getId_lugar() {
        return id_lugar;
    }

    public void setId_lugar(Integer id_lugar) {
        this.id_lugar = id_lugar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Float getLatitud() {
        return latitud;
    }

    public void setLatitud(Float latitud) {
        this.latitud = latitud;
    }

    public Float getLongitud() {
        return longitud;
    }

    public void setLongitud(Float longitud) {
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return "Lugar{" + "id_lugar=" + id_lugar + ", nombre=" + nombre + ", direccion=" + direccion + ", latitud=" + latitud + ", longitud=" + longitud + '}';
    }

    
}
