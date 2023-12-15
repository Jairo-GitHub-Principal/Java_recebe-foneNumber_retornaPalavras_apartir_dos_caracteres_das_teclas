package numberFone;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class NumberFone {

	
    // Mapeamento dos caracteres associados a cada tecla numérica no teclado do telefone
    private static final Map<Character, String> digitToChars = new HashMap<>();
    
    static {
        digitToChars.put('2', "abc");
        digitToChars.put('3', "def");
        digitToChars.put('4', "ghi");
        digitToChars.put('5', "jkl");
        digitToChars.put('6', "mno");
        digitToChars.put('7', "pqrs");
        digitToChars.put('8', "tuv");
        digitToChars.put('9', "wxyz");
    }

    // Função principal para gerar palavras a partir de um número de telefone
    public static void generateWords(String phoneNumber) {
        generateWordsHelper(phoneNumber, "", 0);
    }

    // Função auxiliar recursiva para gerar palavras
    private static void generateWordsHelper(String phoneNumber, String currentWord, int index) {
        if (index == phoneNumber.length()) {
            System.out.println(currentWord);
            return;
        }

        char digit = phoneNumber.charAt(index);
        if (digitToChars.containsKey(digit)) {
            String characters = digitToChars.get(digit);
            for (int i = 0; i < characters.length(); i++) {
                generateWordsHelper(phoneNumber, currentWord + characters.charAt(i), index + 1);
            }
        } else {
            // Se o dígito não estiver mapeado, apenas continue com o próximo dígito
            generateWordsHelper(phoneNumber, currentWord + digit, index + 1);
        }
    }

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in); // adicionei
        System.out.println("digite um numero de telefone"); // adicionei
    	String numberCell = sc.next();  // usuario informa o telefone
		
        String phoneNumber = numberCell;//implementei
        System.out.println("Palavras possíveis a partir do número " + phoneNumber + ":");
        generateWords(phoneNumber);
    }
}

