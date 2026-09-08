package observer.weather_station;

public class WindowDisplay implements WeatherObserver{

    @Override
    public void update(int temperature){

        System.out.println("Window display : Outside temperature is "
                + temperature + "°C"
        );

    }
}
