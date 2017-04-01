import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//Longest Increasing Subsequence
public class LIS {
	public static void main(String args[]) throws FileNotFoundException {
		InputReader in = new InputReader(System.in);
		OutputStream outputStream = System.out;
		PrintWriter out = new PrintWriter(outputStream);
		StringBuilder sb = new StringBuilder();
		// ----------My Code----------

		int n = in.nextInt();
		int arr[] = in.nextIntArray(n, 0);

		dpImplementation(n, arr);
		bsBasedImplementation(n,arr);
		// ---------------The End------------------

		out.close();
	}
	//O(n2)
	public static void dpImplementation(int n, int arr[]) {
		int lis[] = new int[n];
		Arrays.fill(lis, 1);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j])
					lis[i] = max(lis[i], lis[j] + 1);
			}
		}

	}
	//(O(nlogn))
	public static int bsBasedImplementation(int n, int arr[]) {

		int tailTable[] = new int[n];
		int len = 1;
		tailTable[0] = arr[0];

		for (int i = 0; i < n; i++) {
			if (arr[i] < tailTable[0])
				tailTable[0] = arr[i];
			else if (arr[i] > tailTable[len - 1]) {
				tailTable[len++] = arr[i];
			} else {
				int index = ceilIndex(arr, arr[i], len, arr[i]);
				tailTable[index] = arr[i];
			}
		}
		return len;
		//tailTable gives the seq .. but do check
	}

	// upperboundBS
	public static int ceilIndex(int arr[],int l,int r,int key) {

		while (r - l > 1)
        {
            int mid = l + (r - l)/2;
            if (arr[mid]>=key)
                r = mid;
            else
                l = mid;
        }
		return r;
	}

	// ---------------Extra Methods------------------

	public static long pow(long x, long n, long mod) {
		long res = 1;
		x %= mod;
		while (n > 0) {
			if (n % 2 == 1) {
				res = (res * x) % mod;
			}
			x = (x * x) % mod;
			n /= 2;
		}
		return res;
	}

	public static boolean isPal(String s) {
		for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
			if (s.charAt(i) != s.charAt(j))
				return false;
		}
		return true;
	}

	public static String rev(String s) {
		StringBuilder sb = new StringBuilder(s);
		sb.reverse();
		return sb.toString();
	}

	public static long gcd(long x, long y) {
		if (x % y == 0)
			return y;
		else
			return gcd(y, x % y);
	}

	public static int gcd(int x, int y) {
		if (x % y == 0)
			return y;
		else
			return gcd(y, x % y);
	}

	public static long gcdExtended(long a, long b, long[] x) {

		if (a == 0) {
			x[0] = 0;
			x[1] = 1;
			return b;
		}
		long[] y = new long[2];
		long gcd = gcdExtended(b % a, a, y);

		x[0] = y[1] - (b / a) * y[0];
		x[1] = y[0];

		return gcd;
	}

	public static int abs(int a, int b) {
		return (int) Math.abs(a - b);
	}

	public static long abs(long a, long b) {
		return (long) Math.abs(a - b);
	}

	public static int max(int a, int b) {
		if (a > b)
			return a;
		else
			return b;
	}

	public static int min(int a, int b) {
		if (a > b)
			return b;
		else
			return a;
	}

	public static long max(long a, long b) {
		if (a > b)
			return a;
		else
			return b;
	}

	public static long min(long a, long b) {
		if (a > b)
			return b;
		else
			return a;
	}
	// ---------------Extra Methods------------------

	public static void debug(Object... o) {
		System.out.println(Arrays.deepToString(o));
	}

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream inputstream) {
			reader = new BufferedReader(new InputStreamReader(inputstream));
			tokenizer = null;
		}

		public String nextLine() {
			String fullLine = null;
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					fullLine = reader.readLine();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
				return fullLine;
			}
			return fullLine;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public char nextChar() {
			return next().charAt(0);
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public int[] nextIntArray(int n, int f) {
			if (f == 0) {
				int[] arr = new int[n];
				for (int i = 0; i < n; i++) {
					arr[i] = nextInt();
				}
				return arr;
			} else {
				int[] arr = new int[n + 1];
				for (int i = 1; i < n + 1; i++) {
					arr[i] = nextInt();
				}
				return arr;
			}
		}

		public long[] nextLongArray(int n, int f) {
			if (f == 0) {
				long[] arr = new long[n];
				for (int i = 0; i < n; i++) {
					arr[i] = nextLong();
				}
				return arr;
			} else {
				long[] arr = new long[n + 1];
				for (int i = 1; i < n + 1; i++) {
					arr[i] = nextLong();
				}
				return arr;
			}

		}

		public double[] nextDoubleArray(int n, int f) {
			if (f == 0) {
				double[] arr = new double[n];
				for (int i = 0; i < n; i++) {
					arr[i] = nextDouble();
				}
				return arr;
			} else {
				double[] arr = new double[n + 1];
				for (int i = 1; i < n + 1; i++) {
					arr[i] = nextDouble();
				}
				return arr;
			}
		}

	}

	static class Pair implements Comparable<Pair> {
		int a, b;

		Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}

		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			if (this.a != o.a)
				return Integer.compare(this.a, o.a);
			else
				return Integer.compare(this.b, o.b);
		}

		public boolean equals(Object o) {
			if (o instanceof Pair) {
				Pair p = (Pair) o;
				return p.a == a && p.b == b;
			}
			return false;
		}

		public int hashCode() {
			return new Integer(a).hashCode() * 31 + new Integer(b).hashCode();
		}

	}

}
