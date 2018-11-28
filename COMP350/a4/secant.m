function root = secant(fname,x_0,x_1,xtol,ftol,n_max,display)
n = 0;
fx_0 = feval(fname,x_0);
fx_1 = feval(fname,x_1);

if display
   disp('   n             x                    f(x)')
   disp('------------------------------------------------------')
   disp(sprintf('%4d %23.15e %23.15e', n, x_1, fx_1))
end

if abs(fx_1) <= ftol % check initial status
    root = x_1;
    return
end

for n = 1 : n_max
    d = ((x_1 - x_0) / (fx_1 - fx_0)) * fx_1;
    x_0 = x_1;
    fx_0 = fx_1;
    x_1 = x_1 - d;
	fx_1 = feval(fname,x_1);
    
    if display % same as newton sample code
        disp(sprintf('%4d %23.15e %23.15e', n, x_1, fx_1))
    end
    
    if abs(d) <= xtol || abs(fx_1) <= ftol
       root = x_1;
       return
    end
end

root = x_1;
    
    
    
        