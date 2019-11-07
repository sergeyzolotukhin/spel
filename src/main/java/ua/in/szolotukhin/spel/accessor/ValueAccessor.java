package ua.in.szolotukhin.spel.accessor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.TypedValue;
import ua.in.szolotukhin.spel.model.Row;

import java.util.Objects;

@Slf4j
@SuppressWarnings("NullableProblems")
public class ValueAccessor  extends AbstractAccessor {
	@Override
	public Class<?>[] getSpecificTargetClasses() {
		return new Class[]{Row.class};
	}

	@Override
	public boolean canRead(EvaluationContext context, Object target, String name) {
		Row row = (Row) Objects.requireNonNull(context.getRootObject().getValue());
		return row.getColumns().containsKey(name);
	}

	@Override
	public TypedValue read(EvaluationContext context, Object target, String name) {
		Row row = (Row) Objects.requireNonNull(context.getRootObject().getValue());

		Object value = row.value(name);

		return new TypedValue(value, null);
	}
}
