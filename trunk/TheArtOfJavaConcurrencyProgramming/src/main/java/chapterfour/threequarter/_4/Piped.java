package chapterfour.threequarter._4;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class Piped {

	public static void main(String[] args) throws IOException {
		
		PipedWriter out = new PipedWriter();
		PipedReader in = new PipedReader();
		
		out.connect(in);
		
		Thread printThread = new Thread(new Print(in), "PrintThread");
		printThread.start();
		int receive = 0;
		try {
			while((receive = System.in.read()) != -1) {
				out.write(receive);
			}
		} finally {
			
			out.close();
		}
	}
	
	static class Print implements Runnable {
		
		private PipedReader in;
		public Print(PipedReader in) {
			super();
			this.in = in;
		}

		public void run() {

			int recive = 0;
			try {
				while ((recive = in.read()) != -1) {

//					System.out.println(recive);
					System.out.print((char) recive);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
