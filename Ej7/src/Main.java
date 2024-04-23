import java.io.*;
import java.io.PrintStream;

public class Main {

	public static void main(String[] args) throws IOException {
	
		BufferedReader in = null;
        BufferedWriter out = null;
		try {
		 in =	new BufferedReader(new FileReader("C:\\Users\\Javier\\Desktop\\original.txt"));
		 out =	new BufferedWriter(new FileWriter("C:\\Users\\Javier\\Desktop\\copiaBytes.txt"));

			int c=0;
			while((c=in.read())!=-1) {
				out.write(c);
			}
			
		}catch(IOException a) {
			System.out.println("Mensaje: "+a.getMessage());
		}
		finally {
			if(in!=null) {
			in.close();
			}
			if(out!=null) {
			out.close();
		}}
	}
}