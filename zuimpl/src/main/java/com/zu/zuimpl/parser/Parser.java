package com.zu.zuimpl.parser;

import com.zu.zuimpl.ast.*;
import com.zu.zuimpl.lexer.Token;
import com.zu.zuimpl.lexer.TokenType;


import java.util.ArrayList;
import java.util.List;

import static com.zu.zuimpl.lexer.TokenType.*;

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
        if (accept(PLUS) || accept(MINUS)) {
            rewind(1);
            char operator = operator();
            Node right = expression();
            return new Expression(operator, left, right);
        }
        return left;
    }

    private Node term() {
        Node left = factor();
        if (accept(TIMES) || accept(DIVIDE)) {
            rewind(1);
            char operator = operator();
            Node right = term();
            return new Expression(operator, left, right);
        }
        return left;
    }

    private Node factor() {
        if (accept(LEFT_PAREN)) {
            Node expr = expression();
            expect(RIGHT_PAREN);
            return expr;
        } else if (accept(ID)) {
            rewind(1);
            return funCall();
        } else {
            return number();
        }
    }

    private boolean EOF() {
        return index >= tokens.size();
    }

    private void expect(TokenType tokenType) {
        if (!accept(tokenType)) {
            throw unexpected(current());
        }
    }

    private Node funCall() {
        Node id = identifier();
        expect(LEFT_PAREN);
        ArrayList<Node> nodes = new ArrayList<>();
        nodes.add(expression());
        while (accept(COMMA)) {
            nodes.add(expression());
        }
        expect(RIGHT_PAREN);
        return new FunCall(id, nodes);
    }

    private Node identifier() {
        Token token = current();
        if (accept(ID)) {
            return new Identifier((String) token.value);
        }
        throw unexpected(token);
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

    private char operator() {
        Token token = current();
        next(1);
        return (char) token.value;
    }


    //当前节点
    private Token current() {
        if (!EOF()) return tokens.get(index);
        throw new IllegalStateException("end of token list");
    }

    private void rewind(int step) {
        index -= step;
    }

    private void next(int step) {
        index += step;
    }

    private ParserException unexpected(Token token) {
        return new ParserException("Unexpected token " + token.tokenType);
    }


}
