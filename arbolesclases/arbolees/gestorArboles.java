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
		int numArbolD;
		String sent;
		Scanner miTeclado = new Scanner(System.in);
		while(opcion_menu!=OPCION_SALIR) {
			System.out.println("Menu:\n "+OPCION_UNO+".Insertar arbol \n "+OPCION_DOS+".eliminar arbol \n "+OPCION_TRES+".modificar informacion del arbol \n "+OPCION_CUATRO+".visualizar arboles \n "+OPCION_SALIR+".Salir");
			opcion_menu = Integer.parseInt(miTeclado.nextLine());
			Statement st=conexion.createStatement();
			
			switch (opcion_menu) {
			case OPCION_UNO:
				System.out.println("La opcion de insertar arbol");
				insertar_arbol(miTeclado, st);
				break;
			case OPCION_DOS:
				System.out.println("La opcion de eliminar arbol");
				System.out.println("Di la id del arbol que quieras eliminar");
				numArbolD = Integer.parseInt(miTeclado.nextLine());
				sent="DELETE FROM arboles WHERE id='"+numArbolD+"'";
				st.execute(sent);
				break;
			case OPCION_TRES:
				System.out.println("La opcion de modificar informacion del arbol");
				System.out.println("Di la id del arbol que quieras modificar");
				numArbolD = Integer.parseInt(miTeclado.nextLine());
				System.out.println("Di el factor a cambiar: nombre_comun,nombre_cientifico,habitat,altura,origen");
				String factorC=miTeclado.nextLine().toLowerCase();
				if (factorC.equals("altura")) {
					System.out.println("Di la nueva altura");
					int altC = Integer.parseInt(miTeclado.nextLine());
					sent="UPDATE arboles SET "+factorC+"='"+altC+"' WHERE id="+numArbolD+"";
				}else {
					System.out.println("Di el nuevo atributo");
					String atribC = miTeclado.nextLine();
					sent="UPDATE arboles SET "+factorC+"='"+atribC+"' WHERE id="+numArbolD+"";
				}
				
				st.executeUpdate(sent);
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
	private static void insertar_arbol(Scanner miTeclado, Statement st) throws SQLException {
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
		st.execute("INSERT INTO arboles (nombre_comun,nombre_cientifico,habitat,altura,origen) VALUES ('"+nomArbol+"','"+nomCArbol+"','"+habitat+"','"+altura+"','"+origen+"')");
	}
		
	}


