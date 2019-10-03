import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

// a) Se obtiene el texto que te sale cuando ejecutas el cmd porque hemos cogido la informacion del proceso hijo(cmd) y se la hemos enviado al proceso padre y lo hemos escrito por pantalla
// b) Ha cambiado el simbolo que sustituía a la ó de Versión por una interrogación
// c) Try catch puesto e hijo cerrado
public class ComunicationBetweenProcess {
	public static void main(String args[]) {
		try {
			Process process = new ProcessBuilder(args).start();
			InputStream is = process.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			String line;
			System.out.println("Salida del proceso " + Arrays.toString(args) + ":");
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
