package controller;

import java.util.Locale;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Pasien;
import model.PasienPria;
import model.PasienWanita;

public class BmiController {

    @FXML private TextField beratField;
    @FXML private TextField tinggiField;
    @FXML private ComboBox<String> genderBox;
    @FXML private Label hasilLabel;

    @FXML
    private void initialize() {
        genderBox.getItems().addAll("Pria", "Wanita");
        genderBox.setValue("Pria");
    }

    @FXML
    private void hitung() {
        try {
            double berat = Double.parseDouble(beratField.getText().trim().replace(",", "."));
            double tinggi = Double.parseDouble(tinggiField.getText().trim().replace(",", "."));

            Pasien pasien;
            if ("Wanita".equals(genderBox.getValue())) {
                pasien = new PasienWanita(berat, tinggi);
            } else {
                pasien = new PasienPria(berat, tinggi);
            }

            double bmi = pasien.hitungBmi();
            double beratIdeal = pasien.hitungBeratIdeal();

            hasilLabel.setStyle("-fx-text-fill: #166534;");
            hasilLabel.setText(String.format(Locale.forLanguageTag("id-ID"),
                    "Jenis Kelamin: %s\nSkor BMI: %.2f\nKlasifikasi: %s\nBerat Badan Ideal: %.1f kg",
                    pasien.getJenisKelamin(),
                    bmi,
                    pasien.getKategoriBmi(),
                    beratIdeal));
        } catch (NumberFormatException e) {
            tampilkanError("Berat dan tinggi badan harus berupa angka yang valid.");
        } catch (IllegalArgumentException e) {
            tampilkanError(e.getMessage());
        }
    }

    @FXML
    private void reset() {
        beratField.clear();
        tinggiField.clear();
        genderBox.setValue("Pria");
        hasilLabel.setStyle("-fx-text-fill: #374151;");
        hasilLabel.setText("Silakan masukkan data untuk menghitung BMI.");
    }

    private void tampilkanError(String pesan) {
        hasilLabel.setStyle("-fx-text-fill: #b91c1c;");
        hasilLabel.setText(pesan);
    }
}