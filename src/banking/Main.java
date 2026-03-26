package banking;

import java.util.Scanner;

/**
 * Demo dan pengujian sederhana semua komponen LK04.
 */
public class Main {

    private static void tampilMenu() {
        System.out.println();
        System.out.println("=== SMART BANKING ECOSYSTEM - GakMauRugi ===");
        System.out.println("1. Cek saldo");
        System.out.println("2. Setor tunai");
        System.out.println("3. Tarik tunai");
        System.out.println("4. Transfer global aman");
        System.out.println("5. Konversi saldo ke IDR");
        System.out.println("6. Info server keamanan");
        System.out.println("0. Keluar");
        System.out.print("Pilih menu: ");
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ProtocolKeamanan protocol = new ProtocolKeamanan();
            TransaksiBank akun = new TransaksiBank(
                    "3311009988",
                    1500.0,
                    "Nasabah Demo",
                    "USD",
                    16500.0,
                    protocol
            );

            int pilihan = -1;
            while (pilihan != 0) {
                tampilMenu();

                if (!scanner.hasNextInt()) {
                    System.out.println("Input menu harus angka.");
                    scanner.nextLine();
                    continue;
                }
                pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1 -> akun.cekSaldo();
                    case 2 -> {
                        System.out.print("Masukkan nominal setor: ");
                        double nominalSetor = scanner.nextDouble();
                        scanner.nextLine();
                        akun.setorTunai(nominalSetor);
                    }
                    case 3 -> {
                        System.out.print("Masukkan nominal tarik: ");
                        double nominalTarik = scanner.nextDouble();
                        scanner.nextLine();
                        akun.tarikTunai(nominalTarik);
                    }
                    case 4 -> {
                        System.out.print("Nomor rekening tujuan: ");
                        String tujuan = scanner.nextLine();
                        System.out.print("Negara tujuan: ");
                        String negara = scanner.nextLine();
                        System.out.print("Jumlah transfer (valas): ");
                        double jumlah = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Masukkan PIN 6 digit (akhiri dengan 4 digit private key): ");
                        String pin = scanner.nextLine();

                        boolean berhasil = akun.transferAmanGlobal(tujuan, negara, jumlah, pin);
                        if (berhasil) {
                            System.out.println("✓ Transfer global aman berhasil.");
                        } else {
                            System.out.println("✗ Transfer global aman gagal.");
                        }
                    }
                    case 5 -> akun.konversiKeMataUangLokal();
                    case 6 -> {
                        System.out.println("ID Server      : " + protocol.ID_SERVER);
                        System.out.println("Public Key     : " + protocol.getPublicKey());
                        System.out.println("Private Key    : " + protocol.getPrivateKeyMasked());
                    }
                    case 0 -> System.out.println("Terima kasih. Sistem ditutup.");
                    default -> System.out.println("Menu tidak tersedia.");
                }
            }
        }
    }
}
