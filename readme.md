# Aplikasi Kalkulator BMI & Berat Ideal (JavaFX + OOP)

Aplikasi desktop berbasis **JavaFX** dan **Scene Builder (FXML)** untuk menghitung **Body Mass Index (BMI)**, memberikan klasifikasi status berat badan (Kurang, Normal, Berlebih, Obesitas), serta menghitung estimasi berat badan ideal menggunakan **Rumus Broca**. Proyek ini dibuat untuk memenuhi tugas mata kuliah **Pemrograman Lanjut** dengan menerapkan prinsip *Object-Oriented Programming* (OOP) dan pola arsitektur MVC (*Model-View-Controller*).

## Tampilan Aplikasi (Screenshot)

<img width="1920" height="1080" alt="Screenshot (386)" src="https://github.com/user-attachments/assets/d8c5ceca-7bda-4840-a4a1-0c2eb935c535" />


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


## Cara Menjalankan Proyek

1. Buka Apache NetBeans IDE, lalu pilih menu File > Open Project... dan arahkan ke folder proyek ini.

2. Klik kanan pada nama proyek di panel Projects, lalu pilih Clean and Build (Shift + F11) agar Maven mengunduh seluruh dependensi JavaFX (javafx-controls dan javafx-fxml).

* **Untuk Menjalankan Mode GUI (Tampilan Kalkulator Visual)**:

Buka Source Packages > main > MainApp.java.

Klik kanan pada MainApp.java, lalu pilih Run File (atau tekan shortcut Shift + F6).

Untuk Menjalankan Mode Terminal (Konsol CLI):

Buka Source Packages > main > DemoTerminalMode.java.

Klik kanan pada DemoTerminalMode.java, lalu pilih Run File (atau tekan shortcut Shift + F6).
