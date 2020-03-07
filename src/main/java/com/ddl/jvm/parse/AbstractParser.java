package com.ddl.jvm.parse;

/**
 * @description 命令解析  责任链
 * @author: dengdl
 * @create: 2020-03-07 18:40
 **/
public abstract class AbstractParser {
    AbstractParser nextAbstractParser;

    protected void setNextParser(AbstractParser nextAbstractParser) {
        this.nextAbstractParser = nextAbstractParser;
    }

    boolean hasNext() {
        return nextAbstractParser != null;
    }

    /**
     * 解析命令
     *
     * @param args
     */
    abstract void parse(Args args);

    /**
     * 执行命令
     *
     * @param args
     */
    abstract void excuse(Args args);
}
