import java.util.*;

public class Kripto {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        boolean finish = true;
        while (finish) {
            Transposisi transposisi = new Transposisi();
            System.out.println("====================");
            System.out.println("Transposition chiper");
            System.out.println("====================");
            System.out.println("1. Enkripsi ");
            System.out.println("2. Deskripsi ");

            int masukan = in.nextInt();
            in.nextLine();
            String output;
            switch (masukan) {
                case 1:
                    System.out.print("Masukkan text : ");
                    String text = in.nextLine();
                    System.out.print("Masukkan panjang baris: ");
                    int rowLength = in.nextInt();

                    in.nextLine();
                    System.out.print("Masukkan key: ");
                    int key = in.nextInt();

                    output = transposisi.encrypt(text, rowLength, key);
                    System.out.println("\nEncrypted : " + output + "\n");
                    break;
                case 2:
                    System.out.print("Masukkan text : ");
                    String text1 = in.nextLine();

                    System.out.print("Masukkan panjang baris: ");
                    int panjangBaris = in.nextInt();
                    in.nextLine();

                    System.out.print("Masukkan key: ");
                    String key1 = in.nextLine();

                    output = transposisi.decrypt(text1, panjangBaris, key1);
                    System.out.println("\nDecrypted : " + output + "\n");

                    break;
                case 3:
                    finish = false;
                    break;
            }
        }

    }

}