
package modell;

import java.io.Serializable;

public class Hajo implements Serializable{
    private String azonosito;
    private int legenysegSzama;
    
    public Hajo(String azon, int legenysegSzama){
        setAzonosito(azon);
        setLegenysegSzama(legenysegSzama);
    }

    public String getAzonosito() {
        return azonosito;
    }

    public int getLegenysegSzama() {
        return legenysegSzama;
    }

    public void setAzonosito(String azonosito) {
        this.azonosito = azonosito;
    }

    private void setLegenysegSzama(int legenysegSzama) {
        this.legenysegSzama = legenysegSzama;
    }
}
