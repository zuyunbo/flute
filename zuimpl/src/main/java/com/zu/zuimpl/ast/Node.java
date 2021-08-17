package com.zu.zuimpl.ast;


/**
 * @Author zuyunbo
 * @Date 2021/8/17  4:22 下午
 **/
public interface Node {
    <T> T accept(Visitor<T> visitor);

}
