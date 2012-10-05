package test;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class VLFileReader {
		
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		File ff = new File("C:\\Users\\pammi\\Documents\\MATLAB\\01\\frame_001.vl");
		FileInputStream file_in=new FileInputStream(ff);
		DataInputStream reader=new DataInputStream(file_in);

		byte[] longBytes = new byte[4];
		reader.read(longBytes);
		
		int kk = ByteBuffer.wrap(longBytes).order(ByteOrder.LITTLE_ENDIAN).getInt();
		System.err.println("kk: "+ kk);
		
		for (int i=0; i<kk; i++ ) {
			
			reader.read(longBytes);
			double f1 = ByteBuffer.wrap(longBytes).order(ByteOrder.LITTLE_ENDIAN).getFloat();
			reader.read(longBytes);
			double f2 = ByteBuffer.wrap(longBytes).order(ByteOrder.LITTLE_ENDIAN).getFloat();
			reader.read(longBytes);
			double f3 = ByteBuffer.wrap(longBytes).order(ByteOrder.LITTLE_ENDIAN).getFloat();
			
			System.err.println(f1+" "+f2+" "+f3);
		}
	}

}
