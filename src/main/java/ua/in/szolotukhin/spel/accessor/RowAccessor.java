package ua.in.szolotukhin.spel.accessor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.TypedValue;
import org.springframework.lang.Nullable;
import ua.in.szolotukhin.spel.model.Parameters;
import ua.in.szolotukhin.spel.model.Row;

import java.util.List;
import java.util.Objects;

@Slf4j
public class RowAccessor extends AbstractAccessor {
	@Override
	public Class<?>[] getSpecificTargetClasses() {
		return new Class[]{Parameters.class};
	}

	@Override
	public boolean canRead(EvaluationContext context, @Nullable Object target, String name) {
		Parameters parameters = (Parameters) Objects.requireNonNull(context.getRootObject().getValue());
		return Objects.nonNull(parameters.rows(name));
	}

	@Override
	public TypedValue read(EvaluationContext context, @Nullable Object target, String name) {
		Parameters parameters = (Parameters) Objects.requireNonNull(context.getRootObject().getValue());

		List<Row> rows = parameters.rows(name);

		return new TypedValue(rows, TypeDescriptor.forObject(rows));
	}
}
