package model;

public class PasienPria extends Pasien {

    public PasienPria(double beratBadan, double tinggiBadan) {
        super(beratBadan, tinggiBadan);
    }

    @Override
    public double hitungBeratIdeal() {
        // Rumus Broca untuk Pria: (Tinggi - 100) - 10% dari (Tinggi - 100)
        double dasar = getTinggiBadan() - 100.0;
        return dasar - (0.10 * dasar);
    }

    @Override
    public String getJenisKelamin() {
        return "Pria";
    }
}