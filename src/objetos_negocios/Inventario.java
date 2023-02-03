/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos_negocios;

import com.github.lgooddatepicker.components.DatePicker;
import java.sql.Date;
import java.time.LocalDateTime;


/**
 *
 * @author Gilberto Verdugo
 */
public class Inventario {
    private Integer id_inventario;
    private String nombre;
    private String marca;
    private String precio;
    private String cantidad;
    private String tipo;
    private String descripcion;

    public Inventario(Integer id_inventario, String nombre, String marca, String precio, String cantidad, String tipo, String descripcion) {
        this.id_inventario = id_inventario;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public Inventario(String nombre, String marca, String precio, String cantidad, String tipo, String descripcion) {
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    
    
    public Inventario() {
    }

    public Integer getId_inventario() {
        return id_inventario;
    }

    public void setId_inventario(Integer id_inventario) {
        this.id_inventario = id_inventario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Inventario{" + "id_inventario=" + id_inventario + ", nombre=" + nombre + ", marca=" + marca + ", precio=" + precio + ", cantidad=" + cantidad + ", tipo=" + tipo + ", descripcion=" + descripcion + '}';
    }
    
    
    
    
    

}