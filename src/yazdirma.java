public class yazdirma   {
    public static void tasarıbölümü(char[][] oyuntasarımı,int pozisyon,String sinifoyuncu) {
        char sembol='c';
        if(sinifoyuncu=="x") {
            sembol='x';
            xoxoyunu.oyunucu1pozisyonu.add(pozisyon);

        }
        else if (sinifoyuncu=="o"){
            sembol='o';
            xoxoyunu.oyunucu2pozisyonu.add(pozisyon);
        }

        switch(pozisyon) {
            case 1:
                oyuntasarımı[0][0]=sembol;
                break;
            case 2:
                oyuntasarımı[0][2]=sembol;
                break;
            case 3:
                oyuntasarımı[0][4]=sembol;
                break;
            case 4:
                oyuntasarımı[2][0]=sembol;
                break;
            case 5:
                oyuntasarımı[2][2]=sembol;
                break;
            case 6:
                oyuntasarımı[2][4]=sembol;
                break;
            case 7:
                oyuntasarımı[4][0]=sembol;
                break;
            case 8:
                oyuntasarımı[4][2]=sembol;
                break;
            case 9:
                oyuntasarımı[4][4]=sembol;
                break;
            default:
                break;

        }
    }

}

