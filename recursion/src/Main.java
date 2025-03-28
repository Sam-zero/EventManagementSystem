import java.util.Scanner;
public class Main {

    //1.Complexity: linear - O(N)
    public static int mini(int[] a, int n) {
        int min = a[0];
        for (int i = 0; i < n; i++) {
            if (a[i] < min) {
                min = a[i];
            }
        }
        return min;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(mini(a, n));
    }

    //2.Complexity: linear - O(N)
    public static double avarage(int[] a, int n) {
        double s = 0;
        for (int i = 0; i < n; i++) {
            s += a[i];
        }
        return s/n;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(avarage(a, n));
    }

    //3.Complexity: sublinear - O(sqrt(N))
    public static int prime(int n) {
        if (n < 2) return 0;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return 0;
            }
        }
        return 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (prime(n)==0) {
            System.out.println("Composite");
        }
        else {
            System.out.println("Prime");
        }
    }

    //4.Complexity: linear - O(N)
    public static int factorial(int n) {
        if (n <= 0) return 1;
        return factorial(n - 1) * n;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(factorial(n));
    }

    //5.Complexity: exponential - O(2^N)
    public static int fibonnacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonnacci(n - 1) + fibonnacci(n - 2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fibonnacci(n));
    }

    //6.Complexity: linear - O(B)
    public static int pow(int a, int b) {
        if (b == 0) return 1;
        return pow(a, b - 1) * a;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt();
        System.out.println(pow(a, b));
    }

    //8.Complexity: linear - O(N)
    public static int digit(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                return 0;
            }
        }
        return 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if (digit(str) == 1) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }

    //9.Complexity: exponential - O(2^N)
    public static int Ckn(int n, int k) {
        if (k == 0 || k == n) return 1;
        return Ckn(n - 1, k - 1) + Ckn(n - 1, k);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        System.out.println(Ckn(n,k));
    }

    //10.Complexity: logarithmic - O(log(min(A,B))
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt();
        System.out.println(gcd(a, b));
    }

}