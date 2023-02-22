import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		 Scanner in = new Scanner(System.in);
//		Scanner in = new Scanner(new File("Test5.txt"));
		HashMap<String, Character> map = new HashMap<>();
		int n = in.nextInt();
		String str = in.next();

		map.put("000000", 'A');
		map.put("001111", 'B');
		map.put("010011", 'C');
		map.put("011100", 'D');
		map.put("100110", 'E');
		map.put("101001", 'F');
		map.put("110101", 'G');
		map.put("111010", 'H');

		String[] list = new String[n];
		for (int i = 0; i < n; i++) {
			list[i] = str.substring(6 * i, 6 * i + 6);
		}

		char ch[] = new char[list.length];
		for (int i = 0; i < list.length; i++) {
			if (map.containsKey(list[i])) {
				ch[i] = map.get(list[i]);
			} else {
				boolean flag = false;
				for (int j = 0; j < list[i].length(); j++) {
					StringBuffer sb = new StringBuffer(list[i]);
					if (sb.charAt(j) == '0') {
						sb.setCharAt(j, '1');
					} else {
						sb.setCharAt(j, '0');
					}
					if (map.get(sb.toString()) != null) {
						ch[i] = map.get(sb.toString());
						flag = true;
						break;
					}
				}
				if (!flag) {
					System.out.println(i + 1);
					return;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ch.length; i++) {
			sb.append(ch[i]);
		}
		System.out.println(sb.toString());
	}
}