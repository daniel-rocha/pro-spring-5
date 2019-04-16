package com.apress.prospring5.ch3;

public abstract class AbstractLookupDemoBean implements DemoBean {
    // this is gonna get replaced when Spring implements this class.
    public abstract Singer getMySinger();

    @Override
    public void doSomething() {
        getMySinger().sing();
    }
}
