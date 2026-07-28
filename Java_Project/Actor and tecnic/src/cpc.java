public class cpc implements Comparator<Membro>{
public int compare(Membro test1,Membro test2){
return test1.getContratto().Calcolacost()-test2.getContratto().Calcolacost();

}
}
