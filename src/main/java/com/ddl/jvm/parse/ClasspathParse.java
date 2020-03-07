package com.ddl.jvm.parse;

import org.apache.commons.lang3.StringUtils;

import java.util.logging.Logger;

/**
 * @description 类路径解析
 * @author: dengdl
 * @create: 2020-03-07 19:37
 **/
class ClasspathParse extends AbstractParser {
    private Logger log = Logger.getLogger(this.getClass().getName());

    @Override
    void parse(Args args) {
        if (StringUtils.isNotBlank(args.classpath)) {
            excuse(args);
        }
        if (hasNext()) {
            nextAbstractParser.parse(args);
        }
    }

    @Override
    void excuse(Args args) {
        log.info("classpath:" + args.classpath + " class:" + args.getMainClass() + " args:" + args.getAppArgs());
    }
}
