import java.util.LinkedList;
import java.util.Queue;

// Class untuk mengatur antrean pelanggan
class CustomerQueue {
    private Queue<String> customerQueue;

    // Constructor
    public CustomerQueue() {
        customerQueue = new LinkedList<>();
    }

    // Method untuk menambahkan pelanggan ke antrean
    public void addCustomer(String name) {
        long startTime = System.nanoTime();

        customerQueue.add(name);
        System.out.println("Pelanggan " + name + " ditambahkan ke antrean.");

        long endTime = System.nanoTime();
        System.out.println("Waktu eksekusi tambah pelanggan: " + (endTime - startTime) + " nanoseconds");
    }

    // Method untuk melayani pelanggan (menghapus dari antrean)
    public void serveCustomer() {
        long startTime = System.nanoTime();

        if (customerQueue.isEmpty()) {
            System.out.println("Antrean kosong. Tidak ada pelanggan yang dapat dilayani.");
        } else {
            String servedCustomer = customerQueue.poll();
            System.out.println("Melayani pelanggan: " + servedCustomer);
        }

        long endTime = System.nanoTime();
        System.out.println("Waktu eksekusi layani pelanggan: " + (endTime - startTime) + " nanoseconds");
    }

    // Method untuk menampilkan daftar pelanggan dalam antrean
    public void displayQueue() {
        long startTime = System.nanoTime();

        if (customerQueue.isEmpty()) {
            System.out.println("Antrean kosong.");
        } else {
            System.out.println("Daftar pelanggan dalam antrean:");
            for (String customer : customerQueue) {
                System.out.println("- " + customer);
            }
        }

        long endTime = System.nanoTime();
        System.out.println("Waktu eksekusi tampilkan antrean: " + (endTime - startTime) + " nanoseconds");
    }
}