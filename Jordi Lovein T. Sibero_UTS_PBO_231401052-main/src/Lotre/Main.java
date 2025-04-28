package Lotre;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LotreBoard lotre = new LotreBoard();
        lotre.generateBoard();

        System.out.println("=== COBA KEBERUNTUGANMU SEKARANG!!! ===");

        while (!lotre.isGameOver()) {
            lotre.displayBoard();
            System.out.print("\nMasukkan tebakan Anda (baris kolom): ");
            int row = input.nextInt();
            int col = input.nextInt();

            boolean safe = lotre.guess(row, col);
            if (!safe) {
                lotre.displayBoard();
                System.out.println("Kurang Beruntung. Game Over!");
                break;
            } else if (lotre.isGameOver()) {
                lotre.displayBoard();
                System.out.println("Selamat! Kamu Beruntung!");
                break;
            }
        }

        input.close();
        System.out.println("Terima kasih telah bermain!");
    }
}
