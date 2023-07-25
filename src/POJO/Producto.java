package POJO;

public class Producto {
	
	private int producto_id;
	private String nombre;
	private String descripcion;
	private float peso;
	
	//Setters & Getters
	public int getProducto_id() {
		return producto_id;
	}
	public void setProducto_id(int producto_id) {
		this.producto_id = producto_id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	
	//Constructor
	public Producto(int producto_id, String nombre, String descripcion, float peso) {
		super();
		this.producto_id = producto_id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.peso = peso;
	}

}
