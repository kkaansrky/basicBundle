package com.example.bundleclone;

public class Haber {

    private int id;
    private String baslik;
    private String ozet;
    private String kategori;
    private  String kaynak;
    private String url;
    private String resim;
    private String tarih;

    public Haber() {
    }

    public Haber(int id, String baslik, String ozet, String kategori, String kaynak, String url, String resim, String tarih) {
        this.id = id;
        this.baslik = baslik;
        this.ozet = ozet;
        this.kategori = kategori;
        this.kaynak = kaynak;
        this.url = url;
        this.resim = resim;
        this.tarih = tarih;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getOzet() {
        return ozet;
    }

    public void setOzet(String ozet) {
        this.ozet = ozet;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getKaynak() {
        return kaynak;
    }

    public void setKaynak(String kaynak) {
        this.kaynak = kaynak;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getResim() {
        return resim;
    }

    public void setResim(String resim) {
        this.resim = resim;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }
}
