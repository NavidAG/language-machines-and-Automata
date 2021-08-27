grammar project1;

program :inclusion* stat* EOF ;
stat : classification
    | functionCode
    | function
    | COMMENT
    | LINE_COMMENT
    ;
functionCode : forloop
    | condition
    | whileloop
    | switchCase
    | variable SEMICOLON
    | iota
    | operations SEMICOLON
    ;
inclusion : ID '=' REQUIRE ID SEMICOLON
    | ID '=' FROM ID REQUIRE ID SEMICOLON
    ;

classification :  CLASS ID (EXTENDS ID)? '{' stat* '}'
    | CLASS ID EXTENDS ID implementation '{' stat* '}'
    ;

implementation : IMPLEMENTS (ID ',')* ID
    ;

variable : (CONST | LET)? VARIABLETYPE ('[' INT ']')? (initialization ',')* initialization
    | ID '=' operations ('['INT ':' INT']')?

    ;
iota: TYPE ID VARIABLETYPE CONST '(' (ID ID '=' operations) ID* ')' SEMICOLON;

initialization : (ID ('=' (ID|expresion))*) ('=' (INT | FLOAT | BOOL))?;
function:
    ID '=' '(' (VARIABLETYPE ('[' ']')? ID ',')* VARIABLETYPE ('[' ']')? ID ')' '=>' '{' functionCode* returnState functionCode* '}'
    | ID '=' '(' ')' '=>' '{' functionCode* returnState functionCode* '}'
    ;
functionCall: ID '(' ((operations ',')* operations|ID|INT|FLOAT|BOOL)? ')';

returnState: (RETURN operations SEMICOLON)?;
condition: IF '(' expresion ')' '{' functionCode* returnState functionCode* '}'
        (ELSEIF '(' expresion ')' '{' functionCode* returnState functionCode* '}')?
        (ELSE '{' functionCode* returnState functionCode* '}' )?
    ;
    //TODO
switchCase: SWITCH '(' expresion ')' '{' CASE (ID|INT|FLOAT|BOOL) ':' operations SEMICOLON (BREAK SEMICOLON)?
           (CASE (ID|INT|FLOAT|BOOL) ':' operations SEMICOLON (BREAK SEMICOLON)?)*
            (DEAFAULT ':' operations SEMICOLON)? '}'
    ;

forloop: FOR '(' ID IN INT':'INT STEP INT ')' '{' functionCode* '}'
    | FOR '(' AUTO ID IN ID ')' '{' functionCode* '}'
    ;
whileloop: WHILE '(' NOT? expresion ')' '{' functionCode* '}'
    ;
expresion: (ID|INT|FLOAT|BOOL)
    | NOT? operations
    | NOT? '(' operations ')'
    ;
operations:

     operations '**' operations
    | operations '~' operations
    | sign=('+'|'-') operations
    | operations op=('*'|'/'|'%'|'//') operations
    | operations op=('+'|'-') operations
    | operations '###' operations
    | operations op=('<<'|'>>') operations
    | operations op=('&'|'^'|'|') operations
    | operations COMPARISONOPERATION operations
    | operations SUPERIORITYOPERATION operations
    | operations ASSIGNMENTOPERATION operations
    | operations LOGICALOPERRATION operations
    | functionCall
    | INT
    | FLOAT
    | NOT? ID
    | NOT? BOOL
    | NOT? '(' operations ')'
    ;
BOOL: 'true' | 'false';
IN: 'in';
VARIABLETYPE : 'int' | 'float' | 'bool';
SEMICOLON : ';';
LOGICALOPERRATION: 'and' | 'or';
NOT: 'not';
COMPARISONOPERATION: '==' | '!=' | '<>' ;
SUPERIORITYOPERATION: '<'('=')? | '>'('=')?;
ASSIGNMENTOPERATION: '=' | '*=' | '**=' | '/=' | '//=' | '%=' | '+=' | '-=';
//LOGICALOPERRATION: '&&' | '||' | '==' | '!=' | '<'('=')? | '>'('=')?;
REQUIRE: 'require';
RETURN: 'return';
FROM: 'from';
STEP: 'step';
SWITCH: 'switch';
CASE: 'case';
BREAK: 'break';
TYPE: 'type';
DEAFAULT: 'default';
AUTO: 'auto';
EXTENDS: 'extends';
NULL: 'null';
CLASS: 'class';
IF: 'if';
ELSEIF: 'else if';
ELSE: 'else';
CONST: 'const';
LET: 'let';
IMPLEMENTS: 'implements';
FOR: 'for';
WHILE: 'while';
//ID : ([a-z]+ | [A-Z]+ | ([a-z] | [A-Z]) [0-9]+) ([a-z]+ | [A-Z]+ | [0-9]+)+;
ID : ID_LETTER (ID_LETTER | DIGIT) (ID_LETTER | DIGIT)*;
fragment ID_LETTER : 'a'..'z'|'A'..'Z'|'_' ;
fragment DIGIT : '0'..'9' ;
INT : DIGIT+ ;
FLOAT: DIGIT+ '.' DIGIT+ EXPONENT? | '.' DIGIT+ EXPONENT?;
EXPONENT : ('e'|'E') ('+'|'-')? ('0'..'9')+ ;
LINE_COMMENT : '//' .*? '\r'? '\n' -> skip ; // Match "//" stuff '\n'
COMMENT : '/*' .*? '*/' -> skip ; // Match "/*" stuff "*/"
//STRING : '"' .*? '"' ;
WS : [ \t\r\n]+ -> skip ;

