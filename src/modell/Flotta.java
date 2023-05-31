package modell;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Flotta implements Serializable {

    private ArrayList<Hajo> hajok;

    public Flotta() {
        hajok = new ArrayList<>();
        hajok.add(new Hajo("CO207Y", 20));
        hajok.add(new Hajo("CO208C", 15));
        hajok.add(new Hajo("CO209C", 10));

    }

    public void jelentes() {
        try {
            FileOutputStream fajlki = new FileOutputStream("hajok.ser");
            ObjectOutputStream mentes = new ObjectOutputStream(fajlki);
            mentes.writeObject(this);
            mentes.close();
            fajlki.close();
            System.out.println("Az állapot sikeresen mentve lett a hajok.ser fájlba.");
        } catch (IOException e) {
            System.out.println("Hiba történt a fájl mentése során: " + e.getMessage());
        }
    }

    public Flotta frissites() {
        try {
            FileInputStream fajlbe = new FileInputStream("hajok.ser");
            ObjectInputStream mentettfajl = new ObjectInputStream(fajlbe);
            Flotta flotta = (Flotta) mentettfajl.readObject();
            mentettfajl.close();
            fajlbe.close();
            System.out.println("Az állapot sikeresen betöltve lett a hajok.ser fájlból.");
            return flotta;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Hiba történt a fájl betöltése során: " + e.getMessage());
            return new Flotta();
        }
    }

    public void hajotBeszerez(Hajo hajo) {
        hajok.add(hajo);
    }

    public void hajotLeszerel(String azon) {
        try {
            hajok.remove(hajoIndexetVisszaad(azon));
        } catch (Exception e) {
            System.out.println("A hajót nem sikerült leszerelni! hiba: " + e.getMessage());
        }
    }

    public int hajoIndexetVisszaad(String azon) {
        int index = 0;
        while (!azon.equals(hajok.get(index).getAzonosito())) {
            index++;
        }
        return index;
    }

    public Hajo hajotVisszaad(int index) {
        return hajok.get(index);
    }

    public void hajokLista() {
        for (Hajo hajo : hajok) {
            System.out.println("Azon: " + hajo.getAzonosito() + " Legénység száma: " + hajo.getLegenysegSzama());
        }
    }

    public void flottaMenteseSzovegeskent(Path path) throws IOException {
        try{
        Files.createFile(path);
        BufferedWriter writer = Files.newBufferedWriter(path);
        for (Hajo hajo : hajok) {
            writer.write("Azonosító: "+hajo.getAzonosito()+" legénység száma: "+hajo.getLegenysegSzama()+"\n");
        }
        writer.close();
        }catch(IOException ex){
            System.out.println("Hiba fájl irásakor:"+ex.getMessage());
        }
    }

    public int flottaMennyisege() {
        return hajok.size();
    }

}
