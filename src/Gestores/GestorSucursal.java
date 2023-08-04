package Gestores;
import java.sql.*;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import POJO.Producto;
import POJO.Sucursal;

public class GestorSucursal {
	
	private static GestorSucursal gestor;
	
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
			LocalTime horarioCierre, boolean operativa) throws Exception {
		
		Sucursal s = new Sucursal(id,nombre,horarioApertura,horarioCierre,operativa);
		ArrayList<Producto> p = GestorProducto.getInstance().getAllProducto();
		try {
		persistSucursal(s);
		persistStock(s,p);
		} catch(Exception e) {
			//e.printStackTrace();
			System.out.println("No se ha podido persistir");
			throw new Exception();
		}
		
		return s;

	}
	
	private void persistStock(Sucursal s, ArrayList<Producto> p)throws Exception{
		try {
			System.out.println("Entré");
            // below two lines are used for connectivity.
			Connection connection = ConexionBDD.getConnection();
            
            p.stream().forEach( t -> {
				try {
					PreparedStatement preparedStatement = connection.prepareStatement("insert into Stock(Producto_id, Sucursal_id, cantidad) values(?, ?, 0)");
					preparedStatement.setInt(1, t.getId());
					preparedStatement.setInt(2, s.getId());
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

	public void persistSucursal(Sucursal s) throws Exception{
		
		try {
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
            throw new Exception();
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

public Sucursal getSucursalByNombre(String nom){
	Sucursal s = null;
    try {
        // below two lines are used for connectivity.
    	Connection connection = ConexionBDD.getConnection();
        Statement statement;
        statement = connection.createStatement();
        
        ResultSet resultSet = null;
        
        try {
        resultSet = statement.executeQuery(
            "select * from sucursal where nombre = \"" + nom +"\"");
        } catch(Exception e) {
        	e.printStackTrace();
        }
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
	        
	        queryFinal += " order by sucursal_id ASC;";
	        
	        
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

public ArrayList<Sucursal> getAllSucursal() {
	Sucursal s = null;
	ArrayList<Sucursal> lista = new ArrayList<Sucursal>();
    try {
        // below two lines are used for connectivity.
    	Connection connection = ConexionBDD.getConnection();
        Statement statement;
        statement = connection.createStatement();
        
        ResultSet resultSet = null;
        
        try {
        	resultSet = statement.executeQuery(
            "select * from sucursal order by sucursal_id");
        } catch(Exception e) {
        	e.printStackTrace();
        }
        
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


public void updateStock(int producto, int cant)throws Exception{
	Connection connection = ConexionBDD.getConnection();
	PreparedStatement preparedStatement = connection.prepareStatement("UPDATE stock SET cantidad = "+ cant +" where producto_id ="+producto);
	preparedStatement.executeUpdate();
    preparedStatement.close();
    connection.close();
}

public HashMap<Producto, Integer> getStock(int id) throws Exception{
	Producto p = null;
	HashMap<Producto, Integer> lista = new HashMap<Producto, Integer>();
    try {
        // below two lines are used for connectivity.
    	Connection connection = ConexionBDD.getConnection();
        Statement statement;
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery( "select p.*, s.cantidad from Stock S, producto P where P.producto_id = S.Producto_id AND S.sucursal_id ="+ id);
        ;
        while (resultSet.next()) {
            p = new Producto(resultSet.getInt("producto_id"),
         		   resultSet.getString("nombre"),
         		   resultSet.getString("descripcion"),
         		   resultSet.getFloat("Precio"),
         		   resultSet.getFloat("Peso"));
            Integer cant = resultSet.getInt("cantidad");	
            lista.put(p, cant);
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


public void createOrden(int id, LocalDate fecha, String destino, LocalTime TiempoMax ) {
	try {
		Connection connection = ConexionBDD.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("insert into orden values(?, ?, ?, ?)");
		preparedStatement.setInt(1, id);
		preparedStatement.setDate(2, Date.valueOf(fecha));
		preparedStatement.setInt(3, this.getSucursalByNombre(destino).getId());
		preparedStatement.setTime(4, Time.valueOf(TiempoMax));
		preparedStatement.executeUpdate();
	    preparedStatement.close();
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}

public void addProductToOrder(int id, int orden, int cantidad) {
	Connection connection;
	try {
		connection = ConexionBDD.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO productosOrden Values(?, ?, ?)");
		preparedStatement.setInt(1, orden);
		preparedStatement.setInt(2, id);
		preparedStatement.setInt(3, cantidad);
		preparedStatement.executeUpdate();
	    preparedStatement.close();

	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public void deleteProductFromOrder(int id, int orden) {
	try {
        // below two lines are used for connectivity.
		Connection connection = ConexionBDD.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("Delete from ProductosOrden where producto_id = "+id+" AND orden_id="+orden);
		preparedStatement.executeUpdate();
		
		System.out.println(preparedStatement);
		
        preparedStatement.close();
        connection.close();
    }
    catch (Exception exception) {
        System.out.println(exception);
    }
}
public HashMap<Producto, Integer> getProductosOrden(int id) throws Exception{
	Producto p = null;
	HashMap<Producto, Integer> lista = new HashMap<Producto, Integer>();
    try {
        // below two lines are used for connectivity.
    	Connection connection = ConexionBDD.getConnection();
        Statement statement;
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery( "select p.*, Ps.cantidad from productosOrden PS, producto P where P.producto_id = PS.Producto_id AND PS.orden_id ="+ id);
        ;
        while (resultSet.next()) {
            p = new Producto(resultSet.getInt("producto_id"),
         		   resultSet.getString("nombre"),
         		   resultSet.getString("descripcion"),
         		   resultSet.getFloat("Precio"),
         		   resultSet.getFloat("Peso"));
            Integer cant = resultSet.getInt("cantidad");	
            lista.put(p, cant);
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
