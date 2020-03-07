package com.ddl.jvm.parse;

import com.ddl.jvm.common.Constant;

import java.util.logging.Logger;

/**
 * @description 版本信息
 * @author: dengdl
 * @create: 2020-03-07 19:33
 **/
class VersionParse extends AbstractParser {
    private Logger log = Logger.getLogger(this.getClass().getName());

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
        log.info(Constant.VERSION);
    }
}
