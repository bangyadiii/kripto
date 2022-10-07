import java.util.*;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        boolean finish = true;
        while (finish) {
            System.out.println("Pilih Algoritma: ");
            System.out.println("1. Caesar");
            System.out.println("2. Transposition ");
            System.out.println("3. Exit ");

            int masukan = in.nextInt();

            if (masukan == 1) {
                Caesar caesar = new Caesar();
                System.out.println("CAESAR chiper");
                System.out.println("1. Enkripsi ");
                System.out.println("2. Deskripsi ");

                masukan = in.nextInt();
                in.nextLine();
                System.out.println("Masukkan text : ");
                String text = in.nextLine();
                System.out.println("Masukkan key: ");
                int key = in.nextInt();
                in.nextLine();
                String output;
                switch (masukan) {
                    case 1:
                        output = caesar.encrypt(text, key);
                        System.out.println("Encrypted : " + output);
                        break;

                    case 2:
                        output = caesar.deskripsi(text, key);
                        System.out.println("Deskripsi : " + output);
                        break;
                }

            } else if (masukan == 2) {
                Transposisi transposisi = new Transposisi();
                System.out.println("Transposition chiper");
                System.out.println("1. Enkripsi ");
                System.out.println("2. Deskripsi ");

                masukan = in.nextInt();
                in.nextLine();
                String output;
                switch (masukan) {
                    case 1:
                        System.out.println("Masukkan text : ");
                        String text = in.nextLine();
                        System.out.println("Masukkan key: ");
                        int key = in.nextInt();

                        output = transposisi.encrypt(text, 4, key);
                        System.out.println("Encrypted : " + output);
                        break;
                    case 2:
                        System.out.println("Masukkan text : ");
                        String text1 = in.nextLine();
                        System.out.println("Masukkan key: ");
                        String key1 = in.nextLine();

                        output = transposisi.decrypt(text1, 4, key1);
                        System.out.println("Decrypted : " + output);

                        break;
                    case 3:
                        finish = false;
                        break;
                }
            }

        }
    }

}