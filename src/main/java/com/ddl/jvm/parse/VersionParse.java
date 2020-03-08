package com.ddl.jvm.parse;

import com.beust.jcommander.JCommander;
import com.ddl.jvm.common.Constant;

import java.util.logging.Logger;

/**
 * @description 版本信息
 * @author: dengdl
 * @create: 2020-03-07 19:33
 **/
class VersionParse extends AbstractParser {

    @Override
    void parse(Args args) {
        if (args.versionFlag) {
            excuse(args);
        }
        if (hasNext()) {
            nextAbstractParser.parse(args);
        }
    }

    @Override
    void excuse(Args args) {
        JCommander.getConsole().println(Constant.VERSION);
    }
}
