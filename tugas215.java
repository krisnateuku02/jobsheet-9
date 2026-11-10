import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
 
public class tugas215 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // supaya harga tampil dengan titik pemisah ribuan (15.000)
        NumberFormat rp = NumberFormat.getInstance(Locale.forLanguageTag("id-ID"));
 
        String[] menu = {"Nasi Goreng", "Mie Goreng", "Roti Bakar", "Kentang Goreng",
                         "Teh Tarik", "Cappucino", "Chocolate Ice"};
        int[] harga = {15000, 13000, 10000, 12000, 8000, 18000, 20000};
 
        boolean selesai = false;
 
        while (!selesai) {
            System.out.println();
            System.out.println("===== KAFE KAMPUS =====");
            System.out.println("1. Lihat daftar menu");
            System.out.println("2. Cari menu");
            System.out.println("3. Buat pesanan");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            String pilihan = input.nextLine().trim();
 
            if (pilihan.equals("1")) {
                // tampilkan seluruh menu
                System.out.println();
                System.out.println("=========== DAFTAR MENU ============");
                System.out.printf("%-4s%-20s%12s%n", "No", "Menu", "Harga");
                System.out.println("------------------------------------");
                for (int i = 0; i < menu.length; i++) {
                    System.out.printf("%-4d%-20s%12s%n", i + 1, menu[i],
                            "Rp" + rp.format(harga[i]));
                }
 
            } else if (pilihan.equals("2")) {
                // pencarian menu dengan linear search
                System.out.print("Masukkan nama menu yang dicari: ");
                String cari = input.nextLine().trim();
 
                int indeks = -1;
                for (int i = 0; i < menu.length; i++) {
                    if (menu[i].equalsIgnoreCase(cari)) {
                        indeks = i;
                        break;
                    }
                }
 
                if (indeks != -1) {
                    System.out.println(menu[indeks] + " tersedia, harganya Rp"
                            + rp.format(harga[indeks]));
                } else {
                    System.out.println("Maaf, menu \"" + cari + "\" tidak tersedia.");
                }
 
            } else if (pilihan.equals("3")) {
                // jumlah item yang dipesan (minimal 1)
                int jumlah = 0;
                while (jumlah < 1) {
                    System.out.print("Jumlah item yang ingin dipesan: ");
                    if (input.hasNextInt()) {
                        jumlah = input.nextInt();
                    } else {
                        input.next();
                    }
                    input.nextLine();
                    if (jumlah < 1) {
                        System.out.println("Jumlah harus berupa angka minimal 1.");
                    }
                }
 
                // array pesanan terpisah dari array menu
                String[] pesanan = new String[jumlah];
                int[] hargaPesanan = new int[jumlah];
                int total = 0;
 
                for (int i = 0; i < jumlah; i++) {
                    boolean valid = false;
                    while (!valid) {
                        System.out.print("Pesanan ke-" + (i + 1) + ": ");
                        String nama = input.nextLine().trim();
 
                        // validasi: nama harus ada di daftar menu (linear search)
                        for (int j = 0; j < menu.length; j++) {
                            if (menu[j].equalsIgnoreCase(nama)) {
                                pesanan[i] = menu[j];
                                hargaPesanan[i] = harga[j];
                                total += harga[j];
                                valid = true;
                                break;
                            }
                        }
 
                        if (!valid) {
                            System.out.println("Menu \"" + nama
                                    + "\" tidak tersedia, silakan pilih lagi.");
                        }
                    }
                }
 
                // tampilkan daftar pesanan dan total biaya
                System.out.println();
                System.out.println("========== DAFTAR PESANAN ==========");
                System.out.printf("%-4s%-20s%12s%n", "No", "Menu", "Harga");
                System.out.println("------------------------------------");
                for (int i = 0; i < jumlah; i++) {
                    System.out.printf("%-4d%-20s%12s%n", i + 1, pesanan[i],
                            "Rp" + rp.format(hargaPesanan[i]));
                }
                System.out.println("------------------------------------");
                System.out.printf("%-24s%12s%n", "TOTAL BIAYA", "Rp" + rp.format(total));
                System.out.println("====================================");
                System.out.println("Terima kasih sudah memesan!");
 
                selesai = true;
 
            } else if (pilihan.equals("0")) {
                System.out.println("Terima kasih, sampai jumpa.");
                selesai = true;
 
            } else {
                System.out.println("Pilihan tidak valid, masukkan angka 0-3.");
            }
        }
 
        input.close();
    }
}
