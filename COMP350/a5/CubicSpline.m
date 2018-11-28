X = (1900:10:2000)';
Y = [75.9950 91.9720 105.7110 123.2030 131.6690 150.6970 ...
     179.3230 203.2120 226.5050 249.6330 281.422]';

plot(X, Y, 'bo');
axis([1900 2010 0 400]);
title('Population of the U.S. 1900-1990');
ylabel('Millions');
hold on

% hardcoding to define size
% n = 11 in this case, as we count from 1
H = zeros(1, 11);
B = zeros(1, 11);
U = zeros(1, 11);
V = zeros(1, 11);
Z = zeros(1, 11);

for i = 1:10
    H(i) = X(i+1) - X(i);
    B(i) = (Y(i+1) - Y(i)) / H(i);
end

% forward elimination
% be careful, index begins at 1
U(2) = 2 * (H(1) + H(2));
V(2) = 6 * (B(2) - B(1));

for i = 3:10
    mult = H(i-1) / U(i-1);
    U(i) = 2 * (H(i-1) + H(i)) - mult * H(i-1);
    V(i) = 6 * (B(i) - B(i-1)) - mult * V(i-1);
end

% back substitution
Z(11) = 0;
for i = 10:-1:2
    Z(i) = (V(i) - H(i)*Z(i+1))/U(i);
end
Z(1) = 0;
% i = 10
a = Y(10);
b = -H(10).*Z(11)/6-H(10).*Z(10)/3+(Y(11)-Y(10))/H(10);
c = Z(10)/2;
d = (Z(11)-Z(10))/(6*H(10));
x = 1880:1:2020;
y = a+(x-X(10)).*(b+(x-X(10)).*(c+d.*(x-X(10))));
plot(x,y); % the func graph

%estimation for 1985 and 2010
q1 = a+(1985-X(10)).*(b+(1985-X(10)).*(c+d.*(1985-X(10))));
q2 = a+(2010-X(10)).*(b+(2010-X(10)).*(c+d.*(2010-X(10))));
%make this estimation 
plot(1985,q1,'ro');
plot(2010,q2,'ro'); % two estimations in red
hold off