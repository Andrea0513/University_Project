public class GestioneStorage {
 public static void main(String[] args) {
// Creazione dello storage principale
CloudStorage<CloudItem<?>> storage = new CloudStorage<>();

FileStandard rapporto = new FileStandard("rapp", "ciap", 12);
FileStandard foto = new FileStandard("pict", "dept", 30);

 FileSensibile paziente = new FileSensibile("paz", "cazz", 10, "alto", true);
FileSensibile brevetto = new FileSensibile("ciao", "bvao", 45,"basso", false);



CloudItem<FileStandard> item1 = new CloudItem<FileStandard>(34.4, foto);
 CloudItem<FileStandard> item2 = new CloudItem<FileStandard>(32, rapporto);
 CloudItem<FileSensibile> item3 =new CloudItem<FileSensibile>(12.3, brevetto);
CloudItem<FileSensibile> item4 = new CloudItem<FileSensibile>(33, paziente);


storage.aggiungi(item1);
storage.aggiungi(item2);
storage.aggiungi(item3);
storage.aggiungi(item4);


storage.ordina();
storage.stampasufile("storage.txt");


storage.backup();

}
}