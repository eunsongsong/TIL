package chap10.io.file;
import java.io.*;

public class WriteFile {
	public static void main (String[] args) {
		// Create file
		File file = new File(args[0]);

		try {
			// Create a buffered reader
			InputStreamReader isr
					= new InputStreamReader(System.in);
			BufferedReader in
					= new BufferedReader(isr);
			// Create a print writer on this file.
			PrintWriter out
					= new PrintWriter(new FileWriter(file));
			String s;
			System.out.print("Enter file text.  ");
			System.out.println("[Type ctrl-d to stop.]");

			// Read each input line
			while ((s = in.readLine()) != null) {
				out.println(s);
			}


			// Close the buffered reader
			in.close();
			out.close();

		} catch (IOException e) {
			// Catch any IO exceptions.
			e.printStackTrace();
		}
	}
}