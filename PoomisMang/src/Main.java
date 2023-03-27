import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.round;

public class Main {

    /**
     *
     * @return
     * @throws IOException
     */
    public static String genereeriSona() throws IOException {
        List<String> koikSonad;
        koikSonad = sõnadFaili.sonadMassiivi("K_sõnad.txt"); // Teen etteantud sõnadest uue massiivi
        //System.out.println(Arrays.toString(new List[]{koikSonad}));
        int sonadeArv = koikSonad.size();
        //System.out.println(koikSonad.size());
        int valitavaSonaIndeks = (int) round(Math.random() * (sonadeArv));

        return koikSonad.get(valitavaSonaIndeks);
    }

    public static void main(String[] args) throws IOException {
        String arvatavsõna = genereeriSona(); // genereerin juhuslikult sõna, mida mängija hakkab arvama.
        arvatavsõna = arvatavsõna.toLowerCase(); // muudan genereeritud sõna kõik tähed väikesteks.
        System.out.println(arvatavsõna);
        int pikkus = arvatavsõna.length(); // leian genereeritud sõna pikkuse.
        System.out.println(pikkus);
        String pakutavSõna = "-".repeat(pikkus); // panen paika arvatava sõna kuju.
        char[] pakutudTähed = new char[0]; // loon listi, kus hakkan koguma pakutud tähti.
        mäng mängija = new mäng(arvatavsõna, pakutavSõna, 0, 0, pakutudTähed); // loon mäng isendi, kus salvestatakse mängu infot.
        Scanner mängijaArvab = new Scanner(System.in);
        int indeks = 0;

        while (!mängija.getPakutavSõna().equals(mängija.getArvatavSõna())) {
            System.out.println("Oled pakkunud tähti: " + Arrays.toString(mängija.getPakutudTähed()) +
                    " Praegu on ära arvatud: " + mängija.getPakutavSõna() + "\nPalun paku järgmine täht: ");


            String mängijaArvamus = mängijaArvab.nextLine();// mängija sisestab uue tähe.
            char pakkumine = mängijaArvamus.charAt(0); // muudan mängija pakkumise char-iks.
            mängija.setPakkumisteArv(mängija.getPakkumisteArv()+1); // suurendan mängija pakkumiste arvu ühe võrra.

            if (mängijaArvamus.length() > 1) { // kontrollin, kas mängija sisestas ainult ühe tähe.
                System.out.println("Palun paku ainult ÜKS täht!");
                continue;
            }

            char[] pakutudTähedUus = Arrays.copyOf(mängija.getPakutudTähed(), indeks+1); // loon uue listi, kuhu lisan mängija pakutud tähe.
            pakutudTähedUus[indeks++] = pakkumine;
            mängija.setPakutudTähed(pakutudTähedUus);

            if (arvatavsõna.indexOf(pakkumine) != -1) { // kontrollin, kas mängija pakkumine esineb otsitavas sõnas.
                System.out.println("Tubli! Pakutud täht: " + pakkumine + " esines otsitavas sõnas!");
            } else {
                System.out.println("Pakutud täht ei esinenud otsitavas sõnas.");
                mängija.setVigadeArv(mängija.getVigadeArv()+1);
            }

            try { // kontrollin, millisel kohal sõnas esines mängija pakkumine ning seejärel vahetan arvatavas sõnas vastava tähe.
                if (mängija.getArvatavSõna().charAt(0) == pakkumine) {
                    pakutavSõna = mängija.getPakutavSõna();
                    String uusSõna = pakkumine + pakutavSõna.substring(1);
                    mängija.setPakutavSõna(uusSõna);
                }
                if (mängija.getArvatavSõna().charAt(1) == pakkumine) {
                    pakutavSõna = mängija.getPakutavSõna();
                    String uusSõna = pakutavSõna.substring(0, 1) + pakkumine + pakutavSõna.substring(2);
                    mängija.setPakutavSõna(uusSõna);
                }
                if (mängija.getArvatavSõna().charAt(2) == pakkumine) {
                    pakutavSõna = mängija.getPakutavSõna();
                    String uusSõna = pakutavSõna.substring(0, 2) + pakkumine + pakutavSõna.substring(3);
                    mängija.setPakutavSõna(uusSõna);
                }
                if (mängija.getArvatavSõna().charAt(3) == pakkumine) {
                    pakutavSõna = mängija.getPakutavSõna();
                    String uusSõna = pakutavSõna.substring(0, 3) + pakkumine + pakutavSõna.substring(4);
                    mängija.setPakutavSõna(uusSõna);
                }
                if (mängija.getArvatavSõna().charAt(4) == pakkumine) {
                    pakutavSõna = mängija.getPakutavSõna();
                    String uusSõna = pakutavSõna.substring(0, 4) + pakkumine + pakutavSõna.substring(5);
                    mängija.setPakutavSõna(uusSõna);
                }
                if (mängija.getArvatavSõna().charAt(5) == pakkumine) {
                    pakutavSõna = mängija.getPakutavSõna();
                    String uusSõna = pakutavSõna.substring(0, 5) + pakkumine + pakutavSõna.substring(6);
                    mängija.setPakutavSõna(uusSõna);
                }
                if (mängija.getArvatavSõna().charAt(4) == pakkumine) {
                    pakutavSõna = mängija.getPakutavSõna();
                    String uusSõna = pakutavSõna.substring(0, 6) + pakkumine + pakutavSõna.substring(7);
                    mängija.setPakutavSõna(uusSõna);
                }
                if (mängija.getArvatavSõna().charAt(4) == pakkumine) {
                    pakutavSõna = mängija.getPakutavSõna();
                    String uusSõna = pakutavSõna.substring(0, 7) + pakkumine + pakutavSõna.substring(8);
                    mängija.setPakutavSõna(uusSõna);
                }

            } catch (IndexOutOfBoundsException ignored) {
            }
        }
        if (mängija.getPakutavSõna().equals(mängija.getArvatavSõna())) { // kui mängija arvab sõna ära, siis väljastan vajaliku info.
            System.out.println("Arvasid otsitava sõna ära! See sõna oli: " + mängija.getArvatavSõna());
            System.out.println("Pakkusid " + mängija.getPakkumisteArv() + " korda. Pakkusid tähti: " + Arrays.toString(mängija.getPakutudTähed()));
            System.out.println("Tegid " + mängija.getVigadeArv() + " viga!");
        }


    }

}