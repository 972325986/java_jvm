package com.ddl.jvm.parse;

import com.beust.jcommander.JCommander;
import org.apache.commons.lang3.StringUtils;

/**
 * @description 类路径解析
 * @author: dengdl
 * @create: 2020-03-07 19:37
 **/
class ClasspathParse extends AbstractParser {

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
        JCommander.getConsole().println("classpath:" + args.classpath + " class:" + args.getMainClass() + " args:" + args.getAppArgs());
    }
}
