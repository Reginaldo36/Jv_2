/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lexo1;

import java.io.BufferedReader;
import java.io.IOException;

import token.Token;

import java_cup.runtime.Symbol;

public class Analisador {
    private Lexer lexer;
    private BufferedReader reader;
    
    public Analisador(BufferedReader reader) {
        this.lexer = new Lexer(reader);
        this.reader = reader;
    }
    
    public Token getNextToken() {
        Symbol symbol = null;
        try {
            symbol = lexer.next_token();
            if (symbol == null) {
                return new Token(TokenType.EOF, "");
            } else {
                return (Token) symbol.value;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
