import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
	
	static Scanner fs;
	
	public static void main(String[] args) {
		fs = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
		//T = fs.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = fs.nextInt();
			int m = fs.nextInt();
			char[][] a = new char[n][];
			for (int i = 0; i < n; i++) {
				a[i] = fs.next().toCharArray();
			}
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					max = Math.max(max, getTeamTopics(a[i], a[j]));
				}
			}
			int teams = 0;
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					if (getTeamTopics(a[i], a[j]) == max) {
						teams++;
					}
				}
			}
			out.println(max);
			out.println(teams);
		}
		fs.close();
		out.close();
	}
	
	static int getTeamTopics(char[] x, char[] y) {
		int count = 0;
		for (int i = 0; i < x.length; i++) {
			if (x[i] == '1' || y[i] == '1') {
				count++;
			}
		}
		return count;
	}
	
	static void sort(int[] a) {
		ArrayList<Integer> arr = new ArrayList<>();
		for (int x : a) {
			arr.add(x);
		}
		Collections.sort(arr);
		for (int i = 0; i < a.length; i++) {
			a[i] = arr.get(i);
		}
	}
	
	static int[] readArray(int n) {
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = fs.nextInt();
		}
		return a;
	}
}
