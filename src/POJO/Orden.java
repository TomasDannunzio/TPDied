package POJO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;

public class Orden {
	private int orden_id;
	private LocalDate FechaOrden;
	private Sucursal Destino;
	private LocalTime TiempoMax;
	private HashMap<Producto,Integer> listaProductos;
	private Estado estado;
	
	//Constructores
	
	public Orden(int orden, LocalDate fechaOrden, Sucursal destino, LocalTime tiempoMax, HashMap<Producto, Integer> listaProductos) {
		super();
		orden_id = orden;
		FechaOrden = fechaOrden;
		Destino = destino;
		TiempoMax = tiempoMax;
		this.listaProductos = listaProductos;
		this.estado= Estado.PENDIENTE;

	}
	
	//Getters and Setters
	
	public LocalDate getFechaOrden() {
		return FechaOrden;
	}
	public void setFechaOrden(LocalDate fechaOrden) {
		FechaOrden = fechaOrden;
	}
	public Sucursal getDestino() {
		return Destino;
	}
	public void setDestino(Sucursal destino) {
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
