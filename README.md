# PEMROGRAMAN LANJUT - Latihan Kerja 04 (LK04)

## Studi Kasus: Smart Banking Ecosystem

**Bank: GakMauRugi** - sistem transaksi aman, modular, dan memenuhi konsep OOP lanjutan.

---

## 👥 Anggota Tim

| No | Nama | NIM |
|---|---|---|
| 1 | ARYAN ZAKY PRAYOGO | 255150207111059 |
| 2 | ACHMAD HUJAIRI | 255150200111042 |
| 3 | M. HIDAYATULLOH H. A. M | 255150201111025 |
| 4 | M. AHSHAL ZILHAMSYAH | 255150200111041 |
| 5 | DIKARDO SIAHAAN | 255150200111040 |

---

## 🗂️ Mapping Anggota → File → Kontribusi

| Anggota | File yang Dikerjakan | Kontribusi Spesifik |
|---|---|---|
| **ARYAN ZAKY PRAYOGO** | `src/banking/Transaksi.java` | Mendesain kontrak transaksi dasar: `proses()`, `validasi()`, `getJenisTransaksi()` |
|  | `src/banking/TransaksiDigital.java` | Mendesain kontrak transaksi digital: `prosesOnline()`, `getTokenDigital()` |
|  | `src/banking/LayananInternasional.java` | Mendesain kontrak transaksi internasional: `prosesInternasional()`, `getNegaraTujuan()` |
|  | `src/banking/TransferGlobal.java` | Menyusun multiple inheritance (`TransaksiDigital` + `LayananInternasional`) dan kontrak `transferGlobal()` + `verifikasiInternasional()` |
| **ACHMAD HUJAIRI** | `src/banking/Rekening.java` | Membangun superclass rekening: atribut inti, constructor, operasi `setorTunai()`, `tarikTunai()`, `cekSaldo()`, transfer dasar, serta implement `Transaksi` |
| **M. HIDAYATULLOH H. A. M** | `src/banking/RekeningValas.java` | Membangun subclass valas: `jenisMataUang`, `kursRate (final)`, `konversiKeMataUangLokal()`, `transferAntarNegara()`, dan implement penuh seluruh kontrak `TransferGlobal` |
| **M. AHSHAL ZILHAMSYAH** | `src/banking/ProtocolKeamanan.java` | Membangun modul keamanan final: `ID_SERVER (final)`, validasi transaksi, enkripsi/dekripsi data, token, dan verifikasi PIN |
| **DIKARDO SIAHAAN** | `src/banking/TransaksiBank.java` | Integrasi seluruh modul (rekening valas + keamanan) melalui mekanisme `transferAmanGlobal(...)` |
|  | `src/banking/Main.java` | Menyusun aplikasi demo interaktif berbasis menu (`Scanner`) dan pengujian skenario utama |
| **Kolaboratif Tim** | `src/banking/Date.java` | Menyediakan representasi tanggal internal (`banking.Date`) agar requirement `Date tanggalMembuka` tetap terpenuhi tanpa melanggar batasan import |
| **Kolaboratif Tim** | `README.md`, `.gitignore` | Dokumentasi final, sinkronisasi requirement, dan housekeeping repository |

### Catatan Dokumentasi Kontribusi

- Mapping di atas merepresentasikan **penanggung jawab utama** per file/modul.
- Pada tahap finalisasi, terdapat proses **review silang** antar anggota untuk sinkronisasi arsitektur, naming, dan alur integrasi.

---

## ✅ Ringkasan Implementasi Final

Proyek ini **sudah selesai** dan mengimplementasikan:

1. **Interface Inheritance + Multiple Inheritance**
   - `Transaksi`
   - `TransaksiDigital extends Transaksi`
   - `LayananInternasional extends Transaksi`
   - `TransferGlobal extends TransaksiDigital, LayananInternasional`

2. **Class Inheritance**
   - `Rekening` sebagai superclass transaksi dasar
   - `RekeningValas extends Rekening implements TransferGlobal`

