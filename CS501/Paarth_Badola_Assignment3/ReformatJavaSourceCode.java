import java.io.*;
import java.util.Scanner;

// Paarth Badola
// 20012789

public class ReformatJavaSourceCode {
	public static void main(String[] args) {
		// operations
		// file object
		File sourceFile = new File("src\\Test.java");
		
		// checking for file
		if(!sourceFile.exists()) {
			System.out.println("File does not exist.");
			System.exit(0);
		}
		
		// declaring string builder object to make changes in string
		StringBuilder sBuilder = new StringBuilder();
		try {
			Scanner sc = new Scanner(sourceFile);
			// checking if scanner has next token
			while(sc.hasNext()) {
				// giving string s the Line 
				String s = sc.nextLine();
				
				// if string has "{" we will append { to sBuilder
				if (s.contains("{")) {
					
					sBuilder.append("{");
					//sBuilder.append("\n");
				}
				// else we just append the string
				else {
					sBuilder.append("\n");
					sBuilder.append(s);
				}
			}
			System.out.println(sBuilder);
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
		
		try {
			PrintWriter outFile = new PrintWriter(sourceFile);
			// clear file
			outFile.write(sBuilder.toString());
			outFile.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }
}
		
