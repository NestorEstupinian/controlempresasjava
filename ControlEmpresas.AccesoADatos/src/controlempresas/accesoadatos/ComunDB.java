package controlempresas.accesoadatos;

import java.sql.*;

public class ComunDB {
    
    //enumerar las opciones de bd
    class TipoDB { 
        static final int SQLSERVER = 1; 
        static final int MYSQL = 2; 
    }
    
    //se especifica con que bd se trabajara
    static int TIPODB = TipoDB.SQLSERVER;
    
    //cadena de conexion
    static String connectionUrlSqlServer = "jdbc:sqlserver://localhost;" //servidor
            + "database=CatalogoEmpresasDB;"
            + "user=JavaUser;"
            + "password=#Modulo16;"
            + "loginTimeout=30;encrypt=false;trustServerCertificate=false"; //si no se establece la conexion en 30 segundos, muestra la excepcion -- encriptacion
    
    //metodo para conectar a la base de datos
    public static Connection obtenerConexion() throws SQLException {
        //que tipo de base de datos se utilizara y registrar el driver
        if(TIPODB == 1){
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            Connection connection = DriverManager.getConnection(connectionUrlSqlServer);
            return connection;
        }
        //si no se puede establecer la conexion nulo
        return null;
    }
    
   
  //clases por si se trabaja con consultas
    public static Statement createStatement(Connection pConn) throws SQLException {
        Statement statement = pConn.createStatement();
        return statement;
    }
   
 // maneja la consulta
    public static PreparedStatement createPreparedStatement(Connection pConn, String pSql) throws SQLException {
        PreparedStatement statement = pConn.prepareStatement(pSql);
        return statement;
    }
    //
    public static ResultSet obtenerResultSet(Statement pStatement, String pSql) throws SQLException {
        ResultSet resultSet = pStatement.executeQuery(pSql);
        return resultSet;
    }
//obtiene una especie de tabla que tiene columnas y filas
    public static ResultSet obtenerResultSet(PreparedStatement pPreparedStatement) throws SQLException {
        ResultSet resultSet = pPreparedStatement.executeQuery();
        return resultSet;
    }
    
    //Ejecutar las conusltas
    public static int ejecutarSQL(String pSql) throws SQLException {
        int result;
        try (Connection connection = obtenerConexion();) { 
            Statement statement = connection.createStatement();
            result = statement.executeUpdate(pSql);
        } catch (SQLException ex) {
            throw ex;
        }
        return result;
    }    

    //
class utilQuery{
    private String SQL;
    private PreparedStatement statement;
    private int numWhere;

    public utilQuery() {
    }

    public utilQuery(String SQL, PreparedStatement statement, int numWhere) {
        this.SQL = SQL;
        this.statement = statement;
        this.numWhere = numWhere;
    }

    public String getSQL() {
        return SQL;
    }

    public void setSQL(String SQL) {
        this.SQL = SQL;
    }

    public PreparedStatement getStatement() {
        return statement;
    }

    public void setStatement(PreparedStatement statement) {
        this.statement = statement;
    }

    public int getNumWhere() {
        return numWhere;
    }

    public void setNumWhere(int numWhere) {
        this.numWhere = numWhere;
    }
    
    public void AgregarNumWhere(String pSql){
        if(this.SQL != null){
            if(this.numWhere == 0)
                this.SQL += " WHERE ";
            else
                this.SQL += " AND ";
            
            this.SQL += pSql;
        }
        this.numWhere++;
    }
}
    
}