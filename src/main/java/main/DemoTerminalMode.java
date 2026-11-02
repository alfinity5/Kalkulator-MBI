package main;

import model.Pasien;
import model.PasienPria;
import model.PasienWanita;

public class DemoTerminalMode {

    public static void main(String[] args) {
        Pasien pasien1 = new PasienPria(70, 175);
        System.out.println("Jenis Kelamin: " + pasien1.getJenisKelamin());
        System.out.printf("Skor BMI: %.2f%n", pasien1.hitungBmi());
        System.out.println("Klasifikasi: " + pasien1.getKategoriBmi());
        System.out.printf("Berat Ideal: %.1f kg%n%n", pasien1.hitungBeratIdeal());

        Pasien pasien2 = new PasienWanita(68, 160);
        System.out.println("Jenis Kelamin: " + pasien2.getJenisKelamin());
        System.out.printf("Skor BMI: %.2f%n", pasien2.hitungBmi());
        System.out.println("Klasifikasi: " + pasien2.getKategoriBmi());
        System.out.printf("Berat Ideal: %.1f kg%n", pasien2.hitungBeratIdeal());
    }
}