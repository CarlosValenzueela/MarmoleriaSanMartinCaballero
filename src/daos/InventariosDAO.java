package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import objetos_negocios.Inventario;

public class InventariosDAO extends BaseDAO<Inventario> {

    @Override
    public ArrayList<Inventario> cosultar() {
        ArrayList<Inventario> listaInventario = new ArrayList<>();
        try {
            Connection conexion = this.generarConexion();
            Statement comando = conexion.createStatement();
            String codigoSQL = "SELECT id, nombre, marca,precio, cantidad, tipo, descripcion FROM inventario";
            ResultSet resultado = comando.executeQuery(codigoSQL);
            while (resultado.next()) {
                Integer id = resultado.getInt("id");
                String nombre = resultado.getString("nombre");
                String marca = resultado.getString("marca");
                String precio = resultado.getString("precio");
                String cantidad = resultado.getString("cantidad");
                String tipo = resultado.getString("tipo");
                String descripcion = resultado.getString("descripcion");

                Inventario inventario = new Inventario(id, nombre, marca, precio, cantidad, tipo, descripcion);
                listaInventario.add(inventario);
            }
            conexion.close();
            System.out.println("se consultaro el inventario");

            return listaInventario;
        } catch (SQLException ex) {

            System.err.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public Inventario consultarPorId(Integer id) {
        Inventario inventario = null;
        try {
            Connection conexion = this.generarConexion();
            Statement comando = conexion.createStatement();
            String codigoSQL = String.format("SELECT id,nombre, marca,precio, cantidad, tipo, descripcion FROM inventario WHERE id = %d", id);
            ResultSet resultado = comando.executeQuery(codigoSQL);
            if (resultado.next()) {
                Integer id_lugar = resultado.getInt("id");
                String nombre = resultado.getString("nombre");
                String marca = resultado.getString("marca");
                String precio = resultado.getString("precio");
                String cantidad = resultado.getString("cantidad");
                String tipo = resultado.getString("tipo");
                String descripcion = resultado.getString("descripcion");

                inventario = new Inventario(id, nombre, marca, precio, cantidad, tipo, descripcion);

            }
            conexion.close();
            System.out.println("se consulto el inventario");

            return inventario;
        } catch (SQLException ex) {

            System.err.println(ex.getMessage());
            return inventario;
        }

    }

    @Override
    public void eliminar(Integer id) {
        try {
            Connection conexion = this.generarConexion();
            Statement comando = conexion.createStatement();
            String codigoSQL = String.format("DELETE FROM inventario WHERE id = %d", id);
            int conteoRegistrosAfectados = comando.executeUpdate(codigoSQL);
            if (conteoRegistrosAfectados == 1) {
                System.out.println("se elimino el inventario" + id);
            }
            conexion.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void insertar(Inventario entidad) {
        try {
            Connection conexion = this.generarConexion();
            Statement comando = conexion.createStatement();
            String codigoSQL = String.format("INSERT INTO inventario(nombre,marca,precio,cantidad, tipo, descripcion)"
                    + "VALUES ('%s','%s','%s','%s','%s','%s')",
                    entidad.getNombre(),
                    entidad.getMarca(),
                    entidad.getPrecio(),
                    entidad.getCantidad(),
                    entidad.getTipo(),
                    entidad.getDescripcion()
            );
            comando.executeUpdate(codigoSQL);
            conexion.close();
            System.out.println("Inventario se registro correctamente");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void actualizar(Inventario entidad) throws Exception {
        if (entidad.getId_inventario() == null) {
            throw new Exception("id inventario no encontrado");
        }
        try {
            Connection conexion = this.generarConexion();
            Statement comando = conexion.createStatement();
            String codigoSQL = String.format("UPDATE inventario SET  nombre='%s',marca='%s',precio='%s',cantidad='%s',tipo='%s',descripcion='%s' WHERE id=%d",
                    entidad.getNombre(),
                    entidad.getMarca(),
                    entidad.getPrecio(),
                    entidad.getCantidad(),
                    entidad.getTipo(),
                    entidad.getDescripcion(),
                    entidad.getId_inventario());
            int conteoRegistrosAfectados = comando.executeUpdate(codigoSQL);
            if (conteoRegistrosAfectados == 1) {
                System.out.println("se actualizo el inventario");
            } else {
                System.out.println("no se pudo actulizar el inventario");
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public ArrayList<Inventario> consultaEspecifica(String comboBox, String dato) {
        ArrayList<Inventario> listaInventario = new ArrayList<>();
        try {
            Connection conexion = this.generarConexion();
            Statement comando = conexion.createStatement();
            String codigoSQL = "SELECT * FROM inventario WHERE " + comboBox + " LIKE '" + dato + "%'";
            ResultSet resultado = comando.executeQuery(codigoSQL);
            while (resultado.next()) {
                Integer id = resultado.getInt("id");
                String nombre = resultado.getString("nombre");
                String marca = resultado.getString("marca");
                String precio = resultado.getString("precio");
                String cantidad = resultado.getString("cantidad");
                String tipo = resultado.getString("tipo");
                String descripcion = resultado.getString("descripcion");

                Inventario inventario = new Inventario(id, nombre, marca, precio, cantidad, tipo, descripcion);
                listaInventario.add(inventario);
            }
            conexion.close();
            System.out.println("se consulto el inventario");

            return listaInventario;
        } catch (SQLException ex) {

            System.err.println(ex.getMessage());
        }
        return null;
    }

}
