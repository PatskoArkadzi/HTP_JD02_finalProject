package by.htp.cinema.web.util;

public class TimerDaemon implements Runnable {

	private static final long RESERVATION_PERIOD = 1 * 60000L;// 1 min
	private static long secondsDisplay;
	private static long minutesDisplay;

	public static long getSecondsDisplay() {
		return secondsDisplay;
	}

	public static long getMinutesDisplay() {
		return minutesDisplay;
	}

	@Override
	public void run() {
		long startTime = System.currentTimeMillis();
		long endTime = startTime + RESERVATION_PERIOD;
		long elapsedTime;
		long remainingSeconds;
		while (System.currentTimeMillis() < endTime) {
			elapsedTime = System.currentTimeMillis() - startTime;
			remainingSeconds = (RESERVATION_PERIOD - elapsedTime) / 1000;
			secondsDisplay = remainingSeconds % 60;
			minutesDisplay = remainingSeconds / 60;
			try {
				System.out.println(String.format("%02d : %02d", minutesDisplay, secondsDisplay));
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}