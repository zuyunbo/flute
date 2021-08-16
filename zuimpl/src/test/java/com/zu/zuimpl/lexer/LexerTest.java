package com.zu.zuimpl.lexer;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static com.zu.zuimpl.TestHelper.lex;
import static com.zu.zuimpl.lexer.Lexer.number;
import static com.zu.zuimpl.lexer.Lexer.token;
import static org.junit.Assert.assertEquals;

public class LexerTest {
    @Test
    public void lex_single_matcher() throws Exception {
        assertEquals(lex("1"), Collections.singletonList(number(1)));
    }

    @Test
    public void lex_simple_expression() throws Exception {
        assertEquals(lex("1 + 1"), Arrays.asList(number(1), token('+'), number(1)));
    }

    @Test
    public void lex_parens() throws Exception {
        assertEquals(lex("(1 + 1) * 2"),
                Arrays.asList(
                        token('('),
                        number(1),
                        token('+'),
                        number(1),
                        token(')'),
                        token('*'),
                        number(2)));
    }

}