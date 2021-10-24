package polymorphism2;

public class SamsungTV implements TV{

    public SamsungTV() {
        System.out.println("===> SamsungTV 객체 생성");
    }

    //인터페이스에서 추상메서드를 상속받아 오버라이딩하였다.
    public void powerOn(){
        System.out.println("SamsungTV---전원 켠다.");
    }

    //오버로딩
    public void powerOn(int price){
        System.out.println("SamsungTV---전원 켠다.");
    }
    public void powerOff(){
        System.out.println("SamsungTV---전원 끈다.");
    }
    public void volumeUp(){
        System.out.println("SamsungTV---소리 올린다.");
    }
    public void volumeDown(){
        System.out.println("SamsungTV---소리 내린다.");
    }
}
