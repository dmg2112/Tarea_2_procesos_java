import java.io.IOException;
import java.util.Arrays;

/*
 * A) Cambiando la configuracion desde run configuration, añadiendo en la pestaña arguments calc.exe
 * B) Da un error ya que no tiene un programa a ejecutar, saliendo del proceso con codigo -1
 * C) Se ejecuta solo una calculadora
 * D) Habria que encapsular el try catch en un bucle for que tenga como argumento el lenght de args y que hubiese un wait para evitar que se volviese loco en caso de muchos argumentos
 */
public class RunProcess {
	public static void main(String[] args) throws IOException {
		if (args.length <= 0) {
			System.err.println("Se necesita un programa a ejecutar");
			System.exit(-1);
		}
		ProcessBuilder pb = new ProcessBuilder(args);
		try {
			Process process = pb.start();
			int retorno = process.waitFor();
			System.out.println("La ejecución de " + Arrays.toString(args) + "devuelve " + retorno);
		} catch (IOException ex) {
			System.err.println("Excepción de E/S!!");
			System.exit(-1);
		} catch (InterruptedException ex) {
			System.err.println("El proceso hijo finalizó de forma incorrecta");
			System.exit(-1);
		}
	}
}