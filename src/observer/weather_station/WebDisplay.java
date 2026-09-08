package observer.weather_station;

public class WebDisplay implements WeatherObserver {

    @Override
    public void update(int temperature){

        System.out.println(  "Web display: Weather updated to "
                + temperature + "°C"
        );

    }
}
