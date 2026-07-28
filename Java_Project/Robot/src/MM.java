public class MM extends Robot{

    public MM() {
        super();
    }
@Override
    public int ripristina(){
    int riparazioni=0;
    for(int i=0;i<this.getIndxmod();i++){
    if(!getModuli()[i].get_isOperative()){getModuli()[i].attiva(); riparazioni++;}
    }return riparazioni;
    }
@Override
    public void monitora() throws AlarmExeception{
    for(int i=0;i<this.getModuli().length;i++){
        if(getModuli()[i].get_Alert()){
        throw new AlarmExeception("Robot MM Allarme! Modulo in stato di allerta:"+getModuli()[i].getTipo());
    }
    }
    }


    }
