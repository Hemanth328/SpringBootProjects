package com.org.runners;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.org.entity.PersonInfo;
import com.org.service.IPersonInfoMgmtService;

@Component
public class LobsTestRunner implements CommandLineRunner {

	@Autowired
	private IPersonInfoMgmtService service;

	@Override
	public void run(String... args) throws Exception {

		/*	
			
			// Saving to LOB
			
			Scanner sc = new Scanner(System.in);
			System.out.println("\nEnter Name : ");
			String name = sc.nextLine();
			System.out.println("\nIs Married : ?");
			boolean married = sc.nextBoolean();
			System.out.println("\nEnter Image Path");
			String imagePath = sc.next();
			System.out.println("\nEnter Resume Path");
			String resumePath = sc.next();
			
			
			// create byte[] representing photo file content
			InputStream is = new FileInputStream(imagePath);  
			byte[] photoContent = new byte[is.available()];  // creating a byte array with the size available in the file
			photoContent = is.readAllBytes();  
			
			
			//create char[] representing resume file content
			Reader  reader = new FileReader(resumePath);
			File file = new File(resumePath);
			char[] resumeContent = new char[(int)file.length()]; // creating a char array of the size same as file
			reader.read(resumeContent);
			
			PersonInfo info = new PersonInfo(-1, name, LocalDateTime.of(1995, 12, 11, 06, 00), married, photoContent, resumeContent);
			
			try {
				System.out.println(service.registerPersonInfo(info));
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			
			 * C:\\Users\\heman\\Desktop\\Collection.png
		
				Enter Resume Path
				C:\\Users\\heman\\Downloads\\reddy-hemanth-kumar1.pdf
			 
		
			*/
		
		    // Retrieving LOB's Fromt the DB
		System.out.println("\n==========================================================\n");
		
		//Logic to retieve the object
		try {
			PersonInfo info = service.fetchPersonDetailsById(52);
			
			if(info != null) {
				System.out.println(info.getPid()+"  "+info.getPname()+"  "+info.getDob());
				
				byte[] photoContent = info.getPhoto();
				OutputStream os = new FileOutputStream("retrieved_photo.png");
				os.write(photoContent);
				os.flush();
				os.close();
				
				System.out.println("Photo Retrieved from DB table col");
				
				char[] resumeContent = info.getResume();
				Writer writer = new FileWriter("retrieve_resume.txt");
				writer.write(resumeContent);
				writer.flush();
				writer.close();
				
			} else {
				System.out.println("Record Not Found !");
			}
		}  catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
