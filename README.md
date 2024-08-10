//logic behind this function

//    Input: The function takes an array of strings (tokens), where each string is either an operand (a number) or an operator (+, -, *, /).
//    Stack-Based Evaluation:
//    It uses a stack to evaluate the expression.
//    Operands are pushed onto the stack.
//    When an operator is encountered, the function pops the required number of operands from the stack, applies the operator, and pushes the result back onto the stack.
//    Final Result: After processing all tokens, the stack should contain exactly one element, which is the result of the expression.
//    Example
//    Given the input arrayOf("-3", "-2", "*", "5", "+"), the evalRPN function:
//
//    Pushes -3.0 and -2.0 onto the stack.
//    Pops -2.0 and -3.0, Multiply them (6.0), and pushes the result onto the stack.
//    Pushes 5.0 onto the stack.
//    Pops 5.0 and 6.0, add them (11.0), and pushes the result onto the stack.
//    The final result is 11.0.
