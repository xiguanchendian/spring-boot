package com.xgcd.thinkinginjava.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 查看一个目录列表
 * 不带参数的list()可以获得此File对象包含的全部列表
 * 如果想要获取所有扩展名为.java的文件,需要用到"目录过滤器"
 */
public class DirList {
    public static void main(String[] args) {
//        List<String> list2 = new ArrayList<>();
//        list2.add("pom.xml");
//        List<String> resultList = new ArrayList<>();
//        resultList.addAll(list2);
//        args = resultList.toArray(new String[resultList.size()]);

        File path = new File(".");
        String[] list;
        if (args.length == 0)
            list = path.list();// 获得此file对象包含的全部列表,"."表示当前项目
        else
            list = path.list(new DirFilter(args[0]));
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list)
            System.out.println(dirItem);
            /*.git
            .idea
            pom.xml
            spring-boot.iml
            src
            target*/
    }

    static class DirFilter implements FilenameFilter {
        private Pattern pattern;

        public DirFilter(String regex) {
            pattern = Pattern.compile(regex);
        }

        public boolean accept(File dir, String name) {
            return pattern.matcher(name).matches();
        }
    }
}
