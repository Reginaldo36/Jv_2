/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lexo1;

/**
 *
 * @author me
 */
public class Token {
    
}

package token;

import java.io.*;
import java.util.*;

// Método de entrada para o analisador léxico
public Token yylex() throws IOException {
    int yylength = 0;
    char[] buffer = new char[1024];
    while((yylength = yylexerReader.read(buffer)) != -1) {
        yychar += yylength;
        yytext = String.valueOf(buffer, 0, yylength);
        yytokenpos = yychar - yytext.length();
        for(int i = 0; i < yylength; i++) {
            if(yytext.charAt(i) == '\n') {
                yyline++;
                yychar = 0;
            }
        }
        Token token = yylex();
        if(token != null) {
            return token;
        }
    }
    return null;
}

// Método para configuração do analisador léxico
public void yyreset(Reader reader) {
    yylexerReader = reader;
    yyline = 1;
    yychar = yytokenpos = 0;
}

public void yyclose() throws IOException {
    yylexerReader.close();
}

private Reader yylexerReader;

// Definição dos tipos de token a serem retornados pelo analisador léxico
public enum TokenType {
    IDENTIFIER,
    INTEGER
}

// Definição da classe Token
public static class Token {
    public TokenType type;
    public String text;
    public int line;
    public int position;

    private Token(TokenType type, String text, int line, int position) {
        this.type = type;
        this.text = text;
        this.line = line;
        this.position = position;
    }

    public String toString() {
        return type + " " + text + " (line " + line + ", position " + position + ")";
    }
}