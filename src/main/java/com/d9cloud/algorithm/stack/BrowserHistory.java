package com.d9cloud.algorithm.stack;

import java.util.Stack;

/**
 * Description:
 *
 * @author 57439
 * @date Created on 2022/2/14
 */
public class BrowserHistory {

    private String currentPage;
    private int backSize;
    private Stack<String> backStack;
    private int forwardSize;
    private Stack<String> forwardStack;

    public BrowserHistory(String homepage) {
        this.currentPage = homepage;
        this.backSize = 0;
        this.backStack = new Stack<>();
        this.forwardSize = 0;
        this.forwardStack = new Stack<>();
    }

    public void visit(String url) {
        this.backStack.push(currentPage);
        this.currentPage = url;
        backSize++;
        this.forwardStack.clear();
        forwardSize = 0;
    }

    public String back(int steps) {
        if (backSize > steps) {
            for (int i = 0; i < steps; i++) {
                forwardStack.push(currentPage);
                currentPage = backStack.pop();
                backSize--;
                forwardSize++;
            }
        } else {
            for (int i = 0; i < backSize; i++) {
                forwardStack.push(currentPage);
                currentPage = backStack.pop();
                forwardSize++;
            }
            backSize = 0;
        }
        return currentPage;
    }

    public String forward(int steps) {
        if (forwardSize > steps) {
            for (int i = 0; i < steps; i++) {
                backStack.push(currentPage);
                currentPage = forwardStack.pop();
                forwardSize--;
                backSize++;
            }
        } else {
            for (int i = 0; i < forwardSize; i++) {
                backStack.push(currentPage);
                currentPage = forwardStack.pop();
                backSize++;
            }
            forwardSize = 0;
        }
        return currentPage;
    }

}
