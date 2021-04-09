package com.rainmonth.pattern.behavioral.chain.king;

public abstract class RequestHandler {

    public RequestHandler next;

    public RequestHandler(RequestHandler next) {
        this.next = next;
    }

    public void handleRequest(Request request) {
        if (next != null) {
            next.handleRequest(request);
        }else {
            System.out.println("Oh no,no one can handle it");
        }
    }

    protected void printHandling(Request request) {
        System.out.println(this + " handling request \"" + request + "\"");
    }

    @Override
    public abstract String toString();

}
