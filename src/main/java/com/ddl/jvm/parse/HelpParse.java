package com.ddl.jvm.parse;

import com.beust.jcommander.JCommander;

import java.util.logging.Logger;

/**
 * @description 帮助命令
 * @author: dengdl
 * @create: 2020-03-07 18:59
 **/
class HelpParse extends AbstractParser {
    private Logger log = Logger.getLogger(this.getClass().getName());

    @Override
    void parse(Args args) {
        if (args.helpFlag || !args.ok) {
            excuse(args);
        }
        if (hasNext()) {
            nextAbstractParser.parse(args);
        }
    }

    @Override
    void excuse(Args args) {
        JCommander.newBuilder().addObject(args).build().usage();
    }
}
