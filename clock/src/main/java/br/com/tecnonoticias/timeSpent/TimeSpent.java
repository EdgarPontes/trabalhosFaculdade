package br.com.tecnonoticias.timeSpent;

import java.util.Calendar;

public class TimeSpent {
	
	public long init(){
		Calendar c = Calendar.getInstance(); 
		System.out.println("Data e Hora atual: " + c.getTime());
		System.out.println();
		long init = System.nanoTime();
		return init;
	}
	

	public long end(){
		long end  = System.nanoTime();
		return end;
	}
	
	public void initAndEnd(long init, long end){
		double milliSeconds = (double)((end - init) / 1000000.0);
		System.out.println();
		System.out.println( "tempo gasto : " + milliSeconds + " milesegundos");
		System.out.println();
		Calendar c = Calendar.getInstance(); 
		System.out.println("Data e Hora atual: " + c.getTime());
		System.out.println();
		
	}
	
	public static void main(String[] args) {
		TimeSpent time = new TimeSpent();
		long init = time.init();
		for (int i = 0; i < 10000; i++) {
			System.out.print(i + " ");
		}
		long end = time.end();
		time.initAndEnd(init, end);
	}
}
