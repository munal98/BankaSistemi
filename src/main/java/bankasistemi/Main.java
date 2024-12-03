package bankasistemi;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            List<Kullanici> kullanicilar = JsonOkuyucu.kullanicilariOku("src/main/resources/kullanicilar.json");
            Banka banka = new Banka(kullanicilar);

            Scanner scanner = new Scanner(System.in);
            System.out.println("T.C. kimlik numaranızı giriniz:");
            String tc = scanner.nextLine();
            System.out.println("Şifrenizi giriniz:");
            String sifre = scanner.nextLine();

            Kullanici girisYapan = banka.kullaniciGiris(tc, sifre);
            if (girisYapan != null) {
                System.out.println("Hoş geldiniz, " + girisYapan.getAd() + "!");

                // İşlem Menüsü
                while (true) {
                    System.out.println("\nİşlemler:");
                    System.out.println("1. Para Transferi");
                    System.out.println("2. Kredi Borcu Ödeme");
                    System.out.println("3. Çıkış");
                    System.out.print("Seçiminizi yapın: ");
                    int secim = scanner.nextInt();

                    if (secim == 1) {
                        System.out.print("Alıcının T.C.'sini girin: ");
                        scanner.nextLine(); // Satır sonunu temizle
                        String aliciTc = scanner.nextLine();
                        System.out.print("Gönderilecek miktarı girin: ");
                        double miktar = scanner.nextDouble();
                        banka.paraTransfer(girisYapan, aliciTc, miktar);
                    } else if (secim == 2) {
                        System.out.print("Ödemek istediğiniz miktarı girin: ");
                        double miktar = scanner.nextDouble();
                        banka.krediBorcuOde(girisYapan, miktar);
                    } else if (secim == 3) {
                        System.out.println("Çıkış yapılıyor...");
                        break;
                    } else {
                        System.out.println("Geçersiz seçim.");
                    }
                }
            } else {
                System.out.println("Giriş başarısız. Bilgilerinizi kontrol edin.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
