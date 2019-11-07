package ua.in.szolotukhin.spel.model;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Getter
@Builder
public class Row {
	@Builder.Default
	private final Map<String, Object> columns = new LinkedHashMap<>();

	public Object getValue(String columnName) {
		return columns.get(columnName);
	}

	public static class RowBuilder {
		public RowBuilder columns(Object... args) {
			this.columns = createColumns(args);
			return this;
		}
	}

	public static Row of(Object ... args) {
		return new Row(createColumns(args));
	}

	private static Map<String, Object> createColumns(Object ... args) {
		Assert.notNull(args, "Args should be not null");
		Assert.isTrue(args.length % 2 == 0, "Args should be even");

		Map<String, Object> columns = new LinkedHashMap<>();

		for (int i = 0; i < args.length - 1; i++) {
			String key = (String) args[i];
			Object value = args[i + 1];

			columns.put(key, value);
		}

		return columns;
	}
}
