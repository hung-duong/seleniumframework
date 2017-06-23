package com.framework.tests;

import com.framework.utilities.XMLUtil;

/**
 * Created by hungduong on 5/27/17.
 */
public class RunTest {
    public static void main(String[] args) throws Exception {
        XMLUtil.createXml();
        XMLUtil.autoRunXml();
    }
}
