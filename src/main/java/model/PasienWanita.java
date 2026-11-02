package model;

public class PasienWanita extends Pasien {

    public PasienWanita(double beratBadan, double tinggiBadan) {
        super(beratBadan, tinggiBadan);
    }

    @Override
    public double hitungBeratIdeal() {
        // Rumus Broca untuk Wanita: (Tinggi - 100) - 15% dari (Tinggi - 100)
        double dasar = getTinggiBadan() - 100.0;
        return dasar - (0.15 * dasar);
    }

    @Override
    public String getJenisKelamin() {
        return "Wanita";
    }
}