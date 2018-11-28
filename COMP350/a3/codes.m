for i = 1:10
    A = hilb(10);
    X_t = randn(10,5);
    B = A * X_t;

    [L, U, P] = lupp(A);
    y = inv(L) * P * B;
    X_c = inv(U) * y;

    ii_1 = norm( (X_c - X_t), 'fro') / norm(X_t, 'fro');
    ii_2 = eps * norm( A, 'fro') * norm( inv(A), 'fro');
    iii_1 = norm( (B - A * X_c), 'fro') / (norm(A, 'fro') * norm(X_c, 'fro'));

    fprintf("No %d:\n", i);
    fprintf("ii_1 is %e\n", ii_1);
    fprintf("ii_2 is %e\n", ii_2);
    fprintf("iii_1 is %e\n", iii_1);
    fprintf("iii_2 is %e\n", eps);
end

Hilb = hilb(5);
Id = eye(5);

[L, U, P] = lupp(Hilb);
inverse = zeros(5,5);
for j=1:5
    bcol = Id(:,j);
    y = inv(L) * P * bcol;
    column = inv(U) * y;
    inverse(:,j) = column;
end
disp(inverse);

function [L, U, P] = lupp(A)
%lupp.m LU factorization with partial pivoting
% input:  A is an n x n nonsingular matrix
% output: Unit lower triangular L, upper triangular U,
% permutation matrix P  such that PA = LU
n = size(A,1);
P = eye(n);
for k = 1:n-1
    [maxval, maxindex] = max(abs(A(k:n,k)));
    q = maxindex + k - 1;
    if maxval == 0, error('A is singular'), end
    A([k,q],:) = A([q,k],:);
    P([k,q],:) = P([q,k],:);
    i = k+1:n;
    A(i,k) = A(i,k)/A(k,k);
    A(i,i) = A(i,i) - A(i,k)*A(k,i);
end
L = tril(A,-1) + eye(n);
U = triu(A);
end