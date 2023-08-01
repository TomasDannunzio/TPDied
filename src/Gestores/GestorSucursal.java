package Gestores;

import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;

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
            PreparedStatement preparedStatement = connection.prepareStatement("insert into sucursal(sucursal_id, nombre, horarioApertura, horarioCierre, operativa) values(?, ?, ?, ?, ?)");
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

public void deleteSucursal(int id) throws Exception{
	
	try {
        // below two lines are used for connectivity.
		Connection connection = ConexionBDD.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("Delete from Sucursal where sucursal_id = "+id);
		preparedStatement.executeUpdate();
		
        preparedStatement.close();
        connection.close();
    }
    catch (Exception exception) {
        System.out.println(exception);
    }
	
}

public Sucursal getSucursalByNombre(String nom) throws Exception{
	Sucursal s = null;
    try {
        // below two lines are used for connectivity.
    	Connection connection = ConexionBDD.getConnection();
        Statement statement;
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(
            "select * from sucursal where nombre = \"" + nom+"\"");
   
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

public ArrayList<Sucursal> getSucursal(Integer id, String nom, String horarioApertura, String horarioCierre, boolean operativa) throws Exception{
		Sucursal s = null;
		
		ArrayList<Sucursal> lista = new ArrayList<Sucursal>();
		
	    try {
	        // below two lines are used for connectivity.
	    	Connection connection = ConexionBDD.getConnection();
	        Statement statement;
	        statement = connection.createStatement();
	        
	        String idQuery= "sucursal_id = " + id;
	        String nombreQuery = "nombre = \"" + nom+"\"";
	        String horarioAperturaQuery = "horarioapertura = \"" + horarioApertura +"\"";
	        String horarioCierreQuery = "horariocierre = \"" + horarioCierre +"\"";
	        
	        String operativaQuery = null;
	        
	        if(operativa) operativaQuery = "operativa = true"; else operativaQuery = "operativa = false";
	        
	        String queryFinal = "select * from sucursal where ";
	        
	        int sum = 0;
	        
	        if(id != null) {queryFinal += idQuery; sum++;}
	        if(!nom.equals("")) {if(sum>0) queryFinal = queryFinal + " AND " + nombreQuery; else queryFinal += nombreQuery; sum++;}
	        if(!horarioApertura.equals("")) {if(sum>0) queryFinal = queryFinal + " AND " + horarioAperturaQuery; 
	        else queryFinal += horarioAperturaQuery; sum++;}
	        if(!horarioCierre.equals("")) {if(sum>0) queryFinal = queryFinal + " AND " + horarioCierreQuery; 
	        else queryFinal += horarioCierreQuery; sum++;}
	        if(sum>0) queryFinal = queryFinal + " AND " + operativaQuery; else queryFinal += operativaQuery;
	        
	        queryFinal += ";";
	        
	        System.out.println(queryFinal);
	        
	        ResultSet resultSet = statement.executeQuery(queryFinal);
	        
	        while (resultSet.next()) {
	           s = new Sucursal(resultSet.getInt("sucursal_id"),
	        		   resultSet.getString("nombre"),
	        		   resultSet.getTime("horarioApertura").toLocalTime(),
	        		   resultSet.getTime("horarioCierre").toLocalTime(),
	        		   resultSet.getBoolean("operativa")
	        		   );
	           
	           lista.add(s);
	           
	        }
	        
	        resultSet.close();
	        statement.close();
	        connection.close();
	    }
	    catch (Exception exception) {
	        System.out.println(exception);
	    }
	    
	    return lista;
	    
	}

public void updateSucursal(int id, String nombre, LocalTime horarioApertura,
		LocalTime horarioCierre, boolean operativa) {
	
	try {
        // below two lines are used for connectivity.
		Connection connection = ConexionBDD.getConnection();
		
		String finalQuery = "UPDATE SUCURSAL SET ";
		
		String nombreQuery = "nombre = \"" + nombre + "\"";
		
		String horarioAperturaQuery = ",horarioapertura = \"" + horarioApertura.toString()+"\"";
		
		String horarioCierreQuery = ",horariocierre = \"" + horarioCierre.toString()+"\"";
		
		String operativaQuery = null;
        
        if(operativa) operativaQuery = ",operativa = true"; else operativaQuery = ",operativa = false";
		
        finalQuery += nombreQuery+horarioAperturaQuery+horarioCierreQuery+operativaQuery;
        
		finalQuery += " WHERE SUCURSAL_ID= "+id+";";
		
        PreparedStatement preparedStatement = connection.
        		prepareStatement(finalQuery);
		
        preparedStatement.executeUpdate();
		
        preparedStatement.close();
        connection.close();
    }
    catch (Exception exception) {
        System.out.println(exception);
    }
	
}

public ArrayList<Sucursal> getAllSucursal() throws Exception{
	Sucursal s = null;
	ArrayList<Sucursal> lista = new ArrayList<Sucursal>();
    try {
        // below two lines are used for connectivity.
    	Connection connection = ConexionBDD.getConnection();
        Statement statement;
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(
            "select * from sucursal");
        
        while (resultSet.next()) {
           s = new Sucursal(resultSet.getInt("sucursal_id"),
        		   resultSet.getString("nombre"),
        		   resultSet.getTime("horarioApertura").toLocalTime(),
        		   resultSet.getTime("horarioCierre").toLocalTime(),
        		   resultSet.getBoolean("operativa")
        		   );
           
           lista.add(s);
           
        }
        
        resultSet.close();
        statement.close();
        connection.close();
    }
    catch (Exception exception) {
        System.out.println(exception);
    }
    
    return lista;
    
}


}