3. **Final Mechanism + Security**
   - `ProtocolKeamanan` sebagai `final class`
   - `ID_SERVER` sebagai `final` constant
   - validasi transaksi, token digital, enkripsi/dekripsi, verifikasi PIN

4. **Integrasi Sistem**
   - `TransaksiBank` menggabungkan modul rekening valas + keamanan
   - `Main` sebagai demo interaktif berbasis menu

---

## 🧩 Arsitektur Mekanisme Sistem

### 1) Lapisan Kontrak (Interface)

- `Transaksi`:
  - `proses()`
  - `validasi()`
  - `getJenisTransaksi()`
- `TransaksiDigital`:
  - `prosesOnline()`
  - `getTokenDigital()`
- `LayananInternasional`:
  - `prosesInternasional()`
  - `getNegaraTujuan()`
- `TransferGlobal`:
  - `transferGlobal()`
  - `verifikasiInternasional()`

### 2) Lapisan Domain Rekening

- `Rekening`
  - atribut: `nomorRekening`, `saldo`, `namaPemilik`, `tanggalMembuka`
  - fitur: setor, tarik, cek saldo, transfer dasar
  - implement `Transaksi`

- `RekeningValas`
  - tambahan: `jenisMataUang`, `kursRate (final)`
  - fitur: konversi ke rupiah, transfer antar negara
  - implement penuh seluruh kontrak `TransferGlobal`

### 3) Lapisan Keamanan

- `ProtocolKeamanan (final)`
  - `ID_SERVER (final)`
  - `validasiTransaksi(Transaksi t)`
  - `enkripsiData(String data)`
  - `deskripsiData(String data)`
  - `generateToken()`
  - `verifikasiPin(String pin)`

### 4) Lapisan Integrasi

- `TransaksiBank`
  - mewarisi `RekeningValas`
  - method utama: `transferAmanGlobal(...)`
  - alur keamanan:
    1. set konteks tujuan transaksi
    2. verifikasi PIN
    3. validasi objek transaksi
    4. generate token digital
    5. proses online + internasional
    6. verifikasi internasional
    7. eksekusi transfer
    8. audit terenkripsi + terdekripsi

- `Main`
  - menu interaktif untuk:
    - cek saldo
    - setor tunai
    - tarik tunai
    - transfer global aman
    - konversi saldo valas ke IDR
    - lihat info server keamanan

---

## 📁 Struktur File Aktual

```
LK04/
├── README.md
├── .gitignore
└── src/
    └── banking/
        ├── Date.java
        ├── LayananInternasional.java
        ├── Main.java
        ├── ProtocolKeamanan.java
        ├── Rekening.java
        ├── RekeningValas.java
        ├── Transaksi.java
        ├── TransaksiBank.java
        ├── TransaksiDigital.java
        └── TransferGlobal.java
```

---

## ▶️ Cara Kompilasi & Menjalankan

Dari root proyek (`LK04`):

1. Kompilasi:
   - `javac src/banking/*.java`
2. Jalankan:
   - `java -cp src banking.Main`

---

## 🧪 Skenario Uji yang Disarankan

1. **Setor valid** (`> 0`) dan **setor invalid** (`<= 0`)
2. **Tarik valid** (saldo cukup) dan **tarik gagal** (saldo tidak cukup)
3. **Transfer global sukses** (PIN valid, nominal valid, negara valid)
4. **Transfer global gagal**:
   - PIN tidak valid
   - nominal `<= 0`
   - saldo tidak cukup
   - negara tujuan kosong
5. **Konversi mata uang lokal** via `konversiKeMataUangLokal()`

---

## 📌 Status Requirement README

- [x] Interface hierarchy terpenuhi
- [x] Multiple inheritance pada `TransferGlobal` terpenuhi
- [x] `RekeningValas` mengimplementasikan seluruh kontrak `TransferGlobal`
- [x] Mekanisme `final class` dan `final variable` terpenuhi
- [x] Integrasi sistem + demo menu berjalan
- [x] Error handling dasar untuk skenario gagal tersedia

---
