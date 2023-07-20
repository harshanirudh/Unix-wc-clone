package com.harsha;

public class RequestChainBuilder {
    private AbstractRequestHandler head;
    private AbstractRequestHandler curr;
    public RequestChainBuilder(AbstractRequestHandler head){
        this.head=head;
        curr=head;
    }
    public RequestChainBuilder chain(AbstractRequestHandler next){
        curr.nextHandler(next);
        curr=next;
        return this;
    }
    public AbstractRequestHandler build(){
        return this.head.getNextHandler();
    }
}
