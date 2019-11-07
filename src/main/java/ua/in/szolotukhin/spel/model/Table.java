package ua.in.szolotukhin.spel.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class Table {
	private final String name;
	private final String description;
	private final List<Row> rows;

	public static Table of(String name, String description, Row... rows) {
		return new Table(name, description, Arrays.asList(rows));
	}
}
