package clock;

import java.applet.Applet;
import java.awt.Graphics;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Clock extends Applet implements Runnable {

	private static final long serialVersionUID = 1L;
	Thread t, t1;

	public void start() {
		t = new Thread(this);
		t.start();

	}

	public void run() {
		t1 = Thread.currentThread();
		while (t1 == t) {
			repaint();

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}

	public void paint(Graphics g) {

		Calendar cal = new GregorianCalendar();

		String hour = String.valueOf(cal.get(Calendar.HOUR));
		String minute = String.valueOf(cal.get(Calendar.MINUTE));
		String second = String.valueOf(cal.get(Calendar.SECOND));

		g.drawString(hour + ":" + minute + ":" + second, 20, 30);
	}
}
