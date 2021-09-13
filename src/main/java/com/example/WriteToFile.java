package com.example;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

import org.cdgsoftware.icl.ICLFile;
import org.cdgsoftware.icl.reader.ICLReader;
import org.cdgsoftware.icl.util.FileEncoding;
import org.cdgsoftware.icl.writer.ICLFileWriter;

public class WriteToFile {
	
	private final File baseFolder = new File(
			"C:/New folder");
	final File outputFile = new File(baseFolder, "x9readCsvWriteX9.x9");

	/*
	 * public static void main(String[] args) { // TODO Auto-generated method stub
	 * 
	 * try {
	 * 
	 * 
	 * File inputFile = new File("C:/Users/palla/Downloads/Docs/00030796.tif"); File
	 * outputFile = new File("C:/New folder/filenameX9WithImage.x9"); BufferedImage
	 * image = ImageIO.read(inputFile); ImageIO.write(image, "x9", outputFile);
	 * 
	 * for (String format : ImageIO.getReaderFormatNames()) {
	 * System.out.println("format = " + format); }
	 * 
	 * for (String format : ImageIO.getReaderMIMETypes()) {
	 * System.out.println("format = " + format); }
	 * 
	 * FileWriter myWriter = new FileWriter("C:/New folder/filenameX9.x9");
	 * myWriter.write("Files in Java might be tricky, but it is fun enough!");
	 * myWriter.close(); System.out.println("Successfully wrote to the file."); }
	 * catch (IOException e) { System.out.println("An error occurred.");
	 * e.printStackTrace(); }
	 * 
	 * }
	 */
	
	public static void main(final String[] args) {
        try {
        	
        	//parsing a CSV file into Scanner class constructor  
        	/*Scanner sc = new Scanner(new File("C:/Users/palla/Downloads/Docs/importFile.csv"));  
        	sc.useDelimiter(",");   //sets the delimiter pattern  
        	while (sc.hasNext())  //returns a boolean value  
        	{  
        		System.out.print(sc.next());  //find and returns the next complete token from this scanner  
        	*/
        	
            final ICLReader reader = new ICLReader(new FileInputStream("C:/Users/palla/Downloads/Docs/00030789.tif"));
            final ICLFile iclFile = reader.readICLFile();
            iclFile.setFileEncoding(FileEncoding.ASCII);
            iclFile.saveAllImages("c:\\New folder");
            final File fOut = new File("C:/New folder/filenameX9WithImage.x9");
            final ICLFileWriter writer = new ICLFileWriter(iclFile, fOut);
            writer.writeFile();
        	//}   
        	//sc.close();  //closes the scanner
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

}
