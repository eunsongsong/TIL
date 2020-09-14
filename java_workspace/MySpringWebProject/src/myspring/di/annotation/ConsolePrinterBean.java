package myspring.di.annotation;

import org.springframework.stereotype.Component;

@Component("ConsolePrinterBean")
public class ConsolePrinterBean implements IPrinter {
	public void print(String message) {
		System.out.println(message);
	}
}
