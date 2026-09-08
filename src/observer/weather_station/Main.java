package observer.weather_station;

public class Main {
    public static void main(String[] args)
        throws InterruptedException{

            WeatherStation station =
                    new WeatherStation();
            PhoneDisplay phoneDisplay =
                    new PhoneDisplay();

            WindowDisplay windowDisplay =
                    new WindowDisplay();

            WebDisplay webDisplay =
                    new WebDisplay();

        station.registerObserver(phoneDisplay);
        station.registerObserver(windowDisplay);
        station.registerObserver(webDisplay);

        station.start();

        Thread.sleep(12000);

        System.out.println(
                "\n--- Removing PhoneDisplay ---"
        );
        station.removeObserver(phoneDisplay);

        Thread.sleep(10000);

        station.stopStation();

        station.join();

        System.out.println(
                "\nSimulation finished."
        );

    }
}
