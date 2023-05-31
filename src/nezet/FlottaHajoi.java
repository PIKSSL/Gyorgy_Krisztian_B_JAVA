
package nezet;

import modell.Flotta;
import modell.Hajo;

public class FlottaHajoi {
    
    public static void main(String[] args) {
        Flotta flotta = new Flotta();
        flotta.hajotBeszerez(new Hajo("CO210Y",15));
        flotta.jelentes();
        System.out.println(flotta);
        flotta.hajokLista();
        flotta = null;
        System.out.println(flotta);
        flotta = new Flotta().frissites();
        System.out.println(flotta);
        flotta.hajokLista();
        
    }
}
