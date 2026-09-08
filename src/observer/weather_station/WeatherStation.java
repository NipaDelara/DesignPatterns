package observer.weather_station;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherStation extends Thread {

    private final boolean running =true;

    public WeatherStation() {
        List<WeatherObserver> observers = new ArrayList<>();
        Random random = new Random();


        int MAX_TEMPERATURE = 35;
        int MIN_TEMPERATURE = -10;
        int temperature = random.nextInt(
                MAX_TEMPERATURE - MIN_TEMPERATURE + 1
        ) + MIN_TEMPERATURE;
        System.out.println("Initial temperature: "  + temperature +"°C");
    }

}
