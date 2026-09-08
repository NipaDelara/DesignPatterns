package observer.weather_station;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherStation extends Thread {

    private final List<WeatherObserver> observers;
    private final Random random;

    private int temperature;

    private final int MAX_TEMPERATURE = 35;
    private final int MIN_TEMPERATURE = -10;

    private volatile boolean running = true;

    public WeatherStation() {
        observers = new ArrayList<>();
        random = new Random();

        temperature = random.nextInt(
                MAX_TEMPERATURE - MIN_TEMPERATURE + 1
        ) + MIN_TEMPERATURE;
        System.out.println("Initial temperature: "  + temperature +"°C"
        );
    }
    public void registerObserver(WeatherObserver observer) {

        observers.add(observer);

        System.out.println(
                "Observer registered: "
                        + observer.getClass().getSimpleName()
        );
    }
    public void removeObserver(WeatherObserver observer) {

        observers.remove(observer);

        System.out.println(
                "Observer removed: "
                        + observer.getClass().getSimpleName()
        );
    }
    private void notifyObservers() {
        for (WeatherObserver observer : observers) {
            observer.update(temperature);

        }
    }
        private void updateTemperature() {

            int change;

            if (random.nextBoolean()) {
                change = 1;
            } else {
                change = -1;
            }

            int newTemperature =
                    temperature + change;

            if (newTemperature >= MIN_TEMPERATURE
                    && newTemperature <= MAX_TEMPERATURE) {

                temperature = newTemperature;
            }

            System.out.println(
                    "\nWeather Station: Temperature changed to "
                            + temperature + "°C"
            );

            notifyObservers();
        }
        @Override
        public void run() {

            while (running) {

                try {

                    int waitTime =
                            random.nextInt(5) + 1;

                    Thread.sleep(
                            waitTime * 1000L
                    );

                    updateTemperature();

                } catch (InterruptedException e) {

                    if (!running) {
                        break;
                    }

                    Thread.currentThread().interrupt();
                    break;
                }
            }

            System.out.println(
                    "\nWeather station stopped."
            );
        }

        public void stopStation() {

            running = false;

            interrupt();
    }
}

