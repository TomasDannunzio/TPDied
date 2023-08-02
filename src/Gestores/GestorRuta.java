package Gestores;
import POJO.Ruta;
import POJO.Sucursal;

import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
public class GestorRuta {
	
	private static GestorRuta gestor;
	
	public static GestorRuta getInstance() {
		if(gestor==null) {
			gestor = new GestorRuta();
		}
		return gestor;
	}
	
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
		
		
		public ArrayList<Ruta> getAllRuta() throws Exception{
			Ruta r = null;
			ArrayList<Ruta> lista = new ArrayList<Ruta>();
		    try {
		        // below two lines are used for connectivity.
		    	Connection connection = ConexionBDD.getConnection();
		        Statement statement;
		        statement = connection.createStatement();
		        ResultSet resultSet = statement.executeQuery(
		            "select * from ruta");
		        
		        GestorSucursal gestorSucursal = GestorSucursal.getInstance();
		        
		        while (resultSet.next()) {
		           r = new Ruta(resultSet.getInt("ruta_id"),
		        		   gestorSucursal.getSucursalById(resultSet.getInt("origen_id")),
		        		   gestorSucursal.getSucursalById(resultSet.getInt("destino_id")),
		        		   resultSet.getTime("tiempoTransito").toLocalTime(),
		        		   resultSet.getFloat("capacidad"),
		        		   resultSet.getBoolean("operativa")
		        		   );
		           
		           lista.add(r);
		           
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

		public ArrayList<Ruta> getRuta(String nombreOrigen, String nombreDestino, String tiempoTransito,
				String capacidad, boolean operativa) {
			// TODO Auto-generated method stub
			
			Ruta r = null;
			
			System.out.println(nombreOrigen);
			
			GestorSucursal gestorSucursal = GestorSucursal.getInstance();
			
			String idOrigen = "";
			String idDestino = "";
			
			if(!nombreOrigen.equals(""))
			idOrigen += String.valueOf(gestorSucursal.getSucursalByNombre(nombreOrigen).getId());
			if(!nombreDestino.equals(""))
			idDestino = String.valueOf(gestorSucursal.getSucursalByNombre(nombreDestino).getId());
			
			ArrayList<Ruta> lista = new ArrayList<Ruta>();
			
			try {
			
			Connection connection = ConexionBDD.getConnection();
	        Statement statement;
	        statement = connection.createStatement();
	        
	        String queryFinal = "select * from ruta where ";
	        
	        String origenQuery = "origen_id = " + idOrigen;
	        String destinoQuery = "destino_id = " + idDestino;
	        String tiempoTransitoQuery = "tiempoTransito = \"" + tiempoTransito+"\"";
	        String capacidadQuery = "capacidad = " + capacidad;
	        
	        String operativaQuery = null;
	        
	        if(operativa) operativaQuery = "operativa = true"; else operativaQuery = "operativa = false";
	        
	        boolean masDeUno = false;
	        
	        if(!idOrigen.equals("")) {queryFinal += origenQuery; masDeUno=true;}
	        if(!idDestino.equals("")) {if(masDeUno) queryFinal = queryFinal + " AND " + destinoQuery; else queryFinal += destinoQuery; masDeUno=true;}
	        if(!tiempoTransito.equals("")) {if(masDeUno) queryFinal = queryFinal + " AND " + tiempoTransitoQuery; 
	        else queryFinal += tiempoTransitoQuery; masDeUno=true;}
	        if(!capacidad.equals("")) {if(masDeUno) queryFinal = queryFinal + " AND " + capacidadQuery; 
	        else queryFinal += capacidadQuery; masDeUno=true;}
	        if(masDeUno) queryFinal = queryFinal + " AND " + operativaQuery; else queryFinal += operativaQuery;
	        
	        queryFinal += ";";
	        
	        ResultSet resultSet = statement.executeQuery(queryFinal);
	        
	        while (resultSet.next()) {
		           r = new Ruta(resultSet.getInt("ruta_id"),
		        		   gestorSucursal.getSucursalById(resultSet.getInt("origen_id")),
		        		   gestorSucursal.getSucursalById(resultSet.getInt("destino_id")),
		        		   resultSet.getTime("tiempoTransito").toLocalTime(),
		        		   resultSet.getFloat("capacidad"),
		        		   resultSet.getBoolean("operativa")
		        		   );
		           
		           lista.add(r);
		           
		        }
		        
		        resultSet.close();
		        statement.close();
		        connection.close();
	        
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			return lista;
		}

		public void updateRuta(int id, String nombreOrigen, String nombreDestino, LocalTime tiempoTransito, Float capacidad,
				boolean operativa) {
			// TODO Auto-generated method stub
			
			try {
				
				GestorSucursal gestorSucursal = GestorSucursal.getInstance();
				
				Sucursal origen = gestorSucursal.getSucursalByNombre(nombreOrigen);
				
				Sucursal destino = gestorSucursal.getSucursalByNombre(nombreDestino);
				
		        // below two lines are used for connectivity.
				Connection connection = ConexionBDD.getConnection();
				
				String finalQuery = "UPDATE RUTA SET ";
				
				String origenQuery = "origen_id= \"" + origen.getId() + "\"";
				
				String destinoQuery = ",destino_id = \"" + origen.getId() +"\"";
				
				String tiempoTransitoQuery = ",tiempoTransito = \"" + tiempoTransito.toString()+"\"";
				
				String capacidadQuery = ",capacidad = " + capacidad.toString();
				
				String operativaQuery = null;
		        
		        if(operativa) operativaQuery = ",operativa = true"; else operativaQuery = ",operativa = false";
				
		        finalQuery += origenQuery+destinoQuery+tiempoTransitoQuery+capacidadQuery+operativaQuery;
		        
				finalQuery += " WHERE ruta_id= "+id+";";
				
				System.out.println(finalQuery);
				
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
		
		
		
}
