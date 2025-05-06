import java.util.*; 

class HashToTree { 
	public static <K, V> Map<K, V> convertToTreeMap(Map<K, V> hashMap) 
	{ 
		Map<K, V> treeMap = new TreeMap<>(); 
		treeMap.putAll(hashMap); 
		return treeMap; 
	} 
	public static void main(String args[]) 
	{ 
		Map<String, String> hashMap = new HashMap<>();
		Scanner s=new Scanner(System.in);
         int n=s.nextInt();
         for(int i=0; i<n; i++)
                hashMap.put(s.next(),s.next());
		System.out.println("HashMap: " + hashMap);
		Map<String, String> treeMap = convertToTreeMap(hashMap);
		System.out.println("TreeMap: " + treeMap); 
	} 
}
