package edu.hw2.task1;

public record Addition(Expr first, Expr second) implements Expr {
    @Override
    public double evaluate() {
        return first.evaluate() + second.evaluate();
    }
}
