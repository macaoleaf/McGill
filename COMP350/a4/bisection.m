function root = bisection(fname,a,b,delta,display)
% The bisection method.
%
% input:  fname is a string that names the function f(x).
%         a and b define an interval [a,b] and f(a)f(b) < 0
%         delta is the tolerance
%         display = 1 if step-by-step display is desired,
%                 = 0 otherwise
% output: root is the computed root of f(x)=0
%
fa = feval(fname,a); 
fb = feval(fname,b);
if sign(fa)*sign(fb) > 0
   disp('function has the same sign at at a and b')
   return
end
if fa == 0,
   root = a;
   return
end  
if fb == 0
   root = b;
   return
end
c = (a+b)/2;
fc = feval(fname,c);
e_bound = abs(b-a)/2;
if display, 
   disp(' ');
   disp('       a            b            c           f(c)      error_bound');
   disp(' ');
   disp([a b c fc e_bound])
end
while e_bound > delta
   if fc == 0, 
      root = c;
      return
   end   
   if sign(fa)*sign(fc) < 0  % There is a root in [a,c].
      b  = c; 
      fb = fc;
   else                      % There is a root in [c,b].
      a  = c; 
      fa = fc;
   end  
   c = (a+b)/2;
   fc = feval(fname,c);
   e_bound = e_bound/2;
   if display, disp([a b c fc e_bound]), end
end
root = c;


