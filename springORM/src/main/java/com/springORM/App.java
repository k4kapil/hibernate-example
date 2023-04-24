package com.springORM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springORM.dao.StudentDAO;
import com.springORM.entity.Student;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        
        ApplicationContext context= new ClassPathXmlApplicationContext("config.xml");
        StudentDAO studDAO= context.getBean("studentDAO",StudentDAO.class);
        Student student= new Student();
        do
          {
        	System.out.println("************************************************");
	        System.out.println("*******Welcome to Spring ORM application********");
	        System.out.println("************************************************");
	        System.out.println("Select from the following options :");
	        System.out.println("1. Insert the details of Student--");
	        System.out.println("2. View the list of all Students--");
	        System.out.println("3. View the details of single student--");
	        System.out.println("4. Update the detials of the student--");
	        System.out.println("5. Delete Student--");
	        System.out.println("6. Exit--");
	        System.out.println("Enter the value from the options listed above :");
	        int num=Integer.parseInt(br.readLine());
       
        	 switch(num)
             {
             	case 1:
             	
             	System.out.println("Enter the following details :Name, Subject, Mobile Number :");
             	String name= br.readLine();
             	String subject= br.readLine();
             	String mobile= br.readLine();
             	student.setStuName(name);
             	student.setSubject(subject);
             	student.setMobileNo(mobile);
             	int i= studDAO.insertStudent(student);
             	System.out.println("You entered Name : "+ name+", Subject : "+subject+ ", Mobile Number : "+mobile);
             	System.out.println(i+" : record inserted successfully");
             			break;
             
             	case 2:
             		List<Student> list= new ArrayList<Student>();
             		list= studDAO.getAllStudents();
             		System.out.println("List of Students");
             		System.out.printf("%-15s %-15s %-15s %-15s","Student ID","Name","Subject","Mobile number");
             		System.out.println();  
             		for(Student s : list) 
					  {
					    System.out.printf("%-15s %-15s %-15s %-15s",s.getStuId(),s.getStuName(),s.getSubject(),s.getMobileNo()); 
					    System.out.println(); 
					  }
					 break;
             			
             	case 3:
             		System.out.println("Enter the ID of the student :"); 
             		int id=Integer.parseInt(br.readLine());
             		Student stud= studDAO.getStudent(id);
             		if(stud==null)
             		{
             			System.out.println("Id does not exists.");
             		}
             		else
             		{
             			System.out.println("The details of the Student");
                 		System.out.printf("%-15s %-15s %-15s %-15s","Student ID","Name","Subject","Mobile number");
                 		System.out.println();
                 		System.out.printf("%-15s %-15s %-15s %-15s",stud.getStuId(),stud.getStuName(),stud.getSubject(),stud.getMobileNo());
                 		System.out.println();
             		}
             		  	break;
             
             	case 4:
             		System.out.println("Enter the ID of the student you want to update :"); 
             		int id2=Integer.parseInt(br.readLine());
             		Student stud1= studDAO.findStudent(id2);
             		if(stud1==null)
             		{
             			System.out.println("Id does not exists.");
             			
             		}
             		else
             		  {             			             	        
                     		Student student1= new Student();
                     		System.out.println("Enter the value you want to update: Name, Subject, Mobile Number ");
                     		String name1= br.readLine();
                     		String sub1= br.readLine();
                     		String mob1= br.readLine();
                     		
                     		student1.setStuId(id2);
                     		student1.setStuName(name1);
                     		student1.setSubject(sub1);
                     		student1.setMobileNo(mob1);
                     		studDAO.updateStudent(student1);
                     		
                     		System.out.println("Student details updated Succcessfully");
                 	    }             	             		            		            		
             				break;
             	
             	case 5:
             		System.out.println("Enter the ID of the student you want to delete :"); 
             		int id3=Integer.parseInt(br.readLine());
             		Student stud2= studDAO.findStudent(id3);
             		if(stud2==null)
             		{
             			System.out.println("Can not delete because Id does not exists.");
             		}
             		else
             		{
             			studDAO.deleteStudent(id3);
             			System.out.println("Deleted Successfully.");
             		}
             		
             			break;
             	
             	case 6:
             		System.out.println("Thanks for using the application....");
             		System.exit(0);
             		
             	default :
             		System.out.println("Wrong selection!!!");
             		
             }
         
          }while(true);
       
    }
}
