package com.rainmonth.pattern.creational.factorymethod;

public class PdfFactory extends DocumentFactory {

    @Override
    public Document create() {
        Document pdf = new PdfDocument();
        System.out.println("Create the PdfDocument");
        return pdf;
    }
}
