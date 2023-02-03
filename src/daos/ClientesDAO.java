/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import objetos_negocios.Cliente;

/**
 *
 * @author Gilberto Verdugo
 */
public class ClientesDAO extends BaseDAO<Cliente> {

    @Override
    public ArrayList<Cliente> cosultar() {
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        try {
            Connection conexion = this.generarConexion();
            Statement comando = conexion.createStatement();
            String codigoSQL = "SELECT id_cliente, nombre, direccion,telefono FROM clientes";
            ResultSet resultado = comando.executeQuery(codigoSQL);
            while (resultado.next()) {
                Integer id_cliente = resultado.getInt("id");
                String nombre = resultado.getString("nombre");
                String direccion = resultado.getString("direccion");
                String telefono = resultado.getString("telefono");
                Cliente cliente = new Cliente(id_cliente, nombre, direccion, telefono);
                listaClientes.add(cliente);
            }
            conexion.close();
            System.out.println("se consultaron los clientes");

            return listaClientes;
        } catch (SQLException ex) {

            System.err.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public void insertar(Cliente cliente) {
        try {
            Connection conexion = this.generarConexion();
            Statement comando = conexion.createStatement();
            String codigoSQL = String.format("INSERT INTO clientes(nombre,direccion,telefono)"
                    + "VALUES ('%s','%s','%s')",
                    cliente.getNombre(),
                    cliente.getDireccion(),
                    cliente.getTelefono());
            comando.executeUpdate(codigoSQL);
            conexion.close();
            System.out.println("Cliente se registro correctamente");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void actualizar(Cliente cliente) throws Exception {
        if (cliente.getId_cliente() == null) {
            throw new Exception("id cliente no encontrado");
        }
        try {
            Connection conexion = this.generarConexion();
            Statement comando = conexion.createStatement();
            String codigoSQL = String.format("UPDATE clientes SET nombre='%s',direccion='%s',telefono='%s' WHERE id=%d",
                    cliente.getNombre(),
                    cliente.getDireccion(),
                    cliente.getTelefono(),
                    cliente.getId_cliente());
            int conteoRegistrosAfectados = comando.executeUpdate(codigoSQL);
            if (conteoRegistrosAfectados == 1) {
                System.out.println("se actualizo el cliente");
            } else {
                System.out.println("no se pudo actulizar el cliente");
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public Cliente consultarPorId(Integer id) {
        Cliente cliente = null;
        try {
            Connection conexion = this.generarConexion();
            Statement comando = conexion.createStatement();
            String codigoSQL = String.format("SELECT id_cliente, nombre, direccion,telefono FROM clientes WHERE id = %d", id);
            ResultSet resultado = comando.executeQuery(codigoSQL);
            if (resultado.next()) {
                Integer id_cliente = resultado.getInt("id");
                String nombre = resultado.getString("nombre");
                String direccion = resultado.getString("direccion");
                String telefono = resultado.getString("telefono");
                cliente = new Cliente(id_cliente, nombre, direccion, telefono);

            }
            conexion.close();
            System.out.println("se consulto el cliente");

            return cliente;
        } catch (SQLException ex) {

            System.err.println(ex.getMessage());
            return cliente;
        }

    }

    @Override
    public void eliminar(Integer id) {
        try {
            Connection conexion = this.generarConexion();
            Statement comando = conexion.createStatement();
            String codigoSQL = String.format("DELETE FROM clientes WHERE id = %d", id);
            int conteoRegistrosAfectados = comando.executeUpdate(codigoSQL);
            if (conteoRegistrosAfectados == 1) {
                System.out.println("se elimino el cliente" + id);
            }
            conexion.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

}
