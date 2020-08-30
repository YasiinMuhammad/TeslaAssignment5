package com.teslasalesassignment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CsvReader {
	
	public List<SalesData> loadData (String fileName){
		List<SalesData> teslaData = new ArrayList<>();
		BufferedReader fileReader = null;
		try {
			fileReader = new BufferedReader(new FileReader(fileName));
			String line = fileReader.readLine();
			// String line = fileReader.read:ine(); reads one line.
			// In order to read multiple lines you need to put it in a while loop and loop through the data
//			System.out.println(line);
			while ((line = fileReader.readLine()) != null) { 
				String[] values = line.split(",");
				// split() splitting a String into its substrings and assigning the split values to ArrayList teslaData.add  
				teslaData.add(new SalesData(values[0], values[1]));
			}

		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + fileName.toString());
			
		} catch (IOException e) {
			System.out.println("Unable to read file: " + fileName.toString());
		}finally {
			if (fileReader != null)
				try {
					fileReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return teslaData;

	}
}
