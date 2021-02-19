package ru.job4j.tracker.builder;

public class Car {
   private String machineBrand;

   private String model;

   private int yearOfRelease;

   private double engineVolume;

   private int speed;

    @Override
    public String toString() {
        return "Car{"
                + "machineBrand='" + machineBrand + '\''
                + ", model='" + model + '\''
                + ", yearOfRelease=" + yearOfRelease
                + ", engineVolume=" + engineVolume
                + ", speed=" + speed
                + '}';
    }

    static class BuilderCar {
       private String machineBrand;
       private String model;
       private int yearOfRelease;
       private double engineVolume;
       private int speed;

       BuilderCar builderMachineBrand(String machineBrand) {
           this.machineBrand  = machineBrand;
           return this;
       }

       BuilderCar builderModel(String model) {
           this.model  = model;
           return this;
       }

       BuilderCar builderYearOfRelease(int yearOfRelease) {
           this.yearOfRelease  = yearOfRelease;
           return this;
       }

       BuilderCar builderEngineVolume(double engineVolume) {
           this.engineVolume  = engineVolume;
           return this;
       }

       BuilderCar builderSpeed(int speed) {
           this.speed  = speed;
           return this;
       }

       Car builder() {
           Car car = new Car();
           car.machineBrand = machineBrand;
           car.model = model;
           car.engineVolume = engineVolume;
           car.yearOfRelease = yearOfRelease;
           car.speed = speed;
           return car;
       }
   }

    public static void main(String[] args) {
        Car car = new BuilderCar().builderMachineBrand("Machine Brand")
                .builderModel("Model")
                .builderYearOfRelease(1999)
                .builderEngineVolume(1.2)
                .builderSpeed(180)
                .builder();
        System.out.println(car);
    }

}
