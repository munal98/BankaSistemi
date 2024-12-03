package bankasistemi;

public class Kullanici {
    private String tc;
    private String ad;
    private String soyad;
    private String sifre;
    private double bakiye;
    private double krediBorcu;
    private String dogumTarihi; // Örn. "1990-05-15"

    public Kullanici() {}

    public Kullanici(String tc, String ad, String soyad, String sifre, double bakiye, double krediBorcu, String dogumTarihi) {
        this.tc = tc;
        this.ad = ad;
        this.soyad = soyad;
        this.sifre = sifre;
        this.bakiye = bakiye;
        this.krediBorcu = krediBorcu;
        this.dogumTarihi = dogumTarihi;
    }

    // Getter ve Setter'lar
    public String getTc() { return tc; }
    public void setTc(String tc) { this.tc = tc; }

    public String getAd() { return ad; }
    public void setAd(String ad) { this.ad = ad; }

    public String getSoyad() { return soyad; }
    public void setSoyad(String soyad) { this.soyad = soyad; }

    public String getSifre() { return sifre; }
    public void setSifre(String sifre) { this.sifre = sifre; }

    public double getBakiye() { return bakiye; }
    public void setBakiye(double bakiye) { this.bakiye = bakiye; }

    public double getKrediBorcu() { return krediBorcu; }
    public void setKrediBorcu(double krediBorcu) { this.krediBorcu = krediBorcu; }

    public String getDogumTarihi() { return dogumTarihi; }
    public void setDogumTarihi(String dogumTarihi) { this.dogumTarihi = dogumTarihi; }

    // Şifre kontrol metodu
    public boolean sifreDogruMu() {
        if (dogumTarihi == null || sifre == null) return false;

        String dogumYili = dogumTarihi.split("-")[0];
        String dogumAyGun = dogumTarihi.substring(5).replace("-", "");

        // Şifre içinde doğum yılı veya ay-gün varsa kabul edilmez
        return !sifre.contains(dogumYili) && !sifre.contains(dogumAyGun);
    }
}
