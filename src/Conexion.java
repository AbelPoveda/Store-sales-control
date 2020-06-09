import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Conexion {
    private static String miConex = "jdbc:mysql://localhost:3306/fruteria?useSSL=false";
    private static String miPass = "root";
    private static String miUser = "root";

    public static ArrayList sacarproductos(String sql) {
        ArrayList<String> productos = new ArrayList<>();
        try {
            Connection miconexion = DriverManager.getConnection(miConex, miUser, miPass);
            Statement miStat = miconexion.createStatement();
            ResultSet miResul = miStat.executeQuery(sql);
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

    public static double sacarprecio(String producto) {
        double precio;
        ArrayList<String> productos = new ArrayList<>();
        try {
            Connection miconexion = DriverManager.getConnection(miConex, miUser, miPass);
            Statement miStat = miconexion.createStatement();
            ResultSet miResul = miStat.executeQuery("SELECT precio FROM productos WHERE nombre='"+ producto +"'");
            while (miResul.next()) {
                productos.add(miResul.getString("precio"));
            }
            precio = Double.parseDouble(productos.get(0));
            miconexion.close();
            return precio;
        } catch (Exception e) {
            System.out.println("error conexion: " + e);
            return 0.0;
        }
    }
    public static int sacarunidades(String producto) {
        int unidades;
        ArrayList<String> productos = new ArrayList<>();
        try {
            Connection miconexion = DriverManager.getConnection(miConex, miUser, miPass);
            Statement miStat = miconexion.createStatement();
            ResultSet miResul = miStat.executeQuery("SELECT cantidad FROM productos WHERE nombre='"+ producto +"'");
            while (miResul.next()) {
                productos.add(miResul.getString("cantidad"));
            }
            unidades = Integer.parseInt(productos.get(0));
            miconexion.close();
            return unidades;
        } catch (Exception e) {
            System.out.println("error conexion: " + e);
            return 0;
        }
    }
}
