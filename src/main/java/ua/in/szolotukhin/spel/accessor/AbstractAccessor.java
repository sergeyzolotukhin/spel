package ua.in.szolotukhin.spel.accessor;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.PropertyAccessor;
import org.springframework.lang.Nullable;

abstract class AbstractAccessor implements PropertyAccessor {
	@Override
	public boolean canWrite(EvaluationContext context, @Nullable Object target, String name) {
		throw new UnsupportedOperationException("Should not be called on an ParameterPropertyAccessor");
	}

	@Override
	public void write(EvaluationContext context, @Nullable Object target, String name, @Nullable Object newValue) {
		throw new UnsupportedOperationException("Should not be called on an ParameterPropertyAccessor");
	}
}
