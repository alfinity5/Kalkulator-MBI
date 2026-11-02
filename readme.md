# Aplikasi Kalkulator BMI & Berat Ideal (JavaFX + OOP)

Aplikasi desktop berbasis **JavaFX** dan **Scene Builder (FXML)** untuk menghitung **Body Mass Index (BMI)**, memberikan klasifikasi status berat badan (Kurang, Normal, Berlebih, Obesitas), serta menghitung estimasi berat badan ideal menggunakan **Rumus Broca**. Proyek ini dibuat untuk memenuhi tugas mata kuliah **Pemrograman Lanjut** dengan menerapkan prinsip *Object-Oriented Programming* (OOP) dan pola arsitektur MVC (*Model-View-Controller*).

## Tampilan Aplikasi (Screenshot)



*(Catatan: Simpan tangkapan layar aplikasi kamu dengan nama `tampilan-gui.png` di dalam folder `screenshots/` pada proyek ini).*

## Fitur Utama

* **Perhitungan Skor BMI Tanpa Input Nama**: Pengguna cukup memilih jenis kelamin serta memasukkan berat badan (kg) dan tinggi badan (cm) untuk menghitung nilai BMI dengan rumus $\text{BMI} = \frac{\text{Berat (kg)}}{(\text{Tinggi (m)})^2}$.
* **Klasifikasi Status Berat Badan Lengkap**: Mengelompokkan hasil perhitungan BMI secara otomatis ke dalam lima kategori:
  * **Berat Badan Kurang (*Underweight*)**: BMI < 18,5
  * **Berat Badan Normal (*Ideal*)**: BMI 18,5 – 24,9
  * **Berat Badan Berlebih (*Overweight*)**: BMI 25,0 – 29,9
  * **Obesitas Tingkat I**: BMI 30,0 – 34,9
  * **Obesitas Tingkat II (Berat)**: BMI ≥ 35,0
* **Estimasi Berat Badan Ideal (Polimorfisme)**: Menghitung berat badan ideal berdasarkan jenis kelamin menggunakan rumus Broca (`PasienPria` mengurangi 10% dari `tinggi - 100`, sedangkan `PasienWanita` mengurangi 15%).
* **Validasi Input & Penanganan Eksepsi**: Memvalidasi input kosong, format non-angka (`NumberFormatException`), serta nilai berat atau tinggi badan di luar batas wajar (`IllegalArgumentException`) dengan pesan peringatan berwarna merah pada antarmuka.
* **Mode Terminal & GUI**: Menyediakan kelas `MainApp` untuk tampilan antarmuka grafis (JavaFX) dan `DemoTerminalMode` untuk pengujian cepat melalui konsol/terminal.

## Struktur Proyek

```text
CalculatorMBI/
├── screenshots/
│   └── tampilan-gui.png                    # Gambar screenshot aplikasi untuk README
├── src/
│   └── main/
│       ├── java/
│       │   ├── controller/
│       │   │   └── BmiController.java      # Mengatur event UI dan menghubungkan FXML dengan Model
│       │   ├── main/
│       │   │   ├── MainApp.java            # Entry point aplikasi GUI JavaFX
│       │   │   └── DemoTerminalMode.java   # Entry point pengujian di terminal (CLI)
│       │   └── model/
│       │       ├── Pasien.java             # Abstract superclass untuk data, rumus BMI, dan klasifikasi
│       │       ├── PasienPria.java         # Subclass untuk perhitungan berat ideal pria
│       │       └── PasienWanita.java       # Subclass untuk perhitungan berat ideal wanita
│       └── resources/
│           └── form-bmi.fxml               # File desain antarmuka Scene Builder
├── pom.xml
└── README.md
```

## Penerapan Konsep OOP

| Konsep OOP | Implementasi dalam Kode |
| :--- | :--- |
| **Encapsulation** | Atribut `beratBadan` dan `tinggiBadan` pada kelas `Pasien` bersifat `private final`, diakses melalui *getter*, serta divalidasi langsung di dalam konstruktor. |
| **Abstraction** | Kelas `Pasien` dideklarasikan sebagai `abstract class` dengan metode abstrak `hitungBeratIdeal()` dan `getJenisKelamin()`. |
| **Inheritance** | Kelas `PasienPria` dan `PasienWanita` mewarisi (`extends`) atribut dan metode dari kelas induk `Pasien`. |
| **Polymorphism** | Objek bertipe referensi `Pasien` dapat diinstansiasi sebagai `PasienPria` atau `PasienWanita`, lalu memanggil `@Override hitungBeratIdeal()` sesuai rumus masing-masing. |

## Prasyarat Sistem

* **Java Development Kit (JDK)**: Versi 17 atau 21 ke atas
* **Apache Maven**: Terintegrasi dengan IDE (Apache NetBeans / IntelliJ IDEA / Eclipse)
* **JavaFX Scene Builder**: Untuk membuka dan memodifikasi file `form-bmi.fxml`

## Cara Menjalankan Proyek

1. Clone repositori ini ke komputer lokal:
   ```bash
   git clone https://github.com/username-kamu/CalculatorMBI.git
   ```
2. Buka proyek menggunakan **Apache NetBeans IDE** melalui menu **File > Open Project** dan pilih folder `CalculatorMBI`.
3. Untuk menjalankan versi GUI, klik kanan pada file `main.MainApp.java` lalu pilih **Run File** (`Shift + F6`).
4. Untuk menjalankan versi konsol/terminal, klik kanan pada file `main.DemoTerminalMode.java` lalu pilih **Run File** (`Shift + F6`).
