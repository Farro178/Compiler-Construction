grammer bp;

prog:	BEGIN stm* END;
stm:	ID ASSIGN expr SEMI			# AssignStm
		| WRITE LBR ID RBR SEMI		# WriteStm 
		| READ LBR ID RBR SEMI		# Readstm
		;



expr	expr op(AND | OR) expr		# BinOp
		| NEG expr					# NegOp
		| LBR expr RBR				# parens
		| BV						# boolV
		| ID						# id
		;

fragment Letter:	[a-zA-Z];
fragment Digit:		[0-9];
fragment Underscore	'_';

ASSIGN:	':=';
SEMI:	';';
WRITE   'write';
LBR:	'(';
RBR:	')';
READ:	'read';
AND:	'&';
OR:		'|';
NEG:	'~';
BEGIN:	'begin';
END:	'end';


BV:		'true' | 'false';
ID:		Letter(Letter | Digit | Underscore)*; 

WS:		[ \t\n\r]+ -> skip;