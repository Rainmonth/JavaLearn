package com.rainmonth.pattern.creational.factorymethod;

/**
 * 简单工厂模式方法实现
 * @author randy
 * @date 2021/7/12 2:12 下午
 */
public class SimpleDocumentFactory {
    public static final int DOC_TYPE_TXT = 0;
    public static final int DOC_TYPE_PDF = 1;

    public static Document create(int docType) {
        if (docType == DOC_TYPE_PDF) {
            return new PdfDocument();
        } else if (docType == DOC_TYPE_TXT) {
            return new TxtDocument();
        }
        return new TxtDocument();
    }
}
