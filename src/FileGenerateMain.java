import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileGenerateMain {

	public static void main(String[] args) {
		String content = "Thank you for giving us the opportunity to serve your company " +  
	                "for the past two years. We want you to know that we have "+
				"appreciated your business and your prompt payments. Your cooperation has helped " +
	                "our business run smoothly and has led to a respectful business relationship " +
				" between our two companies. We look forward to many more years of mutually "+
	                "  beneficial association and wish your company the success that it deserves";
		Path filePath = Paths.get("customers.txt");
		File sourcefile = filePath.toFile();
		
		long startTime = System.currentTimeMillis();
		try {
			BufferedReader reader = new BufferedReader (new FileReader(sourcefile));
					
				String line = reader.readLine();
				while (line != null) {
					
			
					String filename = "files/" + line + ".txt";
					File fileObj = Paths.get(filename).toFile();
					System.out.println(fileObj.getAbsolutePath());
					PrintWriter writer = new PrintWriter(new BufferedWriter (new FileWriter(fileObj)));
					writer.println("Transaction History");
					writer.println("*******************");
					writer.println("Dear " + line + ",");
					writer.println(content);
					writer.println("Transaction Details");
					for(int i=0; i <10000; i++) {
						writer.println("Transaction#: " + i);
					}
					writer.println("Thank you for being a great customer.");
		 			writer.flush();
					writer.close();
					line = reader.readLine();
				}
				reader.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Time taken: " + (endTime - startTime) + "(ms)");
	}

}
