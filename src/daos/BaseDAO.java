package daos;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class BaseDAO<T> {

    private static final String CADENA_CONEXION = "jdbc:mysql://127.0.0.1:3306/sistema_inventario?allowPublicKeyRetrieval=true&useSSL=false&autoReconnet=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String CONTRASEÑA = "1234";

    protected java.sql.Connection generarConexion() throws SQLException {
        return DriverManager.getConnection(CADENA_CONEXION, USUARIO, CONTRASEÑA);
    }

    public abstract ArrayList<T> cosultar();

    public abstract void insertar(T entidad);

    public abstract void actualizar(T entidad) throws Exception;

    public abstract T consultarPorId(Integer id);

    public abstract void eliminar(Integer id);
}
