package com.sdl.selenium.conditions;

import com.sdl.selenium.web.WebLocator;
import org.apache.log4j.Logger;

/**
 * When specified element has been rendered, but it was considered as a fail result (instance of FailCondition)
 */
public class RenderFailCondition extends FailCondition implements RenderCondition {
    private static final Logger logger = Logger.getLogger(RenderFailCondition.class);

    private WebLocator component;

    private RenderFailCondition(String message) {
        super(message);
    }

    public RenderFailCondition(WebLocator component){
        this(component.toString());
        this.component = component;
    }

    public RenderFailCondition(WebLocator component, int priority){
        this(component);
        setPriority(priority);
    }

    @Override
    public boolean execute() {
        return component.isElementPresent();
    }

    @Override
    public String toString() {
        return super.toString() + component;
    }

    @Override
    public WebLocator getComponent(){
         return component;
    }

    @Override
    public String getResultMessage() {
        return component.getHtmlText();
    }

}
