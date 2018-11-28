X = (1900:10:2000)';
Y = [75.9950 91.9720 105.7110 123.2030 131.6690 150.6970 ...
     179.3230 203.2120 226.5050 249.6330 281.422]';

plot(X, Y, 'bo');
axis([1900 2010 0 400]);
title('Population of the U.S. 1900-1990');
ylabel('Millions');
hold on
% apply LS formula, m = 10 as there is no index issue
sumX = sum(X);
sumY = sum(Y);
sumXSq = sum(X.*X);
sumXY = sum(X.*Y);
a = (11 * sumXY - sumX * sumY) / (11 * sumXSq - sumX.^2);
b = (sumXSq * sumY - sumX * sumXY) / (11 * sumXSq - sumX.^2);

x = 1880:1:2020;
y = a * x + b;
plot(x,y); % the func graph

%estimation for 1985 and 2010
q1 = a * 1985 + b;
q2 = a * 2010 + b;
%make this estimation 
plot(1985,q1,'ro');
plot(2010,q2,'ro'); % two estimations in red
hold off