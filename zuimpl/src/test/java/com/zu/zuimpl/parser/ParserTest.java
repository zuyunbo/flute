package com.zu.zuimpl.parser;

import com.zu.zuimpl.ast.Node;
import com.zu.zuimpl.ast.NumberLiteral;
import org.junit.Test;

import static com.zu.zuimpl.TestHelper.parse;
import static org.junit.Assert.assertEquals;

/**
 * @Author zuyunbo
 * @Date 2021/8/17  6:04 下午
 **/
public class ParserTest {

    @Test
    public void parse_single_number() throws Exception {
        Node node = parse("1");

        assertEquals(node, num(1));
    }


    private NumberLiteral num(int value) {
        return new NumberLiteral(value);
    }

}
