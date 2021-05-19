package utils;

public class Sleep {
    public static void sleep(){
        try{
            Thread.sleep(50000);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
