package Gestores;
import POJO.Ruta;
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
       
            while (resultSet.next()) {
               r = new Ruta(resultSet.getInt("ruta_id"),
            		   resultSet.getInt"origen"),
            		   resultSet.getInt("destino"),
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
			preparedStatement.setSucursal(2, r.getOrigen());
			preparedStatement.setSucursal(3, r.getDestino());
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
