package com.javarush.test.level17.lesson10.home02;

/* Comparable
Реализуйте интерфейс Comparable<Beach> в классе Beach, который будет использоваться нитями.
*/

public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public static void main(String[] args) {
        Beach beach1 = new Beach("beach", 1.0f, 2);
        Beach beach2 = new Beach("beach", 2.0f, 1);
        System.out.println(beach1.compareTo(beach2));
    }

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    @Override
    public synchronized int compareTo(Beach obj) {
        int distanceParam = (int) (distance - obj.getDistance());
        int qualityParam = quality - obj.getQuality();
        return 10000 * name.compareTo(obj.getName()) + 100 * distanceParam + qualityParam;
    }


}
