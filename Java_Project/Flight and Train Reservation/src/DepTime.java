public class DepTime {
private int ore;
private int minuti;

public DepTime(int ore, int minuti){
this.ore=ore;
this.minuti=minuti;
}

public int getOre() {
    return ore;
}
public int getMinuti() {
    return minuti;
}

@Override
public String toString(){
    return "Departure time: "+getOre()+":"+getMinuti();
}
}
