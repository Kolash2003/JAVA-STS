import java.util.Scanner;

public class SubsetSum {
	static boolean isSubsetSum(int set[], int n, int sum){
		if (sum == 0)
			return true;
		if (n == 0)
			return false;
		if (set[n - 1] > sum)
			return isSubsetSum(set, n - 1, sum);
		return isSubsetSum(set, n - 1, sum) || isSubsetSum(set, n - 1, sum - set[n - 1]);
	}
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int sum = sc.nextInt();
		int set[]= new int[n];
		for(int i=0;i<n;i++)
			set[i]=sc.nextInt();
            if (isSubsetSum(set, n, sum) == true)
			System.out.println("yes");
		else
			System.out.println("no");
	}
}
