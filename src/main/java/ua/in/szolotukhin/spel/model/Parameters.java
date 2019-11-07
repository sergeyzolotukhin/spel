package ua.in.szolotukhin.spel.model;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Getter
@Builder
@RequiredArgsConstructor
public class Parameters {
	private final List<Table> tables;

	public static class ParametersBuilder {
		public ParametersBuilder tables(Table ... tables) {
			this.tables = Arrays.asList(tables);
			return this;
		}
	}

	public static Parameters of(Table ... tables) {
		return new Parameters(Arrays.asList(tables));
	}
}
