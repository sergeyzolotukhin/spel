package ua.in.szolotukhin.spel.model;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import ua.in.szolotukhin.spel.Application;

import java.util.List;

@Getter
@Builder
public class Parameters {
	private final List<Table> tables;
}
