package chap10.io.file;
import java.io.*;
public class ReadFile {
	public static void main (String [] args) {
		// Create file
		File file = new File(args[0]);

		try {
			// Create a buffered reader
			// to read each line from a file.
			BufferedReader in
				= new BufferedReader(new FileReader(file));
			String s;
			try {
				// Read each line from the file
				s = in.readLine();
				while (s != null) {
					System.out.println("Read: " + s);
					s = in.readLine();
				}
			} finally {
				// Close the buffered reader
				in.close();
			}

		} catch (FileNotFoundException e1) {
			// If this file does not exist
			System.err.println("File not found: " + file);

		} catch (IOException e2) {
			// Catch any other IO exceptions.
			e2.printStackTrace();
		} 

	}
}