package com.ext.comand.practice;

import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import org.springframework.shell.standard.ShellOption;
//Spring Shell is built on top of JLine which offers useful features like tab completion and built in commands.
@ShellComponent
public class Commands {


	private boolean signedIn;
	private boolean isTest = true;
	
    @ShellMethod(key = "hello", value = "It will greet you!")
    public String hello(@ShellOption(defaultValue = "Robot") String arg){
        return "Hello "+arg+"!";
    }

    @ShellMethod(key = "bye", value = "It will say good bye!")
    public String bye(@ShellOption(defaultValue = "Robot") String arg){
        return "Bye "+arg+"!";
    }
    
    @ShellMethod(value = "Add numbers.", key = "sum")
    public int add(int a, int b) {
    	return a + b;
    }
    

	@ShellMethod(value = "sign in")
	public void signIn() {
		this.signedIn = true;

	}

	@ShellMethod(value = "sign out")
	public void signOut() {
		this.signedIn = false;

	}

	public Availability signOutAvailability() {
		return signedIn ? Availability.available() : Availability.unavailable("Must be signed in first");
	}
	
	@ShellMethod(value = "test") 
	@ShellMethodAvailability("checkTest") 
	public void test(boolean isTest) {    
	    this.isTest = isTest;
	    System.out.println("Hello.."+ isTest);
	}  
		
	public Availability checkTest() {    
	   return this.isTest ?  Availability.available() : Availability.unavailable("Message to test"); 
	}  
}
