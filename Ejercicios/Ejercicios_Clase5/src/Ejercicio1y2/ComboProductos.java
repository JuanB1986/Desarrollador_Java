package Ejercicio1y2;


public class ComboProductos {

	private String descripcion[];
	private float precio[];
	private float peso[];
	private int totalItems;
	
	public ComboProductos(int cantItems)
	{
		this.descripcion=new String [cantItems];
		this.precio=new float[cantItems];
		this.peso=new float [cantItems];
		this.totalItems=cantItems;
	}
	
	public void cargarProductos(String descripcion, float precio,float peso, int item) {		
		this.descripcion[item]=descripcion;		
		this.precio[item]=precio;
		this.peso[item]=peso;
	}
		
	void changeProducto (String descripcion, float precio, float peso, int item) {
		this.descripcion[item]=descripcion;
		this.peso[item]=peso;
		this.precio[item]=precio;
	}	
	
	public int getTotalItems() {
		return this.totalItems;
	}	
	
	public float getPrecio(int item) {
		return this.precio[item];
	}
	
	public float getPeso(int item) {
		return this.peso[item];
	}
	
	public String getDescripcion(int item) {
		return this.descripcion[item];
	}
	
}