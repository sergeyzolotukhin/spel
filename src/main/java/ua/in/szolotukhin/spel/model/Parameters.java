package ua.in.szolotukhin.spel.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class Parameters {
	private final List<Table> tables;

	public List<Row> rows(String tableName) {
		return table(tableName).getRows();
	}

	public static Parameters of(Table ... tables) {
		return new Parameters(Arrays.asList(tables));
	}

	// ================================================================================================================
	// private methods
	// ================================================================================================================

	private Table table(String name) {
		return tables.stream()
				.filter(table -> name.equals(table.getName()))
				.findFirst()
				.orElseThrow(() -> new IllegalStateException(String.format("Table [%s] not found", name)));
	}
}
