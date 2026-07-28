public abstract class Notifica implements Notificabile{
private int priority;


public Notifica(int priority) {
    if(priority <=5 )this.priority = priority;
    else this.priority=5;
}

@Override
public abstract void showNotification();



public int getPriority() {
    return priority;
}


@Override
public String toString() {
    return getClass().getSimpleName()+ " [priority=" + priority ;
}


public void setPriority(int priority) {
    this.priority = priority;
}


}
