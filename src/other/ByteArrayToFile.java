package other;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class ByteArrayToFile {
	public static void main(String[] args) throws IOException {
		InputStream inputStream =new FileInputStream("");
		
		FileOutputStream outputStream=new FileOutputStream("");
		OutputStreamWriter writer=new OutputStreamWriter(outputStream,"UTF-8");
		writer.append("abc");
		writer.close();
		outputStream.close();
		
	}

}
