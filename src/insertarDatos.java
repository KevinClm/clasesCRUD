import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertarDatos {
    String nombre, cedula;
    int nota1, nota2;

    public insertarDatos(String nombre, String cedula, int nota1, int nota2) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }
    public insertarDatos(){}
    public void ingresoDatos(String nombre, String cedula, int nota1, int nota2){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/estudiantes", "root", "");
            String sql = "INSERT INTO calificaciones(nombre, cedula, calificacion1, calificacion2) values (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setString(1, nombre);
                preparedStatement.setString(2, cedula);
                preparedStatement.setInt(3, nota1);
                preparedStatement.setInt(4, nota2);
                int filasAfectadas = preparedStatement.executeUpdate();
                if (filasAfectadas>0){
                    System.out.println("Ingresado con éxito");
                }
                else {
                    System.out.println("Fallo al ingresar");
                }
            }catch (Exception exception){
                exception.getMessage();
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
