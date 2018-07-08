package com.demo.calc;

import java.util.*;

class Calc {
  private Lexer lexer;
  private CalcStack stack;
  private Queue<Token> rpnNotation;
  
  Calc(String expression) throws Exception {
    lexer = new Lexer(expression);
    stack = new CalcStack();
    rpnNotation = new LinkedList<Token>();
  }
  
  Double evaluate() throws Exception {
    convertToRPN();
    return process();
  }
  
  private Double process() throws Exception {
    CalcStack tempStack = new CalcStack();
    Token token = null;
    
    while(!rpnNotation.isEmpty()) {
      token = rpnNotation.poll();
    //while((Token token = rpnNotation.poll()) != null) {
      if(token instanceof Number) {
        tempStack.push(token);
      }
      else if(token instanceof Operator) { // FIXIT !!
//        java.lang.Number[] arg = tempStack.pop(((Operator)token).getOperatorAcceptableArgs());
//        tempStack.push(((Operator)token).execute(arg));
        
//        Util.log("Calc::process - executing: " + token.getType() + "(" + Arrays.toString(arg) + ") = " + ((Number)tempStack.peek()).getValue());
      }
      else if(token instanceof Function) { // FIXIT !!
//        Number[] arg = tempStack.pop(((Function)token).getOperatorAcceptableArgs());
//        tempStack.push(((Function)token).execute(arg));

//        Util.log("Calc::process - executing: " + token.getType() + "(" + Arrays.toString(arg) + ") = " + ((Number)tempStack.peek()).getValue());
      }
    }
    
    return ((Number)tempStack.pop()).getValue();
  }
  
  private void convertToRPN() throws Exception {
    lexer.tokenize();
    Iterator iterator = lexer.getIterator();
    while(iterator.hasNext()) {
      Token token = (Token)iterator.next();
     
      // Je�li symbol jest liczb�
      if(token instanceof Number) {
        // dodaj go do kolejki wyj�cie
        rpnNotation.add(token);
      }
      // Je�li symbol jest funkcj�
      else if(token instanceof Function) {
        // w�� go na stos.
        stack.push(token);
      }
      // Je�li symbol jest znakiem oddzielaj�cym argumenty funkcji (np. przecinek):
      else if(token instanceof Coma) {
        // Dop�ki najwy�szy element stosu nie jest lewym nawiasem,
        while(!(stack.peek() instanceof L_Brace)) {
          // zdejmij element ze stosu i dodaj go do kolejki wyj�cie.
          rpnNotation.add((Token)stack.pop());
        }
        // Je�li lewy nawias nie zosta� napotkany oznacza to, 
        // �e znaki oddzielaj�ce zosta�y postawione w z�ym miejscu lub nawiasy s� �le umieszczone.
        if(!(stack.peek() instanceof L_Brace)) {
          throw new Exception("Missing left bracket in expression");
        }
      }
      // Je�li symbol jest operatorem, o1
      else if(token instanceof Operator) {
        // 1) dop�ki na g�rze stosu znajduje si� operator, o2 taki, �e:
        Operator t = (Operator) token;
        Object stackTop = stack.peek();
        if(stackTop != null && stackTop instanceof Operator) {
          int priority = ((Operator)stackTop).priority();
          //o1 jest ��czny lub lewostronnie ��czny i jego kolejno�� wykonywania jest mniejsza lub r�wna kolejno�ci wyk. o2, lub
          boolean test1 = (t.associativity() == "both" || t.associativity() == "left") && (t.priority() <= priority);
          //o1 jest prawostronnie ��czny i jego kolejno�� wykonywania jest mniejsza od o2,
          boolean test2 = (t.associativity() == "right") && (t.priority() < priority);
          if(test1 || test2) {
            // zdejmij o2 ze stosu i do�� go do kolejki wyj�ciowej;
            rpnNotation.add((Token)stack.pop());
          }
        }
        // 2) w�� o1 na stos operator�w.
        stack.push(token);
      }
      // Je�eli symbol jest lewym nawiasem
      else if(token instanceof L_Brace) {
        // to w�� go na stos.
        stack.push(token);
      }
      
      // Je�eli symbol jest prawym nawiasem
      else if(token instanceof R_Brace) {
        boolean leftBracketExists = false;
        Object operator;
        while(!stack.empty()) {
          operator = stack.pop();
          // dop�ki symbol na g�rze stosu nie jest lewym nawiasem,
          if(operator instanceof L_Brace) {
            leftBracketExists = true;
            break;
          }
          // to zdejmuj operatory ze stosu i dok�adaj je do kolejki wyj�cie
          else {
            rpnNotation.add((Token)operator);
          }
        }

        // Teraz, je�li najwy�szy element na stosie jest funkcj�, tak�e do�� go do kolejki wyj�cie.
        if(stack.peek() instanceof Function) {
          rpnNotation.add((Token)stack.pop());
        }

        // Je�li stos zostanie opr�niony i nie napotkasz lewego nawiasu, oznacza to, �e nawiasy zosta�y �le umieszczone.
        if(stack.empty() && !leftBracketExists) {
          throw new Exception("Missing left bracket in expression");
        }
      }
      
      Util.log("Calc::convertToRPN - processing token: " + token + " Stack: " + stack + " RPN: " + rpnNotation);
    }
    // Je�li nie ma wi�cej symboli do przeczytania, zdejmuj wszystkie symbole ze stosu (je�li jakie� s�) i dodawaj je do kolejki wyj�cia.
    Object operator;
    while(!stack.empty()) {
      operator = stack.pop();
      // Powinny to by� wy��cznie operatory, 
      // je�li natrafisz na jaki� nawias, znaczy to, �e nawiasy zosta�y �le umieszczone.
      if(operator instanceof Brace) {
        throw new Exception("Mismatched brackets in expression");
      }
      rpnNotation.add((Token)operator);
    }
    
    Util.log("Calc::convertToRPN - RPN notation: " + rpnNotation);
  }
}