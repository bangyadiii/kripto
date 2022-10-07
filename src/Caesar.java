public class Caesar {
    
    public static final String ALPHAAAA = "abcdefghijklmnopqrstuvwxyz";

    String encrypt(String input, int key) {
        input = input.toLowerCase();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < input.length(); i++) {
            int charPos = ALPHAAAA.indexOf(input.charAt(i));
            int indexValue = (charPos + key) % 26;
            char charValue = ALPHAAAA.charAt(indexValue);
            
            sb.append(charValue);
        }

        return sb.toString();
    }

    String deskripsi(String input, int key) {
        input = input.toLowerCase();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < input.length(); i++) {
            int charPos = ALPHAAAA.indexOf(input.charAt(i));
            int indexValue = (charPos - key) % 26;
            if(indexValue < 0) {
                //
                indexValue = ALPHAAAA.length() + indexValue;
            }

            char charValue = ALPHAAAA.charAt(indexValue);
            sb.append(charValue);
        }

        return sb.toString();

    }   
}
