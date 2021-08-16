package com.zu.zuimpl;


import com.zu.zuimpl.lexer.Lexer;
import com.zu.zuimpl.lexer.Token;

import java.util.List;

public class TestHelper {
    public static List<Token> lex(String source) {
        return new Lexer(source).run();
    }




}
