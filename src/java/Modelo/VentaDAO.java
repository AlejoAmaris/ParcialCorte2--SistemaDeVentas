package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VentaDAO{
    Conexion c = new Conexion();
    Connection con = c.conexion();
    PreparedStatement ps = null;
    ResultSet rs = null;
    int r;
    
    public String generarSerie(){
        String noSerie = null;
        
        try{
            ps = con.prepareStatement("SELECT MAX(NumeroSerie) FROM Ventas");
            rs = ps.executeQuery();
            
            while(rs.next())
                noSerie = rs.getString(1);
        } 
        catch(Exception e){
            System.out.println("ERROR al leer la tabla Ventas\n"+e);
        }
        
        return noSerie;
    }
}
