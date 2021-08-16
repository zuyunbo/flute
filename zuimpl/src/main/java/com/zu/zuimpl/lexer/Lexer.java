package com.zu.zuimpl.lexer;

import java.util.*;

public class Lexer {

    private static final List<Character> OPERATORS = Arrays.asList('+', '-', '*', '/');
    private static final List<Character> PARENS = Arrays.asList('(', ')');
    private static final HashMap<Character, TokenType> TOKEN_TYPES = new HashMap<Character, TokenType>(7) {{
        put('+', TokenType.PLUS);
        put('-', TokenType.MINUS);
        put('*', TokenType.TIMES);
        put('/', TokenType.DIVIDE);
        put('(', TokenType.LEFT_PAREN);
        put(')', TokenType.RIGHT_PAREN);
        put(',', TokenType.COMMA);
    }};

    public static final List<Character> SEPARATORS = Collections.singletonList(',');

    private final String source;

    private int index = 0;

    public Lexer(String source) {
        this.source = source;
    }

    public List<Token> run() {
        List<Token> tokens = new ArrayList<>();
        while (!EOF()) {
            tokens.add(nextToken());
        }
        return tokens;
    }

    private Token nextToken() {
        while (!EOF()) {
            if (Character.isDigit(current())) {
                String number = nextNumber();
                return number(Integer.parseInt(number));
            } else if (isOperator(current()) || isParen(current()) || isSeparator(current())) {
                char symbol = current();
                next(1);
                return token(symbol);
            } else if (Character.isAlphabetic(current())) {
                String id = nextIdentifier();
                return id(id);
            } else if (Character.isSpaceChar(current())) {
                next(1);
                continue;
            }
            throw unknown(current());
        }
        throw new IllegalStateException("end of source");
    }

    public static Token id(String id) {
        return new Token(TokenType.ID, id);
    }

    private String nextIdentifier() {
        StringBuilder sb = new StringBuilder();
        while (!EOF() && (Character.isAlphabetic(current()) || Character.isDigit(current()))) {
            sb.append(current());
            next(1);
        }
        return sb.toString();
    }

    private String nextNumber() {
        StringBuilder sb = new StringBuilder();
        while (!EOF() && Character.isDigit(current())) {
            sb.append(current());
            next(1);
        }
        return sb.toString();
    }

    private LexerException unknown(char character) {
        return new LexerException("Unknown character: " + character);
    }

    private boolean isParen(char character) {
        return PARENS.contains(character);
    }

    private boolean isOperator(char current) {
        return OPERATORS.contains(current);
    }

    private boolean isSeparator(char current) {
        return SEPARATORS.contains(current);
    }


    private void next(int i) {
        index += i;
    }


    private char current() {
        if (!EOF()) {
            return source.charAt(index);
        }
        throw new IllegalStateException("end of source");
    }

    public static Token number(int value) {
        return new Token(TokenType.NUMBER, value);
    }

    public static Token token(char symbol) {
        return new Token(TOKEN_TYPES.get(symbol), symbol);
    }


    private boolean EOF() {
        return index >= source.length();
    }


}
