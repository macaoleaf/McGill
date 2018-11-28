function root = new(fname,fdname,fddname,x,xtol,ftol,n_max,display)
n = 0;
fx = feval(fname,x);
if display, 
   disp('   n             x                    f(x)')
   disp('------------------------------------------------------')
   disp(sprintf('%4d %23.15e %23.15e', n, x, fx))
end
if abs(fx) <= ftol
   root = x;
   return
end
for n = 1:n_max
    fdx = feval(fdname,x);
    fddx = feval(fddname, x);
    d = (fdx - sqrt(fdx .^ 2 - 2 * fddx * fx)) / fddx;
    x = x - d;
    fx = feval(fname,x);
    if display, 
       disp(sprintf('%4d %23.15e %23.15e', n, x, fx))
    end
    if abs(d) <= xtol | abs(fx) <= ftol
       root = x;
       return
    end
end
root = x;