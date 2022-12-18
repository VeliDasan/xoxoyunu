import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.Arrays.*;
public class xoxoyunu {
    static char[] [] oyuntasarımı=
            {{' ','|',' ','|',' '},
                    {'-','+','-','+','-'},
                    {' ','|',' ','|',' '},
                    {'-','+','-','+','-'},
                    {' ','|',' ','|',' '}};
    static ArrayList<Integer> oyunucu1pozisyonu=new ArrayList<Integer>();
    static ArrayList<Integer> oyunucu2pozisyonu=new ArrayList<Integer>();
    public static void main(String[] args) {
        yazdirma nesne = new yazdirma();
        String oyuncu="x";
        System.out.println("XOX OYUNUNA HOŞGELDİNİZ!!");
        tasarımıyazdır(oyuntasarımı);
        while(true) {
            String yazdir="";
            Scanner tara= new Scanner(System.in);
            System.out.println("1 ile 9 arası sayı giriniz!!");
            int pozisyon=tara.nextInt();
            while (oyunucu1pozisyonu.contains(pozisyon)||oyunucu2pozisyonu.contains(oyunucu1pozisyonu)){
                System.out.println("farklı yere koyunuz");
                pozisyon= tara.nextInt();
            }
            yazdir=satırıkontrolet();
            if (yazdir.length()>0){
                System.out.println(yazdir);
                break;
            }
            while (oyunucu1pozisyonu.contains(pozisyon)||oyunucu2pozisyonu.contains(pozisyon)){
                System.out.println("farklı yere koyunuz");
                pozisyon= tara.nextInt();
            }

            if(oyuncu=="x") {
                nesne.tasarıbölümü(oyuntasarımı,pozisyon,oyuncu);
                oyuncu="o";
                oyunucu1pozisyonu.add(pozisyon);

            }
            else if(oyuncu=="o") {
                nesne.tasarıbölümü(oyuntasarımı,pozisyon,oyuncu);
                oyuncu="x";
                oyunucu2pozisyonu.add(pozisyon);

            }
            tasarımıyazdır(oyuntasarımı);
            yazdir=satırıkontrolet();
            if (yazdir.length()>0){
                System.out.println(yazdir);
                break;
            }

        }
    }
    public static void tasarımıyazdır(char[][]oyuntasarımı ) {
        for(char[] düzen:oyuntasarımı) {
            for(char c :düzen) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
    static String satırıkontrolet()  {
        List üst = asList(1,2,3);
        List orta = asList(4,5,6);
        List alt = asList(7,8,9);
        List sol = asList(1,4,7);
        List ortasüt = asList(2,5,8);
        List sağ = asList(3,6,9);
        List çapraz1 = asList(1,5,9);
        List çapraz2 = asList(7,5,3);

        List<List> kazanmaşartları=new ArrayList<List>();
        kazanmaşartları.add(üst);
        kazanmaşartları.add(orta);
        kazanmaşartları.add(alt);
        kazanmaşartları.add(sol);
        kazanmaşartları.add(ortasüt);
        kazanmaşartları.add(sağ);
        kazanmaşartları.add(çapraz1);
        kazanmaşartları.add(çapraz2);
        int count=0;
        char value='x';
        //tablodaki x karekter sayısının bulunması ve oyunun berabare bitmesi
        for (int i=0;i<oyuntasarımı.length;i++)
        {
            for (int j=0;j<oyuntasarımı[i].length;j++)
            {
                if(oyuntasarımı[i][j]==value)
                {
                    count++;
                }
            }
        }
        for (List l:kazanmaşartları){
            if (oyunucu1pozisyonu.containsAll(l)){
                return "oyuncu1 kazandı";
            } else if (oyunucu2pozisyonu.containsAll(l)) {
                return "oyuncu2 kazandı";
            } else if (count==5) {
                return "berabere!";

            }
        }
        return "";


    }

}
