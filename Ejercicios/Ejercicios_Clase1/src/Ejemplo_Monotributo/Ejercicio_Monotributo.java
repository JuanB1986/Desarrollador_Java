package Ejemplo_Monotributo;
import java.util.Scanner;

public class Ejercicio_Monotributo {
	
	public static void main(String[] args) {
		
		Scanner lee_teclado=new Scanner (System.in);		
		
		double ingresos=0.0f;
		int superficie=0;
		int consumo=0;
		
		System.out.println("Ingresos: ");	
		ingresos = lee_teclado.nextDouble();
	
		System.out.println("\n Superficie; ");
		lee_teclado.nextInt();
		
		System.out.println("\n Consumo: ");
		lee_teclado.nextInt();
		
		
		if (ingresos  <= 748382.0f && superficie <= 30 && consumo < 3330) 
		{
			System.out.println("\n Cat. A \n");			
		}
		else 
		{
			if (ingresos  <= 1112459.83f && superficie <= 45 && consumo < 5000) 
			{
				System.out.println("\n Cat. B \n");	
			}		
			else
			{
				if (ingresos  <= 1557443.75f && superficie <= 60 && consumo < 6700) 
				{
					System.out.println("\n Cat. C \n");	
				}
				else
				{
					if (ingresos  <= 1934273.04f && superficie <= 85 && consumo < 10000) 
					{
						System.out.println("\n Cat. D \n");	
					}
					else
					{
						if (ingresos  <= 2277684.56f && superficie <= 110 && consumo < 13000) 
						{
							System.out.println("\n Cat. E \n");	
						}
						else
						{
							if (ingresos  <= 2847105.70f && superficie <= 150 && consumo < 16500) 
							{
								System.out.println("\n Cat. F \n");	
							}
							else
							{
								if (ingresos  <= 3416526.83f && superficie <= 200 && consumo < 20000) 
								{
									System.out.println("\n Cat. G \n");	
								}
								else
								{
									if (ingresos  <= 4229985.60f && superficie <= 200 && consumo < 20000) 
									{
										System.out.println("\n Cat. H \n");	
									}
								}
							}
						}
					}
				}
			}
		}	
	}
}
