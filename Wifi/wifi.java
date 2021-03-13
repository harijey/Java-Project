import java.io.IOException;
import java.util.Scanner;
public class wifi {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        Process process1 = Runtime.getRuntime().
                exec("netsh wlan show profiles");
        Scanner wifiNames = new Scanner(process1.getInputStream());
        while(wifiNames.hasNext()) {
            String wifiLine = wifiNames.nextLine();
            if (wifiLine.contains("All User Profile     : ")) {
                String[] exp = wifiLine.split(":");
                System.out.printf("|%20s--%-20s|\n",exp[1],Pass(exp[1]));
            }
        }
        String a = sc.nextLine();
    }
    public static String Pass(String s) throws IOException {
        Process process2 = Runtime.getRuntime().exec("netsh wlan show profile "+s+" key=clear");
        Scanner wifiPass = new Scanner(process2.getInputStream());
        String[] expPass = new String[2];
        expPass[1]= "N/A";
        while(wifiPass.hasNext()){
            String lines = wifiPass.nextLine();
            if(lines.contains("Key Content"))
                expPass = lines.split(": ");
        }
        return expPass[1];
    }
}
