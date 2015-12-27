package dcloud.mybatis.tem.test;

import org.mybatis.generator.api.ShellRunner;

/**
 * Created by ligson on 2015/11/21.
 */
public class CodeTool {
    public static void main(String args[]) {
        String params[] = new String[]{"-configfile","E:\\workspace\\githup\\dcloud\\mybatis_dao\\src\\test\\resources\\generator.xml", "-overwrite"};
        ShellRunner.main(params);
    }
}
