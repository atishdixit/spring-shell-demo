package com.ext.comand.login;


import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import jakarta.validation.constraints.Size;

@ShellComponent
public class SSHCommand {

	
	/**
	 * // -s command takes a parameter named -s. like // shell:>ssh -s my-machine
	 */
	//@ShellMethod(value = "connect to remote server") //default name as method name like ssh
	@ShellMethod(key = "my-ssh", value = "connect to remote server") 
	public void ssh(@ShellOption(value = "-s") String remoteServer) { 															
		System.out.println(String.format("Logged to machine '%s'", remoteServer));
	}

	
	@ShellMethod(value = "add keys") //ssh-add --k test1 test2 
	public void sshAdd(@ShellOption(value = "--k", arity = 2) String[] keys) {    
		System.out.println(String.format("Adding keys '%s' '%s'", keys[0], keys[1])); 
	}
	
	@ShellMethod(value = "sign in") 
	public void sshLogin(@ShellOption(value = "--r") boolean rememberMe){ //sh:>ssh-agent --a t    
		System.out.println(rememberMe);
	}  
	
	@ShellMethod(value = "ssh agent")
	public void sshAgent( @ShellOption(value = "--a") @Size(min = 5, max = 10) String agent) {    
		System.out.println(agent);
	}  
}
