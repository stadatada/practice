package practice.practice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KeitaiMessage3 {
	public static void main(String[] args) {
		String array[][] = {{".", ",", "!", "?", " "}, {"a","b","c"},
				{"d", "e", "f"}, {"g", "h", "i"}, {"j", "k", "l"},
				{"m", "n", "o"}, {"p", "q", "r", "s"}, {"t", "u", "v"},
				{"w", "x", "y", "z"}};
		try (BufferedReader br = new BufferedReader(new FileReader("inputkeitaiMessage.txt"))) {
			String data = null;
			while ((data = br.readLine()) != null) {

				Pattern pattern = Pattern.compile(".*0$");
				Matcher matcher = pattern.matcher(data);
				if (matcher.matches()) { // 以下から最後に０が記載される列のみ処理をおこなう
					ArrayList<Integer> list = makeIntList(data);
					for (int i = 0; i < list.size(); i++) {
						System.out.println(list.get(i));
					}

					char mozi;
					int count = 0;
					for (int i = 0; i < data.length(); i++) {
						if (!(list.get(i) == 0)) {
							count++;
						} else {
							System.out.println("mozi:" + list.get(i));
							System.out.println("count:" + count);
							System.out.println("point:" + list.get(i-1));
							System.out.println("array:" + array[(list.get(i-1)-1)][count - 1]);
							count = 0;
							if (i + 1 < data.length()) {
								mozi = data.charAt(i + 1);
							}
							/*
							String point = (String)data.charAt(i - 1);
							System.out.println(point);
							System.out.println(array[point][2 - 1]);

							count = 0;
							if (i + 1 < data.length()) {
								mozi = data.charAt(i + 1);
							}
							*/
						}
					}
				}
		}
		} catch (IOException e) {

		}
	}
	public static ArrayList<Integer> makeIntList(String st) {
		String[] array = st.split("");
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			int in = Integer.parseInt(array[i]);
			System.out.println("inforsoto:" + in);
			if (i == array.length -1) {
				list.add(in);
				break;
			}

			System.out.println("array[i]:" + array[i]);
			String a = array[i];
			System.out.println(a);
			if ("2" == "2") {
				System.out.println("同じ");
				//list.add(in);
				//System.out.println("in:" + in);
			}
		}
		return list;
	}
}
// 先頭の０をけすのはリストを再起的に
/*
 * 5
220
220
222220
44033055505550666011011111090666077705550301110
000555555550000330000444000080000200004440000
 */
