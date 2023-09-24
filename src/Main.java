public class Main {
    public static void main(String[] args) {
        String[] kelimeler = {"Ev", "Köy", "Kalem", "Üzengi", "Sırt","Masa","Deneme","a"};

        for (String kelime : kelimeler) {
            if (buyukUnluUyumuKontrolEt(kelime)) {
                System.out.println(kelime + " büyük ünlü uyumuna uyar.");
            } else {
                System.out.println(kelime + " büyük ünlü uyumuna uymaz.");
            }
        }
    }

    public static boolean buyukUnluUyumuKontrolEt(String kelime) {

        kelime = kelime.toLowerCase(); // Tüm harfleri küçük harfe dönüştürme

        if(countHeceSayisi(kelime)<2){
            return false;
        }
        String unluharfler=getUnluHarfler(kelime);

        int uzunluk = unluharfler.length();



        char oncekiHarf = unluharfler.charAt(0);

        // İlk harfi dikkate almadan kalan harfleri kontrol edin
        for (int i = 1; i < uzunluk; i++) {
            char suankiHarf = unluharfler.charAt(i);

            // Ünlü harfse ve önceki harf de ünlü değilse uyumsuzdur
            if (kalinUnluKontrol(oncekiHarf) && kalinUnluKontrol(suankiHarf)) {
                return true;
            }
            if (!kalinUnluKontrol(oncekiHarf) && !kalinUnluKontrol(suankiHarf)) {
                return true;
            }
            // Ünlü değilse ve önceki harf de ünlüyse uyumsuzdur


            // Önceki harfi güncelleyin
            oncekiHarf = suankiHarf;
        }

        return false;
    }

    private static boolean kalinUnluKontrol(char harf) {
        return "aıou".contains(String.valueOf(harf));
    }

    private static String getUnluHarfler(String kelime) {
        String unluharfler="";
        for (int i=0;i<kelime.length();i++){
            char karakter=kelime.charAt(i);
            if("aeıioöuü".contains(String.valueOf(karakter))){
                unluharfler=unluharfler+karakter;
            }
        }
        return unluharfler;
    }

    private static int countHeceSayisi(String kelime) {
        int counter=0;
        for (int i=0;i<kelime.length();i++){
            char karakter=kelime.charAt(i);
            if(isUnluHarf(karakter)){
                counter++;
            }
        }
        return counter;

    }

    public static boolean isUnluHarf(char harf) {
        // Verilen harfin ünlü bir harf olup olmadığını kontrol edin
        return "aeıioöuü".contains(String.valueOf(harf));
    }
}
