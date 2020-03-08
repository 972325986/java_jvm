package com.ddl.jvm.parse;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 命令参数
 * @author: dengdl
 * @create: 2020-03-07 18:41
 **/
public class Args {
    @Parameter(names = {"-?", "-help"}, description = "print help message", order = 3, help = true)
    public boolean helpFlag = false;

    @Parameter(names = "-version", description = "print version", order = 2)
    public boolean versionFlag = false;

    @Parameter(names = {"-cp", "-classpath"}, description = "classpath", order = 1)
    public String classpath;
    /**
     * 其他参数
     */
    @Parameter(description = "main class and args")
    public List<String> mainClassAndArgs;
    /**
     * 是否解析成功
     */
    public boolean ok;


    String getMainClass() {
        return mainClassAndArgs != null && !mainClassAndArgs.isEmpty()
                ? mainClassAndArgs.get(0)
                : null;
    }

    List<String> getAppArgs() {
        return mainClassAndArgs != null && mainClassAndArgs.size() > 1
                ? mainClassAndArgs.subList(1, mainClassAndArgs.size())
                : null;
    }

    public static Args parse(String argsStr) {
        List<String> tmp = new ArrayList<>();
        String[] argv = argsStr.split(" ");
        //去除数组中的空字符数组
        for (String s : argv) {
            if (StringUtils.isNotBlank(s)) {
                tmp.add(s);
            }
        }
        Args args = new Args();
        JCommander cmd = JCommander.newBuilder()
                .addObject(args)
                .build();
        try {
            cmd.parse(tmp.toArray(new String[0]));
            args.ok = true;
        } catch (ParameterException ignored) {
            System.out.println("解析失败");
        }
        if (args.helpFlag||!args.ok){
            cmd.usage();
        }
        return args;
    }
}
