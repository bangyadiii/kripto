public class Transposisi {

    // apa itu Transposition Chiper?
    // Transposition chiper bisa disebut juga dengan chiper permutasi, karena
    // sebenarnya methode chiper text transposisi ini mempermutasikan
    // karakter-karakter plainteks, yaitu dengan menyusun ulang urutan karakter
    // dalam pesan.
    public String encrypt(String plainText, int rowLength, int keyword) {
        plainText = plainText.toUpperCase();
        char[] key = String.valueOf(keyword).toCharArray();
        int baris = plainText.length() / rowLength;
        int kelebihan = plainText.length() % rowLength;
        int barisTambahan = (kelebihan == 0) ? 0 : 1;

        // panjang total char atau jumlah total kotak
        int panjangTotal = (baris + barisTambahan) * rowLength;
        char[][] chp = new char[baris + barisTambahan][rowLength];
        char[] encrypted = new char[panjangTotal];

        int tempCol = -1, tempRow = 0;

        for (int i = 0; i < panjangTotal; i++) {
            tempCol++;
            if (i < plainText.length()) {
                if (tempCol == rowLength) {
                    tempCol = 0;
                    tempRow++;
                }
                chp[tempRow][tempCol] = plainText.charAt(i);
            } else {
                chp[tempRow][tempCol] = 'X';
            }
        }

        int k = 0;
        for (char c : key) {
            for (int i = 0; i < baris + barisTambahan; i++) {
                int cVal = Integer.parseInt(Character.toString(c)) - 1;
                encrypted[k++] = chp[i][cVal];
            }
        }

        return new String(encrypted);
    }

    public String decrypt(String chiper, int colLength, String keyword) {
        chiper = chiper.toUpperCase();
        char[] key = keyword.toCharArray();
        int baris = chiper.length() / colLength;
        int kelebihan = chiper.length() % colLength;
        int totalBaris = baris + (kelebihan == 0 ? 0 : 1);

        // panjang total char atau jumlah total kotak
        int panjangTotal = totalBaris * colLength;
        // panjang total char atau jumlah total kotak
        char[][] chp = new char[totalBaris][key.length];
        char[] decrypt = new char[chiper.length()];

        int t = 0, currentRow = 0, cPos = 0;
        for (int i = 0; i < panjangTotal; i++) {
            if (currentRow > 0 && currentRow % totalBaris == 0) {
                ++cPos;
            }
            char c = key[cPos];
            int cVal = Integer.parseInt(Character.toString(c)) - 1;
            chp[currentRow % totalBaris][cVal] = chiper.charAt(t);
            t++;

            currentRow++;
        }

        int k = 0;
        for (int i = 0; i < totalBaris; i++) {
            for (int j = 0; j < colLength; j++) {
                char currentChar = chp[i][j];
                if (currentChar != 'X')
                    decrypt[k++] = currentChar;
            }
        }
        return new String(decrypt);
    }
}
