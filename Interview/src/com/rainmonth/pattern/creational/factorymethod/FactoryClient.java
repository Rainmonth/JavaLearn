package com.rainmonth.pattern.creational.factorymethod;

public class FactoryClient {
    public static void main(String args[]) {
        DocumentFactory documentFactory = new TxtFactory();
        Document document = documentFactory.create();

        document.open();
        document.close();

        DocumentFactory documentFactory1 = new PdfFactory();
        Document document1 = documentFactory1.create();
        document1.open();
        document1.close();
    }
}
