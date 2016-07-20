package br.com.tecnonoticias.timeSpent;

import java.time.Duration;
import java.time.Instant;

public class TimeSpentInstant {
	
	public Instant init(){
//		Calendar c = Calendar.getInstance(); 
//		System.out.println("Data e Hora atual: " + c.getTime());
		System.out.println();
		Instant init = Instant.now();
		System.out.println(init); //2014-04-08T10:02:52.036Z (formato ISO-8601)
		return init;
	}
	

	public Instant end(){
		Instant end = Instant.now();
		System.out.println();
		System.out.println(end);
		return end;
	}
	
	public void initAndEnd(Instant init, Instant end){
		
		Duration duracao = Duration.between(init, end);
		long duracaoEmMilissegundos = duracao.toMillis();
		
		System.out.println();
		System.out.println( "tempo gasto : " + duracaoEmMilissegundos + " milesegundos");
		System.out.println();
//		Calendar c = Calendar.getInstance(); 
//		System.out.println("Data e Hora atual: " + c.getTime());
//		System.out.println();
		
	}
	
	public static void main(String[] args) {
		TimeSpentInstant timeInstant = new TimeSpentInstant();	
		TimeSpent time = new TimeSpent();
		
		long init = time.init();
		Instant initInstant = timeInstant.init();
		for (int i = 0; i < 50; i++) {
			System.out.print(i + " ");
		}
		Instant endInstant = timeInstant.end();
		long end = time.end();
		timeInstant.initAndEnd(initInstant, endInstant);
		time.initAndEnd(init, end);
	
	}
}
