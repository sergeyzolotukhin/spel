package ua.in.szolotukhin.spel.model;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Builder
@RequiredArgsConstructor
public class Table {
	private final String name;
	private final String description;
	@Builder.Default
	private final List<Row> rows = new ArrayList<>();

	public static class TableBuilder {
		public TableBuilder rows(Row ... rows) {
			this.rows = Arrays.asList(rows);
			return this;
		}
	}

	public static Table of(String name, String description, Row... rows) {
		return new Table(name, description, Arrays.asList(rows));
	}
}
