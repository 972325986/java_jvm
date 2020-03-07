package com.ddl.jvm;

import com.ddl.jvm.parse.Args;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @description 命令行测试
 * @author: dengdl
 * @create: 2020-03-07 13:56
 **/
public class TestCommand {
    @Test
    public void test() {
        assertTrue(Args.parse("-?").helpFlag);
        assertTrue(Args.parse("-help").helpFlag);
        assertTrue(Args.parse("-version").versionFlag);
        assertEquals("11111", Args.parse("-cp   11111").classpath);
        assertEquals("11111", Args.parse("-classpath  11111").classpath);
        assertEquals(Arrays.asList("11111", "2222"), Args.parse("11111  2222").mainClassAndArgs);
        assertFalse(Args.parse("-cp").ok);
        assertFalse(Args.parse("-classpath").ok);
    }

    @Test
    public void test2() {
        Args.parse("Main  11111");
    }
}
