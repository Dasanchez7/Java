import java.util.Scanner;

public class registro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int exe = 1;
        int ask = 0;
        
        do {
	        System.out.println("Ingrese la cantidad de estudiantes a evuluar : ");
	        int num_est = sc.nextInt();
	        
	        for(int x=0; x<num_est; x++) {
				int num_nota = 0, i = 0, nota = 0, notas_agg=0, nota_may = Integer.MIN_VALUE, nota_men = Integer.MAX_VALUE, k = 0, suma_notas = 0, aprobadas = 0, reprobadas = 0;
				int promedio_est;

				System.out.println("\nCuantas notas quiere evaluar?: ");
	        	num_nota = sc.nextInt();

	        	for(i=0; i<num_nota; i++) {
					System.out.println("Ingrese su nota: " +i);
					nota = sc.nextInt();
					notas_agg+=1;

					if (nota<10 && nota>0)
		            {
		                reprobadas+=1;
		            }
		            else if (nota>=10 && nota<=20) {
		                aprobadas+=1;
		            }
		            else {
		                System.out.println("Introduzca una nota correcta entre el intervalo de <1-20>");
		                exe=0;
		            }
		                if (nota > nota_may) {
		                    nota_may = nota;
		                }
		                if (nota < nota_men) {
		                    nota_men = nota;
		                }
		            k=nota;
		            suma_notas=k+suma_notas;
				}

				promedio_est=suma_notas/i;

		        if (promedio_est<10 && promedio_est>0)
		        {
		            System.out.println("\n Usted reprobo el curso ingresado");
		        }
		        else if (promedio_est>=10 && promedio_est<=20) {
		            System.out.println("\nUsted aprobo el curso ingresado");
		        }

		        System.out.println("\nEl promedio de las notas ingresadas es: " + promedio_est);
		        System.out.println("\nLa nota mayor tiene un valor de: " + nota_may);
		        System.out.println("\nLa nota menor tiene un valor de: " + nota_men);
		        System.out.println("\nEl numero de notas ingresadas es: " + notas_agg);
		        System.out.println("\nEl numero de materias aprobadas es: " + aprobadas);
		        System.out.println("\nEl numero de materias reprobadas es: " + reprobadas);
		    }

		    System.out.println("\n¿Desea continuar ejecutando el programa? (Para si: [1], Para no: [0]");
		    ask = sc.nextInt();

		    if (ask==1) {
		    	exe = 1;
		    }
		    else {
		    	exe = 0;
		    }
		}
		while(exe==1);
    }
}