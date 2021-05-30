/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joansanchezuf6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author Joan
 */
public class JoanSanchezUF6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int opcion;
        Connection conn;
        conn = ConexionDB.GetConnection();

        if (conn != null) {
            System.out.println("Connexió correcta");
        }
        System.out.println("1.Select");
        System.out.println("2.Insert");
        System.out.println("3.Update");
        System.out.println("4.Eliminar");

        opcion = Teclado.leerInt("Escull la acció:");
        try {
            switch (opcion) {
                case 1:

                    Serie s = getSerie(conn);
                    if (s != null) {
                        System.out.println(s.toString());
                    } else {
                        System.out.println("No s'ha trobat la sèrie sol·licitada");
                    }
                    break;
                case 2:
                    insertSerie(conn);
                    break;
                case 3:
                    updateSerie(conn);
                    break;
                case 4:
                    removeSerie(conn);
                    break;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static Serie getSerie(Connection conn) throws SQLException {
        Serie s = new Serie();
        PreparedStatement ps;
        try {
            String nombre = Teclado.leerString("Introdueix el nom de la serie a buscar");
            //Make query
            String query = "select * from serie where nombre='" + nombre + "'";
            ps = conn.prepareStatement(query);

            //Get results
            ResultSet rs = ps.executeQuery(query);
            if (rs.next()) {
                s.setNombre(rs.getString("nombre"));
                s.setTemporadas(rs.getInt("temporadas"));
                s.setGenero(rs.getString("genero"));
                s.setGasto(rs.getFloat("gasto"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

        return s;
    }

    public static void insertSerie(Connection conn) throws SQLException {
        PreparedStatement ps;
        try {
            String nombre = Teclado.leerString("Introdueix el nom de la serie a insertar\n");
            int numTemporadas=Teclado.leerInt("Introdueix el nombre de temporades de la serie a insertar \n");
            String genero=Teclado.leerString("Introdueix el genere de la serie a insertar \n");
            float gasto=Teclado.leerFloat("Introdueix el cost de la serie a insertar\n");
            
            //Execute query
            String query = "insert into serie (nombre, temporadas, genero, gasto) values ('"+nombre+"','"+numTemporadas+"','"+genero+"','"+gasto+"')";
            ps = conn.prepareStatement(query);
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public static void updateSerie(Connection conn) throws SQLException {
        PreparedStatement ps;
        
        try {
            String nombre=Teclado.leerString("Introdueix el nom de la serie a modificar\n");
            
            int temporadas=Teclado.leerInt("Introdueix el nou nombre de temporades\n");

            //Execute query
            String query = "update serie set temporadas='"+temporadas+"'where nombre='"+nombre+"'";
            
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public static void removeSerie(Connection conn) throws SQLException {
        PreparedStatement ps;
        try {
            String nombre = Teclado.leerString("Introdueix el nom de la serie a insertar\n");
            
            //Execute query
            String query = "delete from serie where nombre='"+nombre+"'";
            ps = conn.prepareStatement(query);
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
}
