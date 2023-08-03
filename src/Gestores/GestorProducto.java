package Gestores;
import POJO.Producto;
import POJO.Sucursal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;

import POJO.Producto;

public class GestorProducto {
public static GestorProducto gestorProducto;
	
	public static GestorProducto getInstance() {
		if(gestorProducto==null) {
			gestorProducto = new GestorProducto();
		}
		return gestorProducto;
	}
	public Producto getProductoById(int i) throws Exception{
		Producto p = null;
        try {
            // below two lines are used for connectivity.
        	Connection connection = ConexionBDD.getConnection();
            Statement statement;
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                "select * from producto where producto_id ="+i+"");
       
            while (resultSet.next()) {
               p = new Producto(resultSet.getInt("producto_id"),
            		   resultSet.getString("nombre"),
            		   resultSet.getString("descripcion"),
            		   resultSet.getFloat("Precio"),
            		   resultSet.getFloat("Peso"));
            }
            
            resultSet.close();
            statement.close();
            connection.close();
        }
        catch (Exception exception) {
            System.out.println(exception);
        }
        
        return p;
        
	}
	public Producto getProductoByNombre(String nom) throws Exception{
		Producto p = null;
	    try {
	        // below two lines are used for connectivity.
	    	Connection connection = ConexionBDD.getConnection();
	        Statement statement;
	        statement = connection.createStatement();
	        ResultSet resultSet = statement.executeQuery(
	            "select * from producto where nombre = \"" + nom+"\"");
	   
	        while (resultSet.next()) {
	               p = new Producto(resultSet.getInt("producto_id"),
	            		   resultSet.getString("nombre"),
	            		   resultSet.getString("descripcion"),
	            		   resultSet.getFloat("Precio"),
	            		   resultSet.getFloat("Peso"));
	            }
	        
	        resultSet.close();
	        statement.close();
	        connection.close();
	    }
	    catch (Exception exception) {
	        System.out.println(exception);
	    }
	    
	    return p;
	    
	}	
	
	
	
	public Producto createProducto(int id, String nombre, String descripcion, 
			Float precio, Float peso) throws Exception {
		
		Producto p = new Producto(id,nombre,descripcion,precio,peso);
		ArrayList <Sucursal> s = GestorSucursal.getInstance().getAllSucursal();
		try {
		persistProducto(p);
		persistStock(p,s);
		} catch(Exception e) {
			//e.printStackTrace();
			//System.out.println("No se ha podido persistir");
			throw new Exception();
		}
		
		return p;

	}
	
public void persistStock(Producto p, ArrayList<Sucursal> s ) throws Exception{
		
		try {
			System.out.println("Entré");
            // below two lines are used for connectivity.
			Connection connection = ConexionBDD.getConnection();
            
            s.stream().forEach( t -> {
				try {
					PreparedStatement preparedStatement = connection.prepareStatement("insert into Stock(Producto_id, Sucursal_id, cantidad) values(?, ?, 0)");
					preparedStatement.setInt(1, p.getId());
					preparedStatement.setInt(2, t.getId());
					preparedStatement.executeUpdate();
		            preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
           
            connection.close();
        }
        catch (Exception exception) {
            //System.out.println(exception);
        	throw new Exception();
        }
		
	}
	
public void persistProducto(Producto p) throws Exception{
		
		try {
			System.out.println("Entré");
            // below two lines are used for connectivity.
			Connection connection = ConexionBDD.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into Producto(Producto_id, nombre, descripcion, precio, peso) values(?, ?, ?, ?, ?)");
			preparedStatement.setInt(1, p.getId());
			preparedStatement.setString(2, p.getNombre());
			preparedStatement.setString(3, p.getDescripcion());
			preparedStatement.setFloat(4, p.getPrecio());
			preparedStatement.setFloat(5, p.getPeso());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        }
        catch (Exception exception) {
            //System.out.println(exception);
        	throw new Exception();
        }
		
	}
public void deleteProducto(int id) throws Exception{
	
	try {
        // below two lines are used for connectivity.
		Connection connection = ConexionBDD.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("Delete from Producto where producto_id= "+id);
		preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }
    catch (Exception exception) {
        System.out.println(exception);
    }
	
}
public void updateProducto(int id, String nombre, String descripcion,
		float precio, float peso) {
	
	try {
        // below two lines are used for connectivity.
		Connection connection = ConexionBDD.getConnection();
		
		String finalQuery = "UPDATE Producto SET ";
		
		String nombreQuery = "nombre = \"" + nombre + "\"";
		
		String descripcionQuery = ",descripcion = \"" + descripcion+"\"";
		
		String precioQuery = ",precio = \"" + precio+"\"";
		
		String pesoQuery = ",peso = \"" + peso+"\"";;
        
		
        finalQuery += nombreQuery+descripcionQuery+precioQuery+pesoQuery;
        
		finalQuery += " WHERE Producto_ID= "+id+";";
		
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
public ArrayList<Producto> getProducto(Integer id, String nom) throws Exception{
	Producto p = null;
	
	ArrayList<Producto> lista = new ArrayList<Producto>();
	
    try {
        // below two lines are used for connectivity.
    	Connection connection = ConexionBDD.getConnection();
        Statement statement;
        statement = connection.createStatement();
        
        String idQuery= "Producto_id = " + id;
        String nombreQuery = "nombre = \"" + nom+"\"";
        
        String queryFinal = "select * from Producto where ";
        
        boolean checkid = false;
        
        if(id != null) {queryFinal += idQuery; checkid = true;}
        if(!nom.equals("")) {if(checkid) queryFinal = queryFinal + " AND " + nombreQuery; else queryFinal += nombreQuery;}
        
        queryFinal += ";";
        
        System.out.println(queryFinal);
        
        ResultSet resultSet = statement.executeQuery(queryFinal);
        
        while (resultSet.next()) {
            p = new Producto(resultSet.getInt("producto_id"),
         		   resultSet.getString("nombre"),
         		   resultSet.getString("descripcion"),
         		   resultSet.getFloat("Precio"),
         		   resultSet.getFloat("Peso"));
            		lista.add(p);
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
public ArrayList<Producto> getAllProducto() throws Exception{
	Producto p = null;
	ArrayList<Producto> lista = new ArrayList<Producto>();
    try {
        // below two lines are used for connectivity.
    	Connection connection = ConexionBDD.getConnection();
        Statement statement;
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(
            "select * from Producto");
        
        while (resultSet.next()) {
            p = new Producto(resultSet.getInt("producto_id"),
         		   resultSet.getString("nombre"),
         		   resultSet.getString("descripcion"),
         		   resultSet.getFloat("Precio"),
         		   resultSet.getFloat("Peso"));
            lista.add(p);
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
