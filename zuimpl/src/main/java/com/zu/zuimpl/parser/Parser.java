package com.zu.zuimpl.parser;

import com.zu.zuimpl.ast.Node;
import com.zu.zuimpl.ast.NumberLiteral;
import com.zu.zuimpl.lexer.Token;
import com.zu.zuimpl.lexer.TokenType;


import java.util.List;

import static com.zu.zuimpl.lexer.TokenType.NUMBER;

/**
 * @Author zuyunbo
 * @Date 2021/8/17  4:17 下午
 **/
public class Parser {
    private final List<Token> tokens;
    private int index = 0;


    public Parser(List<Token> tokens) {
        this.tokens = tokens;
    }

    public Node run() {
        return expression();
    }

    private Node expression() {
        Node left = term();

        return left;
    }

    private Node term() {
        Node left = factor();

        return left;
    }

    private Node factor() {
        return number();
    }

    private boolean EOF() {
        return index >= tokens.size();
    }

    private Node number() {
        Token token = current();
        if (accept(NUMBER)) {
            return new NumberLiteral((Integer) token.value);
        }
        throw unexpected(token);
    }

    private boolean accept(TokenType tokenType) {
        if (!EOF() && current().tokenType == tokenType) {
            next(1);
            return true;
        } else {
            return false;
        }
    }

    private void next(int step) {
        index += step;
    }

    //当前节点
    private Token current() {
        if (!EOF()) return tokens.get(index);
        throw new IllegalStateException("end of token list");
    }

    private ParserException unexpected(Token token) {
        return new ParserException("Unexpected token " + token.tokenType);
    }


}
