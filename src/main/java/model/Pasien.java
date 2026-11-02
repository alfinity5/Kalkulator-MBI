package model;

public abstract class Pasien {

    private final double beratBadan;  // dalam kilogram (kg)
    private final double tinggiBadan; // dalam sentimeter (cm)

    public Pasien(double beratBadan, double tinggiBadan) {
        if (beratBadan <= 0 || beratBadan > 500) {
            throw new IllegalArgumentException("Berat badan harus berada di rentang 1 - 500 kg.");
        }
        if (tinggiBadan <= 30 || tinggiBadan > 300) {
            throw new IllegalArgumentException("Tinggi badan harus berada di rentang 30 - 300 cm.");
        }

        this.beratBadan = beratBadan;
        this.tinggiBadan = tinggiBadan;
    }

    public double getBeratBadan() {
        return beratBadan;
    }

    public double getTinggiBadan() {
        return tinggiBadan;
    }

    public double hitungBmi() {
        double tinggiMeter = tinggiBadan / 100.0;
        return beratBadan / (tinggiMeter * tinggiMeter);
    }

    public String getKategoriBmi() {
        double bmi = hitungBmi();
        if (bmi < 18.5) {
            return "Berat Badan Kurang (Underweight)";
        } else if (bmi < 24.9) {
            return "Berat Badan Normal (Ideal)";
        } else if (bmi < 29.9) {
            return "Berat Badan Berlebih (Overweight)";
        } else if (bmi < 34.9) {
            return "Obesitas Tingkat I";
        } else {
            return "Obesitas Tingkat II (Berat)";
        }
    }

    public abstract double hitungBeratIdeal();

    public abstract String getJenisKelamin();
}