package Gestores;
import POJO.Ruta;
import POJO.Sucursal;

import java.sql.*;
public class GestorRuta {
	public Ruta getRutaById(int i) throws Exception{
		Ruta r = null;
        try {
            // below two lines are used for connectivity.
        	Connection connection = ConexionBDD.getConnection();
            Statement statement;
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                "select * from ruta where ruta_id ="+i+"");
            
            GestorSucursal gestorS = GestorSucursal.getInstance();
            
            while (resultSet.next()) {
            	
            	Sucursal origen = gestorS.getSucursalById(resultSet.getInt("origen_id"));
            	
            	Sucursal destino = gestorS.getSucursalById(resultSet.getInt("destino_id"));
            	
               r = new Ruta(resultSet.getInt("ruta_id"),
            		   origen,
            		   destino,
            		   resultSet.getTime("tiempoTransito").toLocalTime(),
					   resultSet.getFloat("capacidad"),
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
        
        return r;
        
	}
	
	
		public void createRuta(Ruta r) throws Exception{
		
		try {
            // below two lines are used for connectivity.
			Connection connection = ConexionBDD.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into ruta(id, origen, destino, tiempoTransito, capacidad ,operativa) values(?, ?, ?, ?, ?, ?)");
			preparedStatement.setInt(1, r.getId());
			preparedStatement.setInt(2, r.getOrigen().getId());
			preparedStatement.setInt(3, r.getOrigen().getId());
			preparedStatement.setTime(4, Time.valueOf(r.getTiempoTransito()));
			preparedStatement.setFloat(5, r.getCapacidad());
			preparedStatement.setBoolean(6, r.isOperativa());
            
			preparedStatement.executeUpdate();
			
            preparedStatement.close();
            connection.close();
        }
        catch (Exception exception) {
            System.out.println(exception);
        }
		
	}
}
