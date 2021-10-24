package polymorphism1;

public class TVUser {
    public static void main(String[] args) {

//        SamsungTV tv = new SamsungTV();
//
//        tv.powerOn();
//        tv.volumeUp();
//        tv.volumeDown();
//        tv.powerOff();

        LGTV tv = new LGTV();

        tv.turnOn();
        tv.soundUp();
        tv.soundDown();
        tv.turnOff();

    }
}
