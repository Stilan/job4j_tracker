package oop;

public class Battery {
    private  int load;

    public Battery(int power){
        this.load = power;
    }
    public void exchange(Battery another){
        another.load = another.load + this.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery battery1 = new Battery(80);
        Battery battery2 = new Battery(15);
        System.out.println("battery1 power " + battery1.load + " battery2 power " + battery2.load);
        battery1.exchange(battery2);
        System.out.println("battery1 power " + battery1.load + " battery2 power " + battery2.load);
    }

}
