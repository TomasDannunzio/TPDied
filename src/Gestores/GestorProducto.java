package Gestores;
import POJO.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;

import POJO.Sucursal;

public class GestorProducto {
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
public static void createProducto(Producto p) throws Exception{
		
		try {
            // below two lines are used for connectivity.
			Connection connection = ConexionBDD.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into producto(id_producto, nombre, descripcion, peso) values(?, ?, ?, ?)");
			preparedStatement.setInt(1, p.getProducto_id());
			preparedStatement.setString(2, p.getNombre());
			preparedStatement.setString(3, p.getDescripcion());
			preparedStatement.setFloat(4, p.getPeso());
            
			preparedStatement.executeUpdate();
			
            preparedStatement.close();
            connection.close();
        }
        catch (Exception exception) {
            System.out.println(exception);
        }
		
	}
public static void deleteProducto(int id) throws Exception{
	
	try {
        // below two lines are used for connectivity.
		Connection connection = ConexionBDD.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("Delete from Producto where id_producto = "+id);
		preparedStatement.executeUpdate();
		
        preparedStatement.close();
        connection.close();
    }
    catch (Exception exception) {
        System.out.println(exception);
    }
	
}
}
