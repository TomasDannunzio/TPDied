package POJO;

import java.time.LocalTime;

public class Ruta {
	private int ruta_id;
	private Sucursal origen;
	private Sucursal destino;
	private LocalTime tiempoTransito;
	private float capacidad;
	private boolean operativa;
	
	//Setters & Getters
	public int getId() {
		return ruta_id;
	}
	public void setId(int id) {
		this.ruta_id = id;
	}
	public Sucursal getOrigen() {
		return origen;
	}
	public void setOrigen(Sucursal origen) {
		this.origen = origen;
	}
	public Sucursal getDestino() {
		return destino;
	}
	public void setDestino(Sucursal destino) {
		this.destino = destino;
	}
	public LocalTime getTiempoTransito() {
		return tiempoTransito;
	}
	public void setTiempoTransito(LocalTime tiempoTransito) {
		this.tiempoTransito = tiempoTransito;
	}
	public float getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(float capacidad) {
		this.capacidad = capacidad;
	}
	public boolean isOperativa() {
		return operativa;
	}
	public void setOperativa(boolean operativa) {
		this.operativa = operativa;
	}
	
	//Constructor
	public Ruta(int id, Sucursal origen, Sucursal destino, LocalTime tiempoTransito, float capacidad,
			boolean operativa) {
		super();
		this.ruta_id = id;
		this.origen = origen;
		this.destino = destino;
		this.tiempoTransito = tiempoTransito;
		this.capacidad = capacidad;
		this.operativa = operativa;
	}
	
	
}
