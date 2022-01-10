# Basic Evaluator source code

The grammar for the programming language being implemented is in the file 
[BasicEvaluator.g4](BasicEvaluator.g4).

After any changes to the grammar file, the lexer and parser code needs to be 
rebuilt using the following command in Linux:

```
antlr4 -no-listener -visitor BasicEvaluator.g4
```

The command antlr4 is an alias in Linux set to:
```
java -jar /usr/local/lib/antlr-4.9.3-complete.jar
```

The antlr4 command will rebuild the Lexer and Parser, 
consisting of the following files:
- [BasicEvaluator.interp](BasicEvaluator.interp)
- [BasicEvaluator.tokens](BasicEvaluator.tokens)
- [BasicEvaluatorBaseVisitor.java](BasicEvaluatorBaseVisitor.java)
- [BasicEvaluatorLexer.java](BasicEvaluatorLexer.java)
- [BasicEvaluatorLexer.interp](BasicEvaluatorLexer.interp)
- [BasicEvaluatorLexer.tokens](BasicEvaluatorLexer.tokens)
- [BasicEvaluatorParser.java](BasicEvaluatorParser.java)
- [BasicEvaluatorVisitor.java](BasicEvaluatorVisitor.java)

The function main is located in the file [BasicEvaluator](BasicEvaluator.java).
This file contains the main Read-Eval-Print Loop which gets input from the user,
that consists of a set of lines containing one expression or function definition. 
The expressions or function definitions entered by the user are then parsed and
evaluated.  Expressions are evaluated to a single Integer value and displayed as
output.  Function definitions are then parsed and then added to list of function
definitions available to subsequent expressions entered, and its name is displayed 
as output.

The following files were created to implement the Interpreter:
- [BasicEvaluatorVisitorImpl.java](BasicEvaluatorVisitorImpl.java) - the 
implementation of the visitor which implements the main part of the Interpreter
- [BasicEvaluatorInfo.java](BasicEvaluatorInfo.java) - the class of the object that
is returned from each visitor function, consisting of either the name of the 
function definition or the value of the expression being evaluated 
- [Memory.java](Memory.java) - contains the collections of variable values for
both the global and local environments (as a stack), as well as the function 
definitions
- [ValueEnvironment.java](ValueEnvironment.java) - the class containing the Map of
variable names to values for a single environment
- [FunctionDefinition.java](FunctionDefinition.java) - the class containing a
function definition
- [Value.java](Value.java) - the class containing a value (an Integer)

To run the evaluator from the IntelliJ terminal, run the following command from
the **out/production/BasicEvaluator** folder, after building the project from
within the IDE:
```
java BasicEvaluator 
```

This will then display a prompt for the user to enter a function definition or
an expression to be evaluated.  The file [test01.lp](test01.lp) contains a set
of expressions and function definitions that can be entered at the prompt to 
test the Interpreter.