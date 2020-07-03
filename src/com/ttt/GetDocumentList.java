package com.ttt;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class GetDocumentList {
    /**
     * 文件路径
     */
    private String pathname;

    //	设置文件路径方法
    public void Set_Document_Path(String path) {
        pathname = path;
    }

    public String Get_Document_Path() {
        if (pathname == null) {
            return "isNull";
        }else {
            return pathname;
        }
    }

    //	扫描文件
    public List Get_List() {
//      new一个文件对象
        File fi = new File(pathname);
//      得到文件路径下所有的文件 或者 文件夹名称 得到一个list
        List list = Arrays.asList(fi.list());
//      输出看一下确认一下
        System.out.println(list);
        return list;
    }
}
