package org.arctic.mybatis_pagehelper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by Administrator on 2018/5/11 0011.
 */
public class PageHelperUtil {
    public static void main(String[] args){
        List list = Lists.newArrayList(10);
        PageHelper.startPage(1,10);
        PageInfo result = new PageInfo(list);
        result.setList(list);
    }
}
