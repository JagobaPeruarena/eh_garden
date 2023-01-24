package arbolees;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class gestorArboles {
	static final String HOST="jdbc:mysql://localhost/";
	static final String BBDD="arboles";
	static final String USERNAME="root";
	static final String PASSWORD="";
	static Connection conexion;
	public static void run() throws SQLException {
		final int OPCION_UNO = 1;
		final int OPCION_DOS = 2;
		final int OPCION_TRES = 3;
		final int OPCION_CUATRO =4;
		final int OPCION_SALIR = 0;
		int opcion_menu=1;
		Scanner miTeclado = new Scanner(System.in);
		while(opcion_menu!=OPCION_SALIR) {
			System.out.println("Menu:\n "+OPCION_UNO+".Insertar arbol \n "+OPCION_DOS+".eliminar arbol \n "+OPCION_TRES+".modificar informacion del arbol \n "+OPCION_CUATRO+".visualizar arboles \n "+OPCION_SALIR+".Salir");
			opcion_menu = Integer.parseInt(miTeclado.nextLine());
			Statement st=conexion.createStatement();
			
			switch (opcion_menu) {
			case OPCION_UNO:
				System.out.println("La opcion de insertar arbol");
				System.out.println("Di el nombre del arbol");
				String nomArbol = miTeclado.nextLine();
				System.out.println("Di el nombre cientifico del arbol");
				String nomCArbol = miTeclado.nextLine();
				System.out.println("Di el habitat del arbol");
				String habitat = miTeclado.nextLine();
				System.out.println("Di la altura del arbol");
				int altura = Integer.parseInt(miTeclado.nextLine());
				System.out.println("Di el origen del arbol");
				String origen = miTeclado.nextLine();
				st.execute("INSERT INTO animales (nombre_comun,nombre_cientifico,habitat,altura,origen) VALUES ('"+nomArbol+"','"+nomCArbol+"','"+habitat+"','"+altura+"','"+origen+"')");
				break;
			case OPCION_DOS:
				System.out.println("La opcion de eliminar arbol");
				
				break;
			case OPCION_TRES:
				System.out.println("La opcion de modificar informacion del arbol");
				
				break;
			case OPCION_CUATRO:
				System.out.println("La opcion de visualizar arboles");
				
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


