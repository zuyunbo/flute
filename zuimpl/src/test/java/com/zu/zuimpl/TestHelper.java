package com.zu.zuimpl;


import com.zu.zuimpl.ast.Node;
import com.zu.zuimpl.lexer.Lexer;
import com.zu.zuimpl.lexer.Token;
import com.zu.zuimpl.parser.Parser;

import java.util.List;

public class TestHelper {
    public static List<Token> lex(String source) {
        return new Lexer(source).run();
    }

    public static Node parse(String source) {
        return new Parser(lex(source)).run();
    }





}
