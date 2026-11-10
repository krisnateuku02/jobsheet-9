import java.util.Scanner;

public class tugas115 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        
        int jumlah;
        do {
            System.out.print("Masukkan banyaknya nilai mahasiswa: ");
            jumlah = input.nextInt();
            if (jumlah <= 0) {
                System.out.println("Jumlah harus lebih dari 0, coba lagi.");
            }
        } while (jumlah <= 0);

        int[] nilai = new int[jumlah];
        int total = 0;

       
        for (int i = 0; i < nilai.length; i++) {
            System.out.print("Masukkan nilai mahasiswa ke-" + (i + 1) + ": ");
            nilai[i] = input.nextInt();
            total += nilai[i];
        }

        
        double rata2 = (double) total / nilai.length;

        
        int tertinggi = nilai[0];
        int terendah = nilai[0];
        for (int i = 1; i < nilai.length; i++) {
            if (nilai[i] > tertinggi) tertinggi = nilai[i];
            if (nilai[i] < terendah) terendah = nilai[i];
        }

        System.out.println();
        System.out.println("HASIL PENGOLAHAN NILAI");
        System.out.printf("Rata-rata       : %.2f%n", rata2);
        System.out.println("Nilai tertinggi : " + tertinggi);
        System.out.println("Nilai terendah  : " + terendah);

        // semua nilai beserta status kelulusan
        System.out.println();
        System.out.println("Daftar nilai dan status kelulusan:");
        for (int i = 0; i < nilai.length; i++) {
            String status = (nilai[i] > 70) ? "LULUS" : "TIDAK LULUS";
            System.out.println("Mahasiswa ke-" + (i + 1) + ": " + nilai[i]
                    + " (" + status + ")");
        }

        input.close();
    }
}