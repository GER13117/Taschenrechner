import java.util.Scanner;
public class Taschenrechner {
    public static void main(String[] args) {
        scannMich();
    }
    public static void scannMich(){//Scannt Eingabe
        System.out.println("");
        System.out.println("---------------");
        System.out.println("Bitte Rechnung eingeben:");
        System.out.println("\"+\" als Plus-Rechenzeichen");
        System.out.println("\"-\" als Minus-Rechenzeichen");
        System.out.println("\"*\" als Mal-Rechenzeichen");
        System.out.println("\"/\" als Geteilt-Rechenzeichen");
        System.out.println("\"^\" als Potenz-Rechenzeichen");
        System.out.println("!WICHTIG! - Zwischen Zahl und Rechenzeichen IMMER ein Leerzeichen - !WICHTIG!");
        System.out.println("---------------");
        Scanner scanner = new Scanner(System.in);
        String hii = scanner.nextLine();
        String[] eingabe = hii.split(" ");
        Rechnen(eingabe);
    }

    public static boolean zuruck(String[] eingabe, int zahl){
        switch(eingabe[zahl]){//Testet welches das erste Rechenzeichen ist.
            case "+":
                break;
            case "-":
                break;
            default:
                return true;
        }
        if(zahl+3>eingabe.length){//Fängt Fehler ab, wenn nur noch ein Rechenzeichen da ist
            return true;
        }
        switch(eingabe[zahl+2]){//Testet welches das zweite Rechenzeichen ist.
            case "+":
                break;
            case "-":
                break;
            default:
                return false;
        }
        return true;
    }

    public static void Rechnen(String[] eingabe){
        int zahl = 1;
        double zahl1 = 0;
        double zahl2 = 0;
        while(eingabe.length>2){
            zahl = 1;
            while(!zuruck(eingabe, zahl)){//Testet ob er rechnen darf(Punkt vor strich)
                zahl = zahl + 2;
            }
            zahl1 = Double.valueOf(eingabe[zahl-1]);
            zahl2 = Double.valueOf(eingabe[zahl+1]);
            switch(eingabe[zahl]){//Rechnet
                case "+":
                    eingabe[zahl-1] = Double.toString(zahl1 + zahl2);
                    break;
                case "-":
                    eingabe[zahl-1] = Double.toString(zahl1 - zahl2);
                    break;
                case "*":
                    eingabe[zahl-1] = Double.toString(zahl1 * zahl2);
                    break;
                case "/":
                    eingabe[zahl-1] = Double.toString(zahl1 / zahl2);
                    break;
                case "^":
                    double moin = zahl1;
                    for(int i=1; i<zahl2; i++){
                        moin = moin * zahl1;
                    }
                    eingabe[zahl-1] = Double.toString(moin);
                    break;
            }
            for(int i=zahl; i<eingabe.length-2; i++){//Schiebt die Array Werte weiter nach vorne(2)
                eingabe[i] = eingabe[i+2];
            }
            String[] tmp = new String[eingabe.length-2];//Ab hier wird das Array um 2 verkürzt(2 Zahlen un 1 Rechenzeichen wird 1 Zahl gemacht)
            for(int i=0; i<eingabe.length-2; i++){
                tmp[i] = eingabe[i];
            }
            eingabe = tmp;
        }
        System.out.println(eingabe[0]);
        scannMich();//nochmal Rechnen
    }
}