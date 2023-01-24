package arbolees;

import java.sql.Connection;
import java.util.Scanner;

public class gestorArboles {
	static final String HOST="jdbc:mysql://localhost/";
	static final String BBDD="arboles";
	static final String USERNAME="root";
	static final String PASSWORD="";
	static Connection conecion;
	public static void run() {
		final int OPCION_UNO = 1;
		final int OPCION_DOS = 2;
		final int OPCION_TRES = 3;
		final int OPCION_CUATRO =4;
		final int OPCION_SALIR = 0;
		int opcion_menu=1;
		Scanner miTeclado = new Scanner(System.in);
		while(opcion_menu!=OPCION_SALIR) {
			System.out.println("Menu:\n "+OPCION_UNO+".Multiplo de 3 \n "+OPCION_DOS+".Fibonacci \n "+OPCION_TRES+".Factorial \n "+OPCION_SALIR+".Salir");
			opcion_menu = miTeclado.nextInt();
			
			
			switch (opcion_menu) {
			case OPCION_UNO:
				System.out.println("La opcion de Multiplo de 3");
				
				break;
			case OPCION_DOS:
				System.out.println("La opcion de Fibonacci");
				
				break;
			case OPCION_TRES:
				System.out.println("La opcion de Factorial");
				
				break;
			case OPCION_CUATRO:
				System.out.println("La opcion de Factorial");
				
				break;
				
			case OPCION_SALIR:
				break;
			default:
				System.out.println("Opcion INCORRECTA");
				
				
			}
		}
		miTeclado.close();
		System.out.println("ADIOS");
	}
		
	}


