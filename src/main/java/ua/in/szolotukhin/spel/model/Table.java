package ua.in.szolotukhin.spel.model;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Getter
@Builder
@RequiredArgsConstructor(staticName = "of")
public class Table {
	private final String name;
	private final String description;
}
