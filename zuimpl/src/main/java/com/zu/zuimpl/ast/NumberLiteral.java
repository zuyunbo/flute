package com.zu.zuimpl.ast;

/**
 * @Author zuyunbo
 * @Date 2021/8/17  5:26 下午
 **/
public class NumberLiteral implements Node{

    public final int value;

    public NumberLiteral(int value) {
        this.value = value;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NumberLiteral that = (NumberLiteral) o;

        return value == that.value;

    }

}
