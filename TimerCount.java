import java.util.TimerTask;
import java.util.Timer;
/**
 * Implements a timer feature for our game
 * If times reaches 0, the bomb will explode and HARAMBE will die!
 *
 * @author Vu Duc Le
 * @version 0.1
 */
public class TimerCount extends TimerTask {

    public static int countdown = 10;
    public void run() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new CountDownTask(), 0, 60 * 1000);

        try {
            Thread.sleep(15 * 60 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        timer.cancel();

    }

    static class CountDownTask extends TimerTask {
        public void run() {
            if (countdown > 0) {
                System.out.println("Countdown: " + countdown + " minutes");
                countdown--;
            } else {
                System.out.println("Game Over! The bomb has been exploded. Team Terrorists wins!");
                System.out.println("Harambe is dead again!");
                cancel();
            }
        }
    }
}

