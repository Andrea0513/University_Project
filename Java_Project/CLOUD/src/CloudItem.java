public class CloudItem<T extends FileStandard> implements Clone<CloudItem<T>>,Comparable<CloudItem<T>> {
private int ID;
private double dimensione;
private T item;
private static int contatore=1;

public CloudItem(double dimensione, T item) {
    this.ID= contatore++;
    this.dimensione = dimensione;
    this.item = item;
    
}




public double getCharge(){
return item.costotot(this.dimensione);
}


public int getID() {
    return ID;
}


public double getDimensione() {
    return dimensione;
}

@Override
public int compareTO(CloudItem<T> test){
return Double.compare(getDimensione(),test.getDimensione());
}


@Override
public String toString() {
    return "ID: " + ID + " | dimensione: " + dimensione + " | " + " Costo: "+getCharge();
}




@Override
public CloudItem<T> clonazione() {
    @SuppressWarnings("unchecked")
    T clonedFile = (T) item.clonazione();
        CloudItem<T> cloni = new CloudItem<T>(dimensione, clonedFile);
        return cloni;
}


}
