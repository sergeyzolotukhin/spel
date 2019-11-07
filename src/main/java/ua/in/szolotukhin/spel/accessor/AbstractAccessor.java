package ua.in.szolotukhin.spel.accessor;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.PropertyAccessor;

@SuppressWarnings("NullableProblems")
abstract class AbstractAccessor implements PropertyAccessor {
	@Override
	public boolean canWrite(EvaluationContext context, Object target, String name) {
		throw new UnsupportedOperationException("Should not be called on an ParameterPropertyAccessor");
	}

	@Override
	public void write(EvaluationContext context, Object target, String name, Object newValue) {
		throw new UnsupportedOperationException("Should not be called on an ParameterPropertyAccessor");
	}
}
