package daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import objetos_negocios.Inventario;

//public class PedidosDAO extends BaseDAO<Inventario>{
//
//    @Override
//    public ArrayList<Inventario> cosultar() {
//        ArrayList<Inventario> listaEventos = new ArrayList<>();
//        try
//        {
//            Connection conexion = this.generarConexion();
//            Statement comando = conexion.createStatement();
//            String codigoSQL= "SELECT id_evento, nombre, fecha_hora, numero_asistentes, id_cliente, id_lugar FROM eventos";
//            ResultSet resultado = comando.executeQuery(codigoSQL);
//            while(resultado.next())
//            {
//                Integer id_evento=resultado.getInt("id_evento");
//                String nombre = resultado.getString("nombre");
//                String fecha_hora = resultado.getString("fecha_hora");
//                Integer numero_asistentes=resultado.getInt("numero_asistentes");
//                Integer id_cliente=resultado.getInt("id_cliente");
//                Integer id_lugar=resultado.getInt("id_lugar");
//                Inventario evento = new Inventario(id_evento, nombre, fecha_hora, numero_asistentes, id_cliente, id_lugar);
//                listaEventos.add(evento);
//            }
//            conexion.close();
//            System.out.println("se consultaron los eventos");
//            
//            return listaEventos;
//        }
//        catch(SQLException ex)
//        {
//
//            System.err.println(ex.getMessage());
//        }
//        return null;
//    }
//    
//
//    @Override
//    public void insertar(Inventario evento) {
//        try{
//            Connection conexion = this.generarConexion();
//            Statement comando = conexion.createStatement();
//            String codigoSQL = String.format("INSERT INTO eventos(nombre,fecha_hora,numero_asistentes,id_cliente, id_lugar)"
//                    + "VALUES ('%s','%s','%s','%s','%s')", 
//                    evento.getNombre(),
//                    evento.getFecha_hora(),
//                    evento.getNumero_asistentes(),
//                    evento.getId_cliente(),
//                    evento.getId_lugar());
//            comando.executeUpdate(codigoSQL);
//            conexion.close();
//            System.out.println("Evento se registro correctamente");
//        }catch(SQLException ex){
//            System.err.println(ex.getMessage());
//        }
//    }
//
//    @Override
//    public void actualizar(Inventario evento) throws Exception {
//        if(evento.getId_evento()== null)
//            {
//                throw new Exception("id evento no encontrado");
//            }
//            try
//            {
//                Connection conexion = this.generarConexion();
//                Statement comando = conexion.createStatement();
//                String codigoSQL = String.format("UPDATE eventos SET nombre='%s',fecha_hora='%s',numero_asistentes='%s',id_cliente='%s', id_lugar='%s' WHERE id_evento=%d",
//                evento.getNombre(),
//                evento.getFecha_hora(),
//                evento.getNumero_asistentes(),
//                evento.getId_cliente(),
//                evento.getId_lugar(),evento.getId_evento());
//                int conteoRegistrosAfectados = comando.executeUpdate(codigoSQL);
//                if (conteoRegistrosAfectados == 1)
//                {
//                    System.out.println("se actualizo el evento");
//                }
//                else
//                {
//                    System.out.println("no se pudo actulizar el evento");
//                }
//                
//            }
//            catch(SQLException ex)
//            {
//                System.err.println(ex.getMessage());
//            }
//    }
//
//    @Override
//    public Inventario consultarPorId(Integer id) {
//        Inventario evento = null;
//        try
//        {
//            Connection conexion = this.generarConexion();
//            Statement comando = conexion.createStatement();
//            String codigoSQL = String.format("SELECT id_evento, nombre, fecha_hora,numero_asistentes, id_cliente, id_lugar FROM eventos WHERE id_evento = %d", id) ;
//            ResultSet resultado = comando.executeQuery(codigoSQL);
//            if(resultado.next())
//            {
//                Integer id_evento=resultado.getInt("id_evento");
//                String nombre = resultado.getString("nombre");
//                String fecha_hora = resultado.getString("fecha_hora");
//                Integer numero_asistentes=resultado.getInt("numero_asistentes");
//                Integer id_cliente=resultado.getInt("id_cliente");
//                Integer id_lugar=resultado.getInt("id_lugar");
//                evento = new Inventario(id_evento, nombre, fecha_hora, numero_asistentes, id_cliente, id_lugar);
//                
//            }
//            conexion.close();
//            System.out.println("se consulto el evento");
//            
//            return evento;
//        }
//        catch(SQLException ex)
//        {
//
//            System.err.println(ex.getMessage());
//            return evento;
//        }
//    }
//
//    @Override
//    public void eliminar(Integer id) {
//       try
//        {
//            Connection conexion = this.generarConexion();
//            Statement comando = conexion.createStatement();
//            String codigoSQL = String.format("DELETE FROM eventos WHERE id_evento = %d", id) ;
//            int conteoRegistrosAfectados = comando.executeUpdate(codigoSQL);
//            if(conteoRegistrosAfectados == 1)
//            {
//                 System.out.println("se elimino el evento" + id);
//            }
//            conexion.close();
//        }
//        catch(SQLException ex)
//        {
//            System.err.println(ex.getMessage());
//        }
//    }
//    
//}
