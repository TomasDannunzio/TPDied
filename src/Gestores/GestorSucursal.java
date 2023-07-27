package Gestores;

import java.sql.*;
import java.time.LocalTime;

import POJO.Sucursal;

public class GestorSucursal {
	
	public static GestorSucursal gestor;
	
	public static GestorSucursal getInstance() {
		if(gestor==null) {
			gestor = new GestorSucursal();
		}
		return gestor;
	}
	
	public Sucursal getSucursalById(int i) throws Exception{
		Sucursal s = null;
        try {
            // below two lines are used for connectivity.
        	Connection connection = ConexionBDD.getConnection();
            Statement statement;
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                "select * from sucursal where sucursal_id ="+i+"");
       
            while (resultSet.next()) {
               s = new Sucursal(resultSet.getInt("sucursal_id"),
            		   resultSet.getString("nombre"),
            		   resultSet.getTime("horarioApertura").toLocalTime(),
            		   resultSet.getTime("horarioCierre").toLocalTime(),
            		   resultSet.getBoolean("operativa")
            		   );
            }
            
            resultSet.close();
            statement.close();
            connection.close();
        }
        catch (Exception exception) {
            System.out.println(exception);
        }
        
        return s;
        
	}
	

	public Sucursal createSucursal(int id, String nombre, LocalTime horarioApertura, 
			LocalTime horarioCierre, boolean operativa) {
		
		Sucursal s = new Sucursal(id,nombre,horarioApertura,horarioCierre,operativa);

		try {
		persistSucursal(s);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("No se ha podido persistir");
		}
		
		return s;

	}
	
	public void persistSucursal(Sucursal s) throws Exception{
		
		try {
			System.out.println("Entré");
            // below two lines are used for connectivity.
			Connection connection = ConexionBDD.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into sucursal(id, nombre, horarioApertura, horarioCierre, operativa) values(?, ?, ?, ?, ?)");
			preparedStatement.setInt(1, s.getId());
			preparedStatement.setString(2, s.getNombre());
			preparedStatement.setTime(3, Time.valueOf(s.getHorarioApertura()));
			preparedStatement.setTime(4, Time.valueOf(s.getHorarioCierre()));
			preparedStatement.setBoolean(5, s.isOperativa());
            
			preparedStatement.executeUpdate();
			
            preparedStatement.close();
            connection.close();
        }
        catch (Exception exception) {
            System.out.println(exception);
        }
		
	}

public static void deleteSucursal(int id) throws Exception{
	
	try {
        // below two lines are used for connectivity.
		Connection connection = ConexionBDD.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("Delete from Sucursal where id_sucursal = "+id);
		preparedStatement.executeUpdate();
		
        preparedStatement.close();
        connection.close();
    }
    catch (Exception exception) {
        System.out.println(exception);
    }
	
}

public Sucursal getSucursalByNombre(String nombre) throws Exception{
	Sucursal s = null;
    try {
        // below two lines are used for connectivity.
    	Connection connection = ConexionBDD.getConnection();
        Statement statement;
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(
            "select * from sucursal where nombre ="+nombre+"");
   
        while (resultSet.next()) {
           s = new Sucursal(resultSet.getInt("sucursal_id"),
        		   resultSet.getString("nombre"),
        		   resultSet.getTime("horarioApertura").toLocalTime(),
        		   resultSet.getTime("horarioCierre").toLocalTime(),
        		   resultSet.getBoolean("operativa")
        		   );
        }
        
        resultSet.close();
        statement.close();
        connection.close();
    }
    catch (Exception exception) {
        System.out.println(exception);
    }
    
    return s;
    
}

public Sucursal getSucursal(int i, String nombre) throws Exception{
	Sucursal s = null;
    try {
        // below two lines are used for connectivity.
    	Connection connection = ConexionBDD.getConnection();
        Statement statement;
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(
            "select * from sucursal where sucursal_id ="+i+" and nombre="+nombre+"");
   
        while (resultSet.next()) {
           s = new Sucursal(resultSet.getInt("sucursal_id"),
        		   resultSet.getString("nombre"),
        		   resultSet.getTime("horarioApertura").toLocalTime(),
        		   resultSet.getTime("horarioCierre").toLocalTime(),
        		   resultSet.getBoolean("operativa")
        		   );
        }
        
        resultSet.close();
        statement.close();
        connection.close();
    }
    catch (Exception exception) {
        System.out.println(exception);
    }
    
    return s;
    
}



}
