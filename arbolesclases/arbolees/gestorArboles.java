package arbolees;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class gestorArboles {
	static final String HOST="jdbc:mysql://localhost/";
	static final String BBDD="arboles";
	static final String USERNAME="root";
	static final String PASSWORD="";
	static Connection conexion;
	public static void run() throws SQLException, ClassNotFoundException {
		final int OPCION_UNO = 1;
		final int OPCION_DOS = 2;
		final int OPCION_TRES = 3;
		final int OPCION_CUATRO =4;
		final int OPCION_SALIR = 0;
		int opcion_menu=1;
		Class.forName("com.mysql.cj.jdbc.Driver");
		conexion = DriverManager.getConnection(HOST+BBDD,USERNAME,PASSWORD);
		arboles arbol = new arboles();
	
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
				eliminarArboles(miTeclado, st);
				break;
			case OPCION_TRES:
				System.out.println("La opcion de modificar informacion del arbol");
				actualizarArboles(miTeclado, st);
				break;
			case OPCION_CUATRO:
				System.out.println("La opcion de visualizar arboles");
				visualizarArboles(st);
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
	private static void visualizarArboles(Statement st) throws SQLException {
		PreparedStatement pt = conexion.prepareStatement("SELECT * FROM arboles ");
		
	
		ResultSet resultado=pt.executeQuery();
		while(resultado.next()) {
			arboles arbol= new arboles();
			arbol.setId(resultado.getInt(1));
			arbol.setNombreComun(resultado.getString(2));
			arbol.setNombreCientifico(resultado.getString(3));
			arbol.setHabitat(resultado.getString(4));
			arbol.setAltura(resultado.getInt(5));
			arbol.setOrigen(resultado.getString(6));
		
			System.out.println(arbol);
			
		}
	}
	private static void eliminarArboles(Scanner miTeclado, Statement st) throws SQLException {
		int numArbolD;
		String sent="DELETE FROM arboles WHERE id=?";
		PreparedStatement pt = conexion.prepareStatement(sent);
		System.out.println("Di la id del arbol que quieras eliminar");
		numArbolD = Integer.parseInt(miTeclado.nextLine());
		pt.setInt(1, numArbolD);
		pt.execute();
		
	}
	private static void actualizarArboles(Scanner miTeclado, Statement st) throws SQLException {
		int numArbolD;
		String sent= "UPDATE arboles SET ?=? WHERE id=?";
		PreparedStatement pt = conexion.prepareStatement(sent);
		System.out.println("Di la id del arbol que quieras modificar");
		numArbolD = Integer.parseInt(miTeclado.nextLine());
		pt.setInt(3, numArbolD);
		System.out.println("Di el factor a cambiar: nombre_comun,nombre_cientifico,habitat,altura,origen");
		String factorC=miTeclado.nextLine().toLowerCase();
		pt.setString(1, factorC);
		if (factorC.equals("altura")) {
			System.out.println("Di la nueva altura");
			int altC = Integer.parseInt(miTeclado.nextLine());
			
			pt.setInt(2, altC);
		}else {
			System.out.println("Di el nuevo atributo");
			String atribC = miTeclado.nextLine();
			pt.setString(2, atribC);
		}
		pt.executeUpdate();
		
		
	}
	private static void insertar_arbol(Scanner miTeclado, Statement st) throws SQLException {
		arboles arbol = new arboles();
		String sent ="INSERT INTO arboles (nombre_comun,nombre_cientifico,habitat,altura,origen) VALUES (?,?,?,?,?)";
		PreparedStatement pt = conexion.prepareStatement(sent);
		System.out.println("Di el nombre del arbol");
		arbol.setNombreComun(miTeclado.nextLine());
		System.out.println("Di el nombre cientifico del arbol");
		arbol.setNombreCientifico(miTeclado.nextLine());
		System.out.println("Di el habitat del arbol");
		arbol.setHabitat(miTeclado.nextLine());
		System.out.println("Di la altura del arbol");
		arbol.setAltura(Integer.parseInt(miTeclado.nextLine()));
		System.out.println("Di el origen del arbol");
		arbol.setOrigen(miTeclado.nextLine());
		
		pt.setString(1, arbol.getNombreComun());
		pt.setString(2, arbol.getNombreCientifico());
		pt.setString(3, arbol.getHabitat());
		pt.setInt(4, arbol.getAltura());
		pt.setString(5, arbol.getOrigen());
		pt.execute();
	}
		
	}


