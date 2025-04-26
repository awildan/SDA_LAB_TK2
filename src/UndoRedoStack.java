import java.util.Scanner;
import java.util.Stack;

public class UndoRedoStack {
    private Stack<String> undoStack = new Stack<>();
    private Stack<String> redoStack = new Stack<>();
    private String currentText = "";
    private Scanner scanner = new Scanner(System.in);

    public void addText(String text) {
        undoStack.push(currentText);
        currentText += text;
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            redoStack.push(currentText);
            currentText = undoStack.pop();
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            undoStack.push(currentText);
            currentText = redoStack.pop();
        }
    }

    public void displayCurrentTextWithScanner() {
        System.out.println("\n=== Text Editor ===");
        System.out.println("Teks saat ini: " + currentText);
        System.out.println("Menu:");
        System.out.println("1. Tambah teks");
        System.out.println("2. Undo");
        System.out.println("3. Redo");
        System.out.println("4. Keluar");
        System.out.print("Pilihan Anda: ");
    }

    public static void main(String[] args) {
        UndoRedoStack editor = new UndoRedoStack();
        Scanner mainScanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            editor.displayCurrentTextWithScanner();
            int choice = mainScanner.nextInt();
            mainScanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Masukkan teks yang ingin ditambahkan: ");
                    String newText = mainScanner.nextLine();
                    editor.addText(newText);
                    break;
                case 2:
                    editor.undo();
                    break;
                case 3:
                    editor.redo();
                    break;
                case 4:
                    running = false;
                    System.out.println("Keluar dari program...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
        mainScanner.close();
    }
}