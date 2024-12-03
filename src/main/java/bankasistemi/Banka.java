package bankasistemi;

import java.util.List;

public class Banka {
    private List<Kullanici> kullanicilar;

    public Banka(List<Kullanici> kullanicilar) {
        this.kullanicilar = kullanicilar;
    }

    public Kullanici kullaniciGiris(String tc, String sifre) {
        for (Kullanici kullanici : kullanicilar) {
            if (kullanici.getTc().equals(tc) && kullanici.getSifre().equals(sifre)) {
                return kullanici;
            }
        }
        return null;
    }

    public void krediBorcuOde(Kullanici kullanici, double miktar) {
        if (miktar <= kullanici.getBakiye() && miktar <= kullanici.getKrediBorcu()) {
            kullanici.setBakiye(kullanici.getBakiye() - miktar);
            kullanici.setKrediBorcu(kullanici.getKrediBorcu() - miktar);
            System.out.println("Kredi borcu ödendi.");
        } else {
            System.out.println("Yetersiz bakiye veya geçersiz miktar.");
        }
    }

    public void paraTransfer(Kullanici gonderen, String aliciTc, double miktar) {
        Kullanici alici = kullanicilar.stream()
                                      .filter(k -> k.getTc().equals(aliciTc))
                                      .findFirst()
                                      .orElse(null);
        if (alici != null && miktar <= gonderen.getBakiye()) {
            gonderen.setBakiye(gonderen.getBakiye() - miktar);
            alici.setBakiye(alici.getBakiye() + miktar);
            System.out.println("Para transferi başarılı.");
        } else {
            System.out.println("Hata: Yetersiz bakiye veya alıcı bulunamadı.");
        }
    }
}
