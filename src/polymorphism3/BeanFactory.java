package polymorphism3;

public class BeanFactory {

    public TV getTV(String id){
        if(id.equals("LG")){
            return new LGTV();
        } else if (id.equals("samsung")){
            return new SamsungTV();
        }
        return null;
    }
}
