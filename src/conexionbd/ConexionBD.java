/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionbd;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

/**
 *
 * @author Guille
 */
public class ConexionBD {

    public static void CargaDatos() {
        try {
            // Cargar el driver y establecer la conexion.
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion= DriverManager.getConnection("jdbc:mysql://localhost/mediamarkt", "alumno", "alumno");
            // creamos statement 
            Statement s=conexion.createStatement();
            // trabajo con las consultas
            ResultSet rs=s.executeQuery("select Id, Nombre, Precio from productos");
            while(rs.next()==true){
                System.out.println(rs.getInt("Id")+" "+rs.getString("Nombre")+" "+rs.getFloat("Precio"));
            }
            rs.close();
            s.close();
            conexion.close();
        } catch (Exception ex) {
          ex.printStackTrace();
        }
    }
    public static void main(String[] args)  {
       CargaDatos();
    }
    
}
