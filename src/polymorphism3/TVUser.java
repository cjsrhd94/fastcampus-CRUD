package polymorphism3;

public class TVUser {
    public static void main(String[] args) {

//        SamsungTV tv = new SamsungTV();
//
//        tv.powerOn();
//        tv.volumeUp();
//        tv.volumeDown();
//        tv.powerOff();


        BeanFactory beanFactory = new BeanFactory();
        TV tv = beanFactory.getTV(args[0]);
        
        tv.powerOn();
        tv.volumeUp();
        tv.volumeDown();
        tv.powerOff();
        
    }
}
