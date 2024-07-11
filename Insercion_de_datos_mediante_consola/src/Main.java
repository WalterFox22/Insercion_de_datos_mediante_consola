import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el nombre del estudiante: ");
        String nombre= sc.nextLine();
        System.out.println("Ingrese el numero de cedula del estudiante: ");
        String cedula= sc.nextLine();
        System.out.println("Ingrese la nota del primer bimestre: ");
        double b1= sc.nextDouble();
        System.out.println("Ingrese la nota del segundo bimestre: ");
        double b2= sc.nextDouble();

        Estudiante estudiante = new Estudiante(nombre,cedula,b1,b2);

        String url="jdbc:mysql://localhost:3306/ESTUDIANTE";
        String user="root";
        String password="123456";

        String sql = "INSERT INTO estudiante (cedula, nombre, b1, b2) VALUES (?, ?, ?, ?)";



        try (Connection connection= DriverManager.getConnection(url,user,password)){
            PreparedStatement cadenaPreparada = connection.prepareStatement(sql);

            cadenaPreparada.setString(1, estudiante.getNombre());
            cadenaPreparada.setString(2, estudiante.getCedula());
            cadenaPreparada.setDouble(3,estudiante.getB1());
            cadenaPreparada.setDouble(4, estudiante.getB2());
            cadenaPreparada.executeUpdate();

            System.out.println("Se ha registrado la estudiante");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }}


