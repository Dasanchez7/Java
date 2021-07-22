package com.prog.init;

import java.util.Scanner;
import com.prog.registro.Registro;

public class Main {

	public static void main(String[] args) {
		ejecucion();
	}

	public static void ejecucion() {
		boolean run = true;

		int materias[][] = new int[100][100]; // Matriz que se usa como parametro en una funcion para guardar las notas de las materias 
		int array_promedioest[] = new int [100]; // Array que se le da como parametro a la funcion del otro paquete para que se llene con los promedios

		int array_promedio[] = new int[100];  // Array que recibe los promedios de los estudiantes ejecutados en el otro paquete
		int notas_est[][] = new int[100][100]; // Matriz que recibe las notas de los estudiantes ejecutado en el otro paquete

		// Variables para guardar los datos

		String nombre_est[] = new String[100]; // Array guarda el nombre de los estudiantes
		String apellido_est[] = new String[100]; // Array guarda el apellido de los estudiantes
		int cedula_est[] = new int[100]; // Array guarda la cedula de los estudiantes

		int cumpleanios_est[] = new int[100]; // Array guarda la edad de los estudiantes

		String direccion_est[] = new String[100]; // Array guarda la direccion de los estudiantes
		char sexo_est[] = new char[100]; // Array guarda el sexo de los estudiantes		

		String nombre_materias[] = new String[100]; // Array Para guardar el nombre de las materias 
		int promedio_general = 0; // Variable hacer el calculo del promedio general

		int estudiantes=0; // Variable para hacer el conteo de estudiantes registrados
		int hombres=0; // Variable para hacer el conteo de hombres registrados
		int mujeres=0; // Variables para hacer el conteo de mujeres registradas

		int suma_promedio = 0; // Variable para hacer la suma de los promedios
		
		Scanner sc = new Scanner(System.in);

		Registro x = new Registro();
		
		do {
			// FECHA ACTUAL 
			int dia_a = 15;
			int mes_a = 7;
			int ano_a = 2021;

			boolean run2 = false;
			boolean run3 = false;
			boolean run4 = true;

			System.out.print("1.- Registro de estudiantes ");

			System.out.print("\nIngrese el numero de estudiantes nuevos a ingresar: ");
			int num_est = sc.nextInt();

			for(int i=0; i<num_est;i++) {
				
				int edad = 0;
				
				System.out.println("Ingrese tu nombre: "+"["+i+"]");
				nombre_est[i] = sc.next();
	
				System.out.println("Ingrese tu apellido: "+"["+i+"]");
				apellido_est[i] = sc.next();
				
				System.out.println("Ingrese tu cedula: "+"["+i+"]");
				cedula_est[i] = sc.nextInt();

				sc.nextLine();
	
				System.out.println("Ingresa tu Direcccion de vivienda: "+"["+i+"]");
				direccion_est[i] = sc.nextLine();
				
				do {
					System.out.println("Ingresa tu Dia de Nacimiento: "+"["+i+"]");
					int dia_naci = sc.nextInt();
		
					System.out.println("Ingresa tu Mes de Nacimiento: "+"["+i+"]");
					int mes_naci = sc.nextInt();
		
					System.out.println("Ingresa tu Año de Nacimiento: "+"["+i+"]");
					int ano_naci = sc.nextInt();

					if(dia_naci < 32 && dia_naci >0 && mes_naci < 13 && mes_naci > 0 && ano_naci > 1900 && ano_naci < 2021) {
						System.out.println("Registro culminado.");
						edad = x.calculo_edad(dia_a, mes_a, ano_a, dia_naci, mes_naci, ano_naci); // Se le pasa como parametro a la funcion los datos para hacer el calculo de la edad
						cumpleanios_est[i] = edad; // Lo guarda en un array la edad
						run2 = true;
					}
					else {
						System.out.println("Error, introduzca un valor correcto.");
						run2 = false;
					}

				}
				while(run2==false);
				
				// Validadciones para hacer el conteo del sexo de los estudiantes
				do {
					System.out.println("Ingresa tu sexo (H/M): "+"["+i+"]");
					sexo_est[i] = sc.next().charAt(0);

					if(sexo_est[i]=='H' || sexo_est[i]=='h') {
						hombres+=1;
						run3 = true;
					}
					else if(sexo_est[i]=='M' || sexo_est[i]=='m'){
						mujeres+=1;
						run3 = true;
					}
					else {
						System.out.println("Error, introduzca un valor correcto");
						run3 = false;
					}

				}
				while(run3==false); 

				estudiantes+=1;
				
			}
			sc.nextLine();
			System.out.println("Ingresa la cantidad de materias a evaluar: ");
			int num_materias = sc.nextInt();

			for(int y = 0; y<num_materias; y++){
				System.out.println("Ingresa el nombre de las materias a evaluar respectivamente: ");
				nombre_materias[y] = sc.next(); // Se guarda el nombre de las materias
			}

			notas_est = Registro.promedio_est(num_materias,num_est, materias, array_promedio); // Se le pasa los datos para que la funcion ejecute el registro de las notas y promedio
			
			array_promedio = Registro.mostrar_promedio(num_materias, num_est, notas_est, array_promedioest); // Funcion para traer en este paquete el promedio de los estudiantes

			do {

				System.out.print("\n2.- Lista de estudiantes\n3.- Estadisticas\n4.- Configuraciones\n5.- Salir");
				System.out.print("\nSeleccione una opcion del menu: ");
				int selec = sc.nextInt();

				switch(selec) {

					case 2:
						System.out.print("\nLista de estudiantes ");
						System.out.print("\n1.- Imprimir todos los datos de los estudiantes\n2.- Estudiante especifico a mostrar sus datos");
						System.out.println("\nSelecciona una opcion: ");
						
						int opc = sc.nextInt();

						switch(opc) {
							case 1:

								// Muestra todos los datos de los estudiantes registrados
								promedio_general = 0;
								suma_promedio = 0;
								for(int i=0;i<estudiantes;i++) {	
									System.out.println("\n\nNombre: "+"["+i+"] "+nombre_est[i]+"\nApellido: "+"["+i+"] "+apellido_est[i]+"\nCedula: "+"["+i+"] "+cedula_est[i]+"\nSexo: "+"["+i+"] "+sexo_est[i]+"\nEdad: "+"["+i+"] "+cumpleanios_est[i]+"\nDireccion: "+"["+i+"] "+direccion_est[i]);
									System.out.println("Promedio: "+"["+i+"] "+array_promedio[i]);
									suma_promedio = suma_promedio + array_promedio[i];
								}
								promedio_general = suma_promedio / num_est;

								for(int h = 0; h<num_est; h++) {
									System.out.println(" ");
									System.out.print("Notas Estudiante: "+"["+h+"]"+"\n");
									for(int k = 0; k<num_materias; k++) {
										System.out.println("\nMateria: "+nombre_materias[k]);
										System.out.println("Nota: "+notas_est[h][k]);
									}
								}
								System.out.println("\nEl promedio general fue de: " + promedio_general);
							break;

							case 2:
								// Muestra los datos de un estudiante especifico
								System.out.println("Ingrese la posicion a imprimir (Ingrese alguna posicion de estudiante registrado): ");
								int pos_est = sc.nextInt(); 

								System.out.println("\n\nNombre: "+"["+pos_est+"] "+nombre_est[pos_est]+"\nApellido: "+"["+pos_est+"] "+apellido_est[pos_est]+"\nCedula: "+"["+pos_est+"] "+cedula_est[pos_est]+"\nSexo: "+"["+pos_est+"] "+sexo_est[pos_est]+"\nEdad: "+"["+pos_est+"] "+cumpleanios_est[pos_est]+"\nDireccion: "+"["+pos_est+"] "+direccion_est[pos_est]);
								System.out.println("Promedio: "+"["+pos_est+"] "+array_promedio[pos_est]);

								for(int v = 0; v<num_materias; v++) {
									System.out.println("\nMateria: "+nombre_materias[v]);
									System.out.println("Nota: "+notas_est[pos_est][v]);
								}

								int est_high[] = new int[100];
								int est_low[] = new int[100];
						
								int nota_high = 0; 
								int nota_low = 100;
						
								// For que se ejecuta segun el X cantidad de estudiantes, y las X cantidad de materias
						
								for (int z = 0; z < num_est; z++) {
									nota_high = 0; 
									nota_low = 100;

									for (int j = 0; j < num_materias; j++) {
										if(materias[z][j]>nota_high) {
											nota_high = notas_est[z][j];
										}
										if(notas_est[z][j]<nota_low){
											nota_low = notas_est[z][j];
										}
									}			
									est_high[z]=nota_high;
									est_low[z]=nota_low;
						
								}

								System.out.println("\nNota mas alta: "+est_high[pos_est]);
								System.out.println("Nota mas baja: "+est_low[pos_est]);

							break;
						}
						
					break;

					case 3:
						System.out.print("\nEstadisticas ");
						// Se le pasa como parametro a la funcion para que muestre cuantos hombres, mujeres y estudiantes se registraron
						mostrar_estadistica(hombres, mujeres, estudiantes);
					break;

					case 4:
						// Se configura la fecha actual
						System.out.print("\nConfiguraciones ");
						System.out.print("\nIntroduzca el nuevo dia en el que basar los calculos: ");
						dia_a = sc.nextInt();
						System.out.print("\nIntroduzca el nuevo mes en el que basar los calculos: ");
						mes_a = sc.nextInt();
						System.out.print("\nIntroduzca el nuevo año en el que basar los calculos: ");
						ano_a = sc.nextInt();
					break;

					case 5:
						System.out.print("Salir.");
						run4=false;
						run=false;
					break;

					default:
						System.out.print("Error, introduzca una opcion correcta.");
					break;
				}
			}
			while(run4==true);
		}
		while(run==true);

	}

	// Funcion que muestra la estadistica de los estudiantes registrados
	public static void mostrar_estadistica(int h, int m, int e) {
		int hombres=h; int mujeres=m; int estudiantes=e;
		System.out.println("\nTotal hombres es: " +hombres +"\nTotal mujeres es: "+mujeres+"\nTotal estudiantes es: " +estudiantes);
	}

}

