package com.iluwatar.interpreter;

/**
 * MinusExpression.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class MinusExpression extends Expression {

private final Expression leftExpression;
private final Expression rightExpression;

public MinusExpression(Expression leftExpression, Expression rightExpression) {
this.leftExpression = leftExpression;
this.rightExpression = rightExpression;
  }

@Override
public int interpret() {
return leftExpression.interpret() - rightExpression.interpret();
  }

@Override
public String toString() {
return "-";
  }

}
