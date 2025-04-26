import java.util.Scanner;

public class MahasiswaList {
    private String nim;
    private String nama;
    private int nilai;
    private MahasiswaList next;

    private static MahasiswaList head = null;

    public MahasiswaList(String nim, String nama, int nilai) {
        this.nim = nim;
        this.nama = nama;
        this.nilai = nilai;
        this.next = null;
    }

    private static void printExecutionTime(String aktivitas, long startTime) {
        long endTime = System.nanoTime();
        System.out.println("Waktu eksekusi " + aktivitas + ": " + (endTime - startTime) + " nanoseconds\n");
    }

    public static void updateMahasiswa() {
        Scanner scanner = new Scanner(System.in);
        long startTime = System.nanoTime();

        System.out.print("Masukkan NIM Mahasiswa yang ingin diupdate: ");
        String nimInput = scanner.nextLine();

        MahasiswaList cur = head;
        boolean found = false;
        while (cur != null) {
            if (cur.nim.equals(nimInput)) {
                found = true;
                break;
            }
            cur = cur.next;
        }

        if (found) {
            System.out.print("Masukkan nilai baru: ");
            cur.nilai = scanner.nextInt();
            System.out.println(">> Nilai berhasil diupdate.\n");
        } else {
            System.out.println(">> Mahasiswa dengan NIM tersebut tidak ditemukan.\n");
        }

        printExecutionTime("Mengupdate Mahasiswa", startTime);
    }

    public static void tambahMahasiswa(String nim, String nama, int nilai) {
        long startTime = System.nanoTime();

        MahasiswaList baru = new MahasiswaList(nim, nama, nilai);
        if (head == null) {
            head = baru;
        } else {
            MahasiswaList cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = baru;
        }
        System.out.println(">> Mahasiswa berhasil ditambahkan.\n");
        printExecutionTime("Menambah Mahasiswa", startTime);
    }

    public static void tampilkanMahasiswa() {
        long startTime = System.nanoTime();

        if (head == null) {
            System.out.println(">> Tidak ada data mahasiswa.\n");
            printExecutionTime("Menampilkan Mahasiswa", startTime);
            return;
        }
        MahasiswaList cur = head;
        int i = 1;
        System.out.println("Daftar Mahasiswa:");
        while (cur != null) {
            System.out.printf("%d. NIM: %s, Nama: %s, Nilai: %d\n", i, cur.nim, cur.nama, cur.nilai);
            cur = cur.next;
            i++;
        }
        System.out.println();
        printExecutionTime("Menampilkan Mahasiswa", startTime);
    }

    public static void hapusMahasiswa(String nim) {
        long startTime = System.nanoTime();
        boolean success = false;

        if (head != null) {
            if (head.nim.equals(nim)) {
                head = head.next;
                success = true;
            } else {
                MahasiswaList prev = head;
                MahasiswaList cur = head.next;
                while (cur != null) {
                    if (cur.nim.equals(nim)) {
                        prev.next = cur.next;
                        success = true;
                        break;
                    }
                    prev = cur;
                    cur = cur.next;
                }
            }
        }

        if (success) {
            System.out.println(">> Mahasiswa berhasil dihapus.\n");
        } else {
            System.out.println(">> Mahasiswa tidak ditemukan.\n");
        }
        printExecutionTime("Menghapus Mahasiswa", startTime);
    }
}
