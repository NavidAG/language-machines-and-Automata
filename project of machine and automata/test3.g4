grammar test3;

stat : classification*
    ;

classification : 'class' ID '{' '}';
ID : ID_LETTER  (ID_LETTER | DIGIT)*;
fragment ID_LETTER : 'a'..'z'|'A'..'Z'|'_' ;
fragment DIGIT : '0'..'9' ;
WS : [ \t\r\n]+ -> skip ;