import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Conexion {
    private static String miConex = "jdbc:mysql://localhost:3306/fruteria";
    private static String miPass = "root";
    private static String miUser = "root";

    public static ArrayList sacarproductos() {
        ArrayList<String> productos = new ArrayList<>();
        try {
            Connection miconexion = DriverManager.getConnection(miConex, miUser, miPass);
            Statement miStat = miconexion.createStatement();
            ResultSet miResul = miStat.executeQuery("SELECT nombre FROM productos");
            while (miResul.next()) {
                productos.add(miResul.getString(1));
            }
            miconexion.close();
            return productos;
        } catch (Exception e) {
            System.out.println("error conexion: " + e);
            return null;
        }
    }
}
