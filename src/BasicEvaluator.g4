grammar BasicEvaluator ;

prog      : input+ ;
input     : expression                                                            # expressionInput
          | fundef                                                                # funDefInput
          ;
fundef    : LPAREN DEFINE function arglist expression RPAREN ;
arglist   : LPAREN variable* RPAREN ;
expression: value                                                                 # valueExpr
          | variable                                                              # variableExpr
          | LPAREN IF expression expression expression RPAREN                     # ifExpr
          | LPAREN WHILE expression expression RPAREN                             # whileExpr
          | LPAREN SET variable expression RPAREN                                 # setExpr
          | LPAREN BEGIN expression+ RPAREN                                       # beginExpr
          | LPAREN function expression* RPAREN                                    # functionExpr
          | LPAREN op=('+'|'-'|'*'|'/'|'='|'<'|'>') expression expression RPAREN  # optrExpr
          | LPAREN PRINT expression RPAREN                                        # printExpr
          ;

value     : INTEGER ;
function  : NAME ;
variable  : NAME ;

ADD       : '+' ;
SUB       : '-' ;
MUL       : '*' ;
DIV       : '/' ;
EQ        : '=' ;
LT        : '<' ;
GT        : '>' ;
PRINT     : 'print' ;

LPAREN    : '(' ;
RPAREN    : ')' ;
DEFINE    : 'define' ;
IF        : 'if' ;
WHILE     : 'while' ;
SET       : 'set' ;
BEGIN     : 'begin' ;

INTEGER   : [-]? [0-9]+ ;
// NAME: match any sequence of characters not an integer nor containing blank, (, ), or ;
NAME      : ~[ ();\t\r\n]+ ;
WS        : [ \t\r\n]+ -> skip ;