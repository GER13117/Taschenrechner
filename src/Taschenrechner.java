import java.util.Scanner;
//TODO: UI überlegen
/**
 * Ein simpler Taschenrechner
 * @author Okke
 * @version 15
 */
public class Taschenrechner {
    public static void main(String[] args){
        System.out.println("Willkommen zu unserem tollen Rechner");
        System.out.println("____________________________________");
        System.out.println("Bitte beachten Sie, dass das Programm die Operationen in Zweierblöcken berechnet");
        System.out.println("2+2*2 würde somit als (2+2)*2 gerechnet werden.");
        System.out.println(" ");
        System.out.println("Updates sind in Bearbeitung");
        System.out.println(" ");
        System.out.println("Wollen sie dennoch fortfahren");
        disclaimer();
    }


    public static void disclaimer(){

        Scanner entscheidung = new Scanner(System.in);
        String jaNein = entscheidung.nextLine();
        switch (jaNein){
            case "ja":
            case "Ja":
                //Zu der Funktion von der es weiter geht
                whichCalculation();
                break;
            case "nein":
            case "Nein":
                System.out.println("Okay, schönen Tag noch.");
                System.exit(0);
                break;
            default:
                System.out.println("Mögliche Eingaben wären ja, Ja, nein und Nein." +
                        " Versuchen Sie es nochmal!");
                disclaimer();

        }
    }

    public static void whichCalculation() {
        //Auswahlmenü der verschiedenen Operationen
        //TODO: Umstrukturieren auf Kastenmenü Option 1 || Option 2
        System.out.println("Diese Rechnungen sind möglich:");
        System.out.println("1. Simple + - * / Rechnungen");
        System.out.println("2. Quadratwurzel ziehen");
        System.out.println("3. Die Fakultät einer bestimmten Zahl berechnen");
        System.out.println("4. Den Prozentsatz einer Zahl berechnen");
        System.out.println("5. Den Bruch aus zwei Zahlen rechnen");
        System.out.println("6. Die Potenz von einer Zahl berechnen");
        System.out.println("7. Modulo einer Zahl");
        System.out.println("8. Schließe das Programm");

        //Menü zum Wählen der verschiedenen Operation
        Scanner scan = new Scanner(System.in);
        int chooseCalc = scan.nextInt();
        switch (chooseCalc){
            case 1:
                basicCalc();
                break;
            case 2:
                quadratWurzel();
                break;
            case 3:
                fakultaet();
                break;
            case 4:
                prozent();
                break;
            case 5:
                brueche();
                break;
            case 6:
                potenz();
                break;
            case 7:
                modulo();
                break;
            case 8:
                System.out.println("Okay, schönen Tag noch.");
                System.exit(0);
            default:
                System.out.println("Bitte geben sie eine valide Nummer ein!");
                whichCalculation();
        }
    }

    public static void basicCalc(){

        Scanner ersteZahl = new Scanner(System.in);
        double a = ersteZahl.nextDouble();

        Scanner operator = new Scanner(System.in);
        String sign = operator.nextLine();

        Scanner zweiteZahl = new Scanner(System.in);
        double b = zweiteZahl.nextDouble();
        //Damit man nur die Rechnung sieht
        //TODO: Was schöneres überlegen
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        doBasicCalc(a, b, sign);


    }

    public static void doBasicCalc(double a, double b, String sign) {
        //Anzeigen der Rechnung
        System.out.print(a + sign + b);

        //Entscheiden welche Operation getätigt wird
        switch (sign) {
            case "*":
                a = a*b;
                System.out.print("=" + a);
                break;
            case "/":
                a = a/b;
                System.out.print("=" + a);
                break;
            case "+":
                a = a+b;
                System.out.print("=" + a);
                break;

            case "-":
                a = a-b;
                System.out.print("=" + a);
                break;
            default:
                System.out.println("Kein gültiges Rechenzeichen, gültig sind + - * /" +
                        "Versuchen Sie es nochmal!");
                basicCalc();
        }
    }

    public static void modulo() {
        System.out.println("Under construction");
    }

    public static void potenz() {
        System.out.println("Under construction");
        Scanner base = new Scanner(System.in);
        double basis = base.nextDouble();

        System.out.print(basis + "^");

        Scanner expo = new Scanner(System.in);
        double exponent = expo.nextDouble();
        double sum;
        for(int i = 0; i <= exponent; i++){
            sum = basis * basis;
            if(i < exponent){
                System.out.println(" ");
            }
            else{
                System.out.print(basis + "^" + exponent + " = " + sum);
            }
        }

    }

    public static void brueche() {
        System.out.println("Under construction");
    }

    public static void prozent() {
        System.out.println("Under construction");
    }

    public static void fakultaet() {
        System.out.println("Under construction");
    }

    public static void quadratWurzel() {
        System.out.println("Gebe die Zahl ein aus der die Wurzel gezogen werden soll!");

        Scanner zahlInBruch = new Scanner(System.in);

        int q = zahlInBruch.nextInt();

        if(q > 0){
            //Methode mit dem Heronverfahren
            heronVerfahren(q);
        }
        else {
            System.out.println("Du kannst keinen Bruch aus negativen Zahlen ziehen...");

        }
        whichCalculation();
    }

    //Verfahren um die Wurzel zu bestimmen

    public static void heronVerfahren(int q) {

        //counter um die Wiederholungen zu begrenzen
        //5 da ab dieser Anzahl sich das Ergebnis im Output (meistens) nicht mehr verändert hat

        int counter = 5;
        double x = 2;
        do{

            //Die Formel, um sich der Wurzel anzunähern
            x = 0.5 * (x + (q/x));

            /*Musste 0.5 nehmen da bei 1/2 immer 0 das Ergebnis war*/

            counter--;

            if(counter>0){}
            else{
                System.out.println("Die Wurzel aus " + q + " ist " + x);
            }

        }while(counter>0);

    }
}