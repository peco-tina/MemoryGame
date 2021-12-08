/** 1. Rita upp bordet 4x4
 *  2. Dela ut slumpmässigt bokstäver
 *  3. Spelaren väljer sitt första val
 *      - Kontrollerar om valet är giltigt
 *          - Om inte be spelaren välja igen (A1, B1 osv.)
 *      - Vänder upp valet (visar bokstav)
 *  4. Spelaren väljer sitt andra val
 *      - Kontrollerar om valet är giltigt
 *  *         - Om inte be spelaren välja igen (A1, B1 osv.)
 *  5. Kontrollera om de är likadana
 *      - Om inte: räkna ut hur många fel man har gjort
 *          - Om man har gjort 7 så förlorar man
 *          - Om man inte har gjort 7 så vänds de tillbaka och börjar man från steg 1
 *      - Om ja:
 *          - Kontrollera om alla är upptäckta
 *              - Om ja: man har vunnit spelet
 *              - Om inte: Börja från steg 1
 */
import java.util.Random;
import java.util.Scanner;

public class MyMemory {


    static String[][] par = new String[4][4];
    static boolean[][] goreDole = new boolean[4][4];
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        postava();
        igra(goreDole, par);
    }

    private static void igra(boolean[][] goreDole, String[][] par) {
        int neOkrenute = 16;
        int brojGresaka = 0;

        while (neOkrenute > 0){
            int prviIndex;
            int drugiIndex;
            int prviIndex1;
            int drugiIndex1;
            stampajSto(goreDole, par);
            System.out.println("Upisi prvo polje... npr A1");
            do {
                String prviIzbor = sc.nextLine();
                char[] xy = prviIzbor.toCharArray();
                if (xy.length != 2 || !((xy[0] == 'A' || xy[0] == 'B' || xy[0] == 'C' || xy[0] == 'D') && (xy[1] == '1' || xy[1] == '2' || xy[1] == '3' || xy[1] == '4'))) {
                    System.out.println("Upisao si pogresno. Trebas da upises npr. A1");
                } else{
                    prviIndex = xy[0] - 'A';
                    drugiIndex = xy[1] - '1';
                    if(goreDole[prviIndex][drugiIndex] == true){
                        System.out.println("To polje je vec otvoreno");
                    } else {
                        goreDole[prviIndex][drugiIndex] = true;
                        stampajSto(goreDole, par);
                        break;
                    }
                }
            } while(true);


            System.out.println("Upisi drugo polje... npr A2");
            do {
                String drugiIzbor = sc.nextLine();
                char[] ab = drugiIzbor.toCharArray();
                if (ab.length != 2 || !((ab[0] == 'A' || ab[0] == 'B' || ab[0] == 'C' || ab[0] == 'D') && (ab[1] == '1' || ab[1] == '2' || ab[1] == '3' || ab[1] == '4'))) {
                    System.out.println("Upisao si pogresno. Trebas da upises npr. A1");
                } else {
                    prviIndex1 = ab[0] - 'A';
                    drugiIndex1 = ab[1] - '1';
                    if(goreDole[prviIndex1][drugiIndex1] == true){
                        System.out.println("To polje je vec otvoreno");
                    } else {
                        goreDole[prviIndex1][drugiIndex1] = true;
                        stampajSto(goreDole, par);
                        break;
                    }
                }
            }while(true);

            if(par[prviIndex][drugiIndex] == par[prviIndex1][drugiIndex1]){
                goreDole[prviIndex][drugiIndex] = true;
                goreDole[prviIndex1][drugiIndex1] = true;
                neOkrenute -= 2;
            }
            if(par[prviIndex][drugiIndex] != par[prviIndex1][drugiIndex1]){
                goreDole[prviIndex][drugiIndex] = false;
                goreDole[prviIndex1][drugiIndex1] = false;
                brojGresaka++;
            }
            if(brojGresaka == 7){
                System.out.println("Pogresio si 7 puta i izgubio igricu.");
                System.exit(0);
            }
        }
        stampajSto(goreDole, par);
        System.out.println("Pobedio si igricu.");
    }

    private static void stampajSto(boolean[][] goreDole, String[][] par) {
        char[] slova = {'A', 'B', 'C', 'D'};
        System.out.println("     1 2 3 4 ");
        System.out.println("---+---------");
        for(int i = 0; i < 4; i++){
            System.out.print(" " + (slova[i]) + " | ");
            for(int j = 0; j < 4; j++){
                if(goreDole[i][j]){
                    System.out.print(par[i][j]);
                    System.out.print(" ");
                }
                else {
                    System.out.print("? ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void postava() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                goreDole[i][j] = false;
            }
        }
        par = mesanje();
    }

    private static String[][] mesanje() {
        String [] slova = {"E", "E", "G", "G", "H", "H", "I", "I", "J", "J", "K", "K", "L", "L", "M", "M"};
        String [][] par = new String[4][4];
        Random random = new Random();
        String temp;
        int t;

        for(int i = 0; i <= 20; i++){
            for(int j = 0; j < 16; j++){
                t = random.nextInt(1000) % 15;
                temp = slova[j];
                slova[j] = slova[t];
                slova[t] = temp;
            }
            t = 0;
            for(int a = 0; a < 4; a++){
                for(int b = 0; b < 4; b++){
                    par[a][b] = slova[t];
                    t = t + 1;
                }
            }
        }
        return par;
    }
}