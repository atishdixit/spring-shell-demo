package com.ext.comand.config;

import org.jline.reader.LineReader;
import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.shell.jline.PromptProvider;

@Configuration
public class Config {
	
	@Bean
	public InputReader inputReader(@Lazy LineReader lineReader) {
	    return new InputReader(lineReader);
	}
	
	@Bean
	public PromptProvider getPrompt() {
		return () -> new AttributedString("prompt > ", AttributedStyle.DEFAULT.background(AttributedStyle.RED));

	}
}
