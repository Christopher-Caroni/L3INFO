% Q11
schemaQ11([a,b,c,d,e,f,h,i]).
fdsQ11([ [[a,b],[c]], [[a],[d, e]],[[b],[f]] ,[[f],[g,h]] ,[[d],[i,j]] ]).

% returns in D a decomposition of R into BCNF.
% schemaQ11(R), fdsQ11(F), bcnf(R,F,D).
%Scheme to decompose = [a,b,c,d,e,f,g,h,i,j] Offending FD: [a]-->[d,e,i,j]
%Scheme to decompose = [a,b,c,f,g,h] Offending FD: [a,c,f]-->[g,h]
%Scheme to decompose = [a,b,c,f] Offending FD: [b]-->[f]
%Final Result is:
%[a,b,c]
%[a,d,e,i,j]
%[a,c,f,g,h]
%[b,f]

%R = [a, b, c, d, e, f, g, h, i|...],
%F = [[[a, b], [c]], [[a], [d, e]], [[b], [f]], [[f], [g, h]], [[d], [i, j]]],
%D = [[a, b, c], [a, d, e, i, j], [a, c, f, g, h], [b, f]]

% with new functional dependancies:
fdsQ11_2([ [[a,b],[c]], [[b,d],[e, f]],[[b],[f]] ,[[f],[g,h]] ,[[d],[i,j]] ]).
% returns in D a decomposition of R into BCNF.
% schemaQ11(R), fdsQ11_2(F), bcnf(R,F,D).

%schema(R), fdsq11_2(F), bcnf(R,F,D).
%Scheme to decompose = [a,b,c,d,e,f,g,h,i,j] Offending FD: [a,b]-->[c,f,g,h]
%Scheme to decompose = [a,b,d,e,i,j] Offending FD: [a,d]-->[i,j]
%Scheme to decompose = [a,b,d,e] Offending FD: [b,d]-->[e]
%Final Result is:
%[a,b,d]
%[a,b,c,f,g,h]
%[a,d,i,j]
%[b,d,e]

%R = [a, b, c, d, e, f, g, h, i|...],
%F = [[[a, b], [c]], [[b, d], [e, f]], [[b], [f]], [[f], [g, h]], [[d], [i, j]]],
%D = [[a, b, d], [a, b, c, f, g, h], [a, d, i, j], [b, d, e]] 

