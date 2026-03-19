# PEMROGRAMAN LANJUT - Latihan Kerja 04 (LK04)

## Studi Kasus: Arsitektur Smart Banking Ecosystem

**Bank: GakMauRugi** - Membangun sistem transaksi yang sangat aman namun fleksibel

---

## 👥 Anggota Tim

| No | Nama | NIM |
|---|---|---|
| 1 | ARYAN ZAKY PRAYOGO | 255150207111059 |
| 2 | ACHMAD HUJAIRI | 255150200111042 |
| 3 | M. HIDAYATULLOH H. A. M | 255150201111025 |
| 4 | M. AHSAL ZILHAMSYAH | 255150200111041 |
| 5 | DIKARDO SIAHAAN | 255150200111040 |

---

## 📋 Penjelasan Proyek

Sistem Banking Ecosystem ini mengimplementasikan tiga konsep OOP fundamental dalam Java:

### 1. **Hirarki Layanan (Interface Inheritance)**
   - Interface `Transaksi` sebagai antarmuka dasar
   - Interface `TransaksiDigital` yang mewarisi `Transaksi`
   - Interface `LayananInternasional` yang mewarisi `Transaksi`
   - Interface `TransferGlobal` dengan **multiple inheritance** (mewarisi `TransaksiDigital` dan `LayananInternasional`)

### 2. **Struktur Rekening (Class Inheritance)**
   - Superclass: `Rekening` (berbifat abstract/concrete dengan properties umum)
     - Berisi atribut: `nomorRekening`, `saldo`, `namaPemilik`
     - Berisi method dasar transaksi
   - Subclass: `RekeningValas` (mewarisi `Rekening`)
     - Tambahan atribut: `jenisMata Uang`, `kursRate`
     - Implementasi transfer dengan konversi mata uang

### 3. **Keamanan Enkripsi (Final Class & Variable)**
   - Class `ProtocolKeamanan` dengan modifier **final** (tidak dapat diwariskan)
   - Implementasi validasi transaksi dengan enkripsi
   - Final variable: `ID_SERVER` (konstanta yang tidak boleh diubah sejak inisialisasi)
   - Setiap transaksi harus divalidasi oleh `ProtocolKeamanan`

---

## 🎯 Pembagian Tugas

### ✅ **1. ARYAN ZAKY PRAYOGO - Interface Hierarchy (Hirarki Layanan)**

**Deliverables:**
- [ ] Buat file `Transaksi.java` (Interface dasar)
  - Method: `proses()`, `validasi()`, `getJenisTransaksi()`
- [ ] Buat file `TransaksiDigital.java` (Interface extends Transaksi)
  - Method: `prosesOnline()`, `getTokenDigital()`
- [ ] Buat file `LayananInternasional.java` (Interface extends Transaksi)
  - Method: `prosesInternasional()`, `getNegaraTujuan()`
- [ ] Buat file `TransferGlobal.java` (Interface dengan multiple inheritance)
  - Extends: `TransaksiDigital`, `LayananInternasional`
  - Method: `transferGlobal()`, `verifikasiInternasional()`


---

### ✅ **2. ACHMAD HUJAIRI - Class Inheritance Structure (Struktur Rekening Superclass)**

**Deliverables:**
- [ ] Buat file `Rekening.java` (Superclass)
  - Atribut:
    - `String nomorRekening`
    - `double saldo`
    - `String namaPemilik`
    - `Date tanggalMembuka`
  - Method:
    - Constructor(s)
    - `setorTunai(double jumlah)`
    - `tarikTunai(double jumlah)`
    - `cekSaldo()`
    - Abstract/interface method implementation

---

### ✅ **3. M. HIDAYATULLOH H. A. M - Subclass Implementation (RekeningValas)**

**Deliverables:**
- [ ] Buat file `RekeningValas.java` (Subclass extends Rekening)
  - Atribut tambahan:
    - `String jenisMataUang` (USD, EUR, JPY, dll)
    - `double kursRate` (final - tidak bisa diubah)
  - Method:
    - Constructor
    - `konversiKeMataUangLokal()`
    - `transferAntar Negara(String nomorTujuan, double jumlahValuta)`
    - Override method dari parent class jika perlu
- [ ] Implementasi interface sesuai kebutuhan

---

### ✅ **4. M. AHSAL ZILHAMSYAH - Security & Encryption (ProtocolKeamanan)**

**Deliverables:**
- [ ] Buat file `ProtocolKeamanan.java` (Final Class)
  - Modifier: `final` (tidak dapat diwariskan)
  - Atribut:
    - `final String ID_SERVER` (konstanta, tidak boleh diubah setelah inisialisasi)
    - `String privateKey`
    - `String publicKey`
  - Method:
    - `validasiTransaksi(Transaksi t)` → boolean
    - `enkripsiData(String data)` → String
    - `deskripsiData(String data)` → String
    - `generateToken()` → String
    - `verifikasiPin(String pin)` → boolean

---

### ✅ **5. DIKARDO SIAHAAN - Integration & Testing (Final Mechanism & Quality Assurance)**

**Deliverables:**
- [ ] Buat file `TransaksiBank.java` (Main implementation class)
  - Mengintegrasikan semua interface dan class
  - Implementasi concrete methods
- [ ] Buat file `BankSystem.java` atau `Main.java` (Testing & Demo)
  - Menampilkan demo penggunaan semua fitur
  - Test case untuk setiap komponen
- [ ] Quality Assurance:
  - Pastikan semua code mengikuti standar Java
  - Testing semua method

---

## 📁 Struktur File yang Diharapkan

```
LK04/
├── README.md (dokumentasi proyek)
├── src/
│   └── banking/
│       ├── Transaksi.java (ARYAN)
│       ├── TransaksiDigital.java (ARYAN)
│       ├── LayananInternasional.java (ARYAN)
│       ├── TransferGlobal.java (ARYAN)
│       ├── Rekening.java (ACHMAD)
│       ├── RekeningValas.java (HIDAYATULLOH)
│       ├── ProtocolKeamanan.java (AHSAL)
│       ├── TransaksiBank.java (DIKARDO)
│       └── Main.java (DIKARDO)
└── .gitignore


## 📌 Ketentuan Implementasi

✅ **WAJIB:**
- Gunakan `@Override` dengan tepat
- Tunjukkan bagaimana `RekeningValas` wajib mengimplementasikan seluruh kontrak dari `TransferGlobal`
- Ada mekanisme perlindungan data menggunakan `final`
- Di dalam class terkecil, terdapat variabel `final ID_SERVER` yang tidak boleh diubah sejak inisialisasi

✅ **Best Practice:**
- Gunakan access modifier (`private`, `protected`, `public`) dengan tepat
- Tambahkan JavaDoc untuk setiap method
- Implementasi error handling yang baik
- Test semua scenario (success & failure cases)

---