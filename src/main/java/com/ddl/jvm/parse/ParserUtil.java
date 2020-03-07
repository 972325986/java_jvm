package com.ddl.jvm.parse;

/**
 * @author: dengdl
 * @create: 2020-03-07 19:49
 **/
public class ParserUtil {
    private static AbstractParser helpParser = new HelpParse();
    private static AbstractParser versionParser = new VersionParse();
    private static AbstractParser classpathParser = new ClasspathParse();

    static {
        helpParser.setNextParser(versionParser);
        versionParser.setNextParser(classpathParser);
    }

    public static void parse(Args args) {
        helpParser.parse(args);
    }
}
