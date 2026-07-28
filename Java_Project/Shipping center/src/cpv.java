public class cpv implements Comparator<Box<?>> {
public int compare(Box<?> a, Box<?> b){
return Double.compare(a.getVolume(),b.getVolume());
}
}
