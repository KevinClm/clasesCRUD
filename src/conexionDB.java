import java.sql.*;
import java.sql.DriverManager;

public class conexionDB {
    String host, user, password; //Datos para acceder a la base de datos
    String mensaje;
    /*Constructor*/
    public conexionDB(String host, String user, String password){
        this.host = host;
        this.user = user;
        this.password = password;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /*Constructor vacio*/
    public conexionDB(){

    }
    public void conexionLocal(String host, String user, String password){
        try (Connection connection = DriverManager.getConnection(host, user, password)) {
            if(connection != null){
                mensaje = "Conexión correcta";
                System.out.println(mensaje);
            }else {
                mensaje="";
                System.out.println(mensaje);
            }
        }
        catch (SQLException e){
            /*System.out.println(e);
            mensaje = "Algo salió mal :(";
            System.out.println(mensaje);*/
        }catch (Exception ex){
            ex.getMessage();
        }
    }
}
