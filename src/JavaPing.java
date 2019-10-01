import java.io.*;

class JavaPing {
	public static void main(String[] args) {
		
		for (int i = 0; i < args.length; i++) {
			Process process = null;
			try {
				// Recoge el objeto runtime para su uso posterior
				Runtime runTime = Runtime.getRuntime();
				//ejecuta el comando especificado como si fuese
				process = runTime.exec("ping " + args[i]);
				// Crea un buffered reader que conecta con el output stream del proceso padre y lo convierte en un reader que permita leerlo.
				BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
				for (int f = 0; f < 10; f++)
					// imprime en consola lo que devuelve la consola
					System.out.println("Saludo " + in.readLine());
			} catch (IOException e) {
				System.out.println("No pudimos correr el ping");
				System.exit(-1);
			}
			if (process != null)
				//manda la señal para matar el subproceso y pasar al siguiente
				process.destroy();
			try {
				//indica al thread actual que espere a que el proceso termine antes de continuar, porque de lo contrario podria haber problemas de concurrencia
				process.waitFor();
			} catch (InterruptedException e) {
				System.out.println("No pudimos esperar por témino");
				System.exit(-1);
			}
			//devuelve el exit value del proceso 
			System.out.println("Estatus de témino: " + process.exitValue());
			
		}
		System.exit(0);

	}
}