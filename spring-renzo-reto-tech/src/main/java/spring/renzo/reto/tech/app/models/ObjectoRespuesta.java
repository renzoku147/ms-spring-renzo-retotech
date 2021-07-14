package spring.renzo.reto.tech.app.models;


public class ObjectoRespuesta {
	
	private Double promedio;
	
	private Double deviacion;

	public ObjectoRespuesta(Double promedio, Double deviacion) {
		super();
		this.promedio = promedio;
		this.deviacion = deviacion;
	}

	public ObjectoRespuesta() {
	}

	public Double getPromedio() {
		return promedio;
	}

	public void setPromedio(Double promedio) {
		this.promedio = promedio;
	}

	public Double getDeviacion() {
		return deviacion;
	}

	public void setDeviacion(Double deviacion) {
		this.deviacion = deviacion;
	}
	
	
}
