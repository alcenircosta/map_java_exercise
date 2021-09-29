package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {
	public static void main(String[] args)  {
		//C:\\temp\\in.txt
		Scanner sc = new Scanner(System.in);
		Map<String, Integer> votes = new HashMap<String, Integer>();
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();
		try (BufferedReader bf = new BufferedReader(new FileReader(path))){
			String line = bf.readLine();
			while(line!= null) {
				String[] fields = line.split(",");
				String name = fields[0];
				Integer votesQuantity = Integer.parseInt(fields[1]);
				if(votes.containsKey(name)) {
					int v = votes.get(name) + votesQuantity;
					votes.put(name, v);
				}else {
					votes.put(name, votesQuantity);
				}
				line = bf.readLine();
			}
			for(String key : votes.keySet()) {
				System.out.println(key + ": "+ votes.get(key));
			}
		}catch(Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
		
	}
}
