package java8samples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author marios
 */
public class PassingCodeExample {

    public static void main(String[] args) {
        Car green = new Car();
        green.make = "Mercedes";
        green.color = "green";
        green.year = 10;

        Car red = new Car();
        red.make = "BMW";
        red.color = "red";
        red.year = 5;

        Car white = new Car();
        white.make = "Renault";
        white.color = "white";
        white.year = 15;

        List<Car> cars = Arrays.asList(red, white, green);

        //filter white cars
        List<Car> whiteCars = filterCars(cars, Car::isWhiteCar);
        whiteCars.stream().forEach(n -> System.out.println(n.getMake()));

        //filter old cars
        List<Car> oldCars = filterCars(cars, Car::isOldCar);
        oldCars.stream().forEach(n -> System.out.println(n.getColor() + " " + n.getMake() + " " + n.getYear()));

        //use other custom predicates - Green cars, more than 10 y.o.
        List<Car> oldAndGreenCars = filterCars(cars, (Car c) -> "green".equals(c.getColor()) || c.getYear() >= 10);
        oldAndGreenCars.stream().forEach(n -> System.out.println(n.getColor() + " " + n.getMake() + " " + n.getYear()));
    }

    private static List<Car> filterCars(List<Car> cars, Predicate<Car> p) {
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            if (p.test(car)) {
                result.add(car);
            }
        }
        return result;
    }

    private static class Car {

        private String make;
        private String color;
        private int year;

        public void Car(String make, String color, int year) {
            this.make = make;
            this.color = color;
            this.year = year;
        }

        public String getMake() {
            return make;
        }

        public void setMake(String make) {
            this.make = make;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public static boolean isWhiteCar(Car car) {
            return "white".equals(car.getColor());
        }

        public static boolean isOldCar(Car car) {
            return car.getYear() > 10;
        }

        public static boolean isBMWCar(Car car) {
            return "BMW".equals(car.getMake());
        }
    }

}
