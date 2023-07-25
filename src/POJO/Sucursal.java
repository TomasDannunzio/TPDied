package POJO;

import java.time.LocalTime;
import java.util.HashMap;

public class Sucursal {
	
	private int sucursal_id;
	private String nombre;
	private LocalTime horarioApertura;
	private LocalTime horarioCierre;
	private boolean operativa;
	private HashMap<Producto,Integer> listaProductos;
	
	// Getters and Setters
	public int getId() {
		return sucursal_id;
	}
	public void setId(int id) {
		this.sucursal_id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalTime getHorarioApertura() {
		return horarioApertura;
	}
	public void setHorarioApertura(LocalTime horarioApertura) {
		this.horarioApertura = horarioApertura;
	}
	public LocalTime getHorarioCierre() {
		return horarioCierre;
	}
	public void setHorarioCierre(LocalTime horarioCierre) {
		this.horarioCierre = horarioCierre;
	}
	public boolean isOperativa() {
		return operativa;
	}
	public void setOperativa(boolean operativa) {
		this.operativa = operativa;
	}
	
	// Constructor
	public Sucursal(int id, String nombre, LocalTime horarioApertura, LocalTime horarioCierre, boolean operativa) {
		super();
		this.sucursal_id = id;
		this.nombre = nombre;
		this.horarioApertura = horarioApertura;
		this.horarioCierre = horarioCierre;
		this.operativa = operativa;
		this.listaProductos = new HashMap<Producto,Integer>();
	}
	
}
