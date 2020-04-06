package funciones;

import dominio.Usuario;

public class FuncionesUsuario {

	public int calcularImpuestos(Usuario usuario) {
		int impuesto = 0; //Si es menor, queda con este impuesto
		int edadUsuario = usuario.getEdad();
		if (validadorEdadSegunRango(edadUsuario, 18, 29) 
				|| validadorEdadSegunRango(edadUsuario, 65, 1000)) {
			impuesto = 2000;
		}else if (validadorEdadSegunRango(edadUsuario, 30, 64)) {
			impuesto = 7000;
		}
		
		impuesto = calcularImpuestoSegunCantidadHijos(impuesto, usuario.getCantidadDeHijos());
		return impuesto;
		
		
		
	}
	
	private boolean validadorEdadSegunRango(int numero, int rangoMin, int rangoMax) {
		return (rangoMin<=numero && rangoMax >= numero);
	}
	
	private int calcularImpuestoSegunCantidadHijos(int impuesto, int cantHijos) {
		int porcentajeTotal = 3 * cantHijos;
		if(porcentajeTotal > 50) {
			porcentajeTotal = 50;
		}
		int totalResta = ((impuesto * 100) / porcentajeTotal);
		
		return (impuesto - totalResta);
	}
}
