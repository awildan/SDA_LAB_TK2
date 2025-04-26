import java.util.Scanner;

public class MahasiswaApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Menu Pilihan untuk memilih operasi yang ingin dilakukan
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Tampilkan Mahasiswa");
            System.out.println("3. Update Nilai Mahasiswa");
            System.out.println("4. Hapus Mahasiswa");
            System.out.println("5. Keluar");
            System.out.print("Pilih operasi: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (pilihan) {
                case 1:
                    // Menambah Mahasiswa
                    System.out.print("Masukkan NIM: ");
                    String nim = scanner.nextLine();
                    System.out.print("Masukkan Nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Nilai: ");
                    int nilai = scanner.nextInt();
                    MahasiswaList.tambahMahasiswa(nim, nama, nilai);
                    break;
                case 2:
                    // Menampilkan Mahasiswa
                    MahasiswaList.tampilkanMahasiswa();
                    break;
                case 3:
                    // Mengupdate Nilai Mahasiswa
                    MahasiswaList.updateMahasiswa();
                    break;
                case 4:
                    // Menghapus Mahasiswa
                    System.out.print("Masukkan NIM Mahasiswa yang ingin dihapus: ");
                    String nimHapus = scanner.nextLine();
                    MahasiswaList.hapusMahasiswa(nimHapus);
                    break;
                case 5:
                    // Keluar dari Program
                    System.out.println("Terima kasih! Keluar dari program.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }
        }
    }
}
