package POJO;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;

public class Orden {
	private LocalDate FechaOrden;
	private int Destino;
	private LocalTime TiempoMax;
	private HashMap<Producto,Integer> listaProductos;
	
	//Constructores
	
	public Orden(LocalDate fechaOrden, int destino, LocalTime tiempoMax, HashMap<Producto, Integer> listaProductos) {
		super();
		FechaOrden = fechaOrden;
		Destino = destino;
		TiempoMax = tiempoMax;
		this.listaProductos = listaProductos;
	}
	//Getters and Setters
	
	public LocalDate getFechaOrden() {
		return FechaOrden;
	}
	public void setFechaOrden(LocalDate fechaOrden) {
		FechaOrden = fechaOrden;
	}
	public int getDestino() {
		return Destino;
	}
	public void setDestino(int destino) {
		Destino = destino;
	}
	public LocalTime getTiempoMax() {
		return TiempoMax;
	}
	public void setTiempoMax(LocalTime tiempoMax) {
		TiempoMax = tiempoMax;
	}
	public HashMap<Producto, Integer> getListaProductos() {
		return listaProductos;
	}
	public void setListaProductos(HashMap<Producto, Integer> listaProductos) {
		this.listaProductos = listaProductos;
	}
	
}
