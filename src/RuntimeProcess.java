
import java.io.IOException;


// a) Se ejecuta el código sin problemas pero no pasa nada a simple vista
// b) Se abre el notepad ya que no se mata el proceso
public class RuntimeProcess {
	public static void main(String[] args) {
		if (args.length <= 0) {
			System.err.println("Se necesita un programa a ejecutar");
			System.exit(-1);
		}
		Runtime runtime = Runtime.getRuntime();
		try {
			Process process = runtime.exec(args);
			//process.destroy();
		} catch (IOException ex) {
			System.err.println("Excepción de E/S!!");
			System.exit(-1);
		}
	}
}