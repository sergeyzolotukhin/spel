package ua.in.szolotukhin.spel.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.util.Assert;

import java.util.LinkedHashMap;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public class Row {
	private final Map<String, Object> columns;

	public Object getValue(String columnName) {
		return columns.get(columnName);
	}

	public static Row of(Object ... args) {
		return new Row(columns(args));
	}

	private static Map<String, Object> columns(Object ... args) {
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
