package com.teslasalesassignment;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class TeslaApplication {

	public static void main(String[] args) throws IOException {
		CsvReader reader = new CsvReader();

		List<SalesData> teslaDataModel3 = reader.loadData("model3.csv");
		List<SalesData> teslaDataModelS = reader.loadData("modelS.csv");
		List<SalesData> teslaDataModelX = reader.loadData("modelX.csv");

		showReport(teslaDataModel3, "Model 3");
		showReport(teslaDataModelS, "Model S");
		showReport(teslaDataModelX, "Model X");
	}

	private static void showReport(List<SalesData> teslaCarSales, String modelType) {
		Comparator<SalesData> minComparator = new Comparator<SalesData>() {
			@Override
			public int compare(SalesData o1, SalesData o2) {
				return o1.getSales().compareTo(o2.getSales());
			}
		};

		Optional<SalesData> minNumber = teslaCarSales.stream().min(minComparator);
		System.out.println("The worst month for " + modelType + " was: " + minNumber.get());

		Comparator<SalesData> maxComparator = new Comparator<SalesData>() {
			@Override
			public int compare(SalesData o1, SalesData o2) {
				return o1.getSales().compareTo(o2.getSales());
			}
		};

		Optional<SalesData> maxNumber = teslaCarSales.stream().max(maxComparator);
		System.out.println("The best month for " + modelType + " was: " + maxNumber.get());

		Map<Object, List<SalesData>> grouped = teslaCarSales.stream().map(x -> x)
				.collect(Collectors.groupingBy(x -> x.getDate().getYear()));
		grouped.entrySet().stream();

		String totalTeslaSales = grouped.entrySet().stream().map(
				x -> x.getKey() + " ->" + x.getValue().stream().collect(Collectors.summingInt(SalesData::getSales)))
				.collect(Collectors.joining("\n"));
		System.out.println(totalTeslaSales);
	}

}
