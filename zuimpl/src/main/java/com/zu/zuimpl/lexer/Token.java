package com.zu.zuimpl.lexer;

public class Token {

    public final TokenType tokenType;
    public final Object value;

    public Token(TokenType tokenType) {
        this(tokenType, null);
    }

    public Token(TokenType tokenType, Object value) {
        this.tokenType = tokenType;
        this.value = value;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Token token = (Token) o;

        if (tokenType != token.tokenType) return false;
        return value != null ? value.equals(token.value) : token.value == null;

    }




    @Override
    public String toString() {
        return String.format("%s<%s>", tokenType, value == null ? "" : value.toString());
    }

}
