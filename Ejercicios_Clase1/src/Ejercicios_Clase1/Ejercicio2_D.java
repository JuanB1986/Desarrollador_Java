package Ejercicios_Clase1;
import java.util.Scanner;


public class Ejercicio2_D {

	public static void main(String[] args) {
		
		Scanner ingresoDatos = new Scanner(System.in);

		float ingresoMensual=0.0f;
		char flagVehiculos='n';
		char flagInmuebles='n';
		char flagLujo='n';
		
		
		//Ingreso de datos		
		
		System.out.println("Ingreso Mensual: ");
		ingresoMensual = ingresoDatos.nextFloat();
		
		System.out.println("Tiene más de 3 vehiculos con antigüedad menor a 5 años? (S/N): ");
		flagVehiculos = ingresoDatos.next().charAt(0);		

		System.out.println("Tiene mas de 3 inmuebles? (S/N): ");
		flagInmuebles = ingresoDatos.next().charAt(0);	
		
		System.out.println("Posee una embarcación, una aeronave de lujo o es titular de activos societarios? (S/N): ");
		flagLujo = ingresoDatos.next().toString().charAt(0);	
		
		
		
		//Imprime en pantalla el resultado
		
		if ( (ingresoMensual > 489083) && (flagVehiculos == 's' || flagVehiculos == 'S') && (flagInmuebles == 's' || flagInmuebles == 'S') && (flagLujo == 's' || flagLujo == 'S'))
		{
			System.out.println("***Pertenece al segmento de ingresos altos.***");
		}
		else 
		{
			System.out.println("***No pertenece al segmento de ingresos altos.***");
		}
		

		
	}

}
