package com.zu.zuimpl.ast;

public class Expression implements Node{

    public final char operator;
    public final Node left;
    public final Node right;

    public Expression(char operator, Node left, Node right) {
        this.operator = operator;
        this.left = left;
        this.right = right;
    }


    @Override
    public <T> T accept(Visitor<T> visitor) {
        return null;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Expression that = (Expression) o;

        if (operator != that.operator) return false;
        if (left != null ? !left.equals(that.left) : that.left != null) return false;
        return right != null ? right.equals(that.right) : that.right == null;

    }
}
