package com.zu.zuimpl.ast;

/**
 * @Author zuyunbo
 * @Date 2021/8/17  4:24 下午
 **/
public interface Visitor<T> {

    T visit(NumberLiteral num);
    T visit(Expression expr);
    T visit(Identifier id);
    T visit(FunCall funCall);


}
