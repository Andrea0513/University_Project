public class Messaggio extends Notifica {
private String msg;

public Messaggio(int priority, String msg) {
    super(priority);
    this.msg = msg;
}

public String getMsg() {
    return msg;
}

@Override
public void showNotification(){
System.out.println(toString());
}





@Override
public String toString() {
    return super.toString()+ ", msg=" + msg + "]";
}






}
