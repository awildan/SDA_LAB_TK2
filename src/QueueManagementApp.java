import java.util.Scanner;

public class QueueManagementApp {
  public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      CustomerQueue customerQueue = new CustomerQueue();
      int choice;

      do {
          System.out.println("\n=== Sistem Manajemen Antrean ===");
          System.out.println("1. Tambah Pelanggan ke Antrean");
          System.out.println("2. Layani Pelanggan");
          System.out.println("3. Tampilkan Daftar Antrean");
          System.out.println("4. Keluar");
          System.out.print("Pilihan Anda: ");

          choice = scanner.nextInt();
          scanner.nextLine();

          switch (choice) {
              case 1:
                  System.out.print("Masukkan nama pelanggan: ");
                  String name = scanner.nextLine();
                  customerQueue.addCustomer(name);
                  break;
              case 2:
                  customerQueue.serveCustomer();
                  break;
              case 3:
                  customerQueue.displayQueue();
                  break;
              case 4:
                  System.out.println("Keluar dari aplikasi.");
                  break;
              default:
                  System.out.println("Pilihan tidak valid. Coba lagi.");
          }
      } while (choice != 4);

      scanner.close();
  }
}
