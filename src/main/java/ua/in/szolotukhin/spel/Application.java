package ua.in.szolotukhin.spel;

import lombok.extern.slf4j.Slf4j;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import ua.in.szolotukhin.spel.model.Parameters;
import ua.in.szolotukhin.spel.model.Row;
import ua.in.szolotukhin.spel.model.Table;

import java.util.List;

@Slf4j
@SuppressWarnings({"ConstantConditions", "unchecked"})
public class Application {
	public static void main(String[] args) {
		Parameters parameters = Parameters.of(
				Table.of("T1", "T 1 description",
						Row.of("C1", "Value 1",
								"C2", "Value 2",
								"C3", "Value 3"),
						Row.of("C1", "Value 4")),
				Table.of("T2", "T 2 description"),
				Table.of("T3", "T 3 description"));

		EvaluationContext context = new StandardEvaluationContext(parameters);

		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression("rows('T1')");
        List<Row> rows = (List<Row>) exp.getValue(context);

		StandardEvaluationContext ctx = new StandardEvaluationContext();

		for (Row row : rows) {
			ctx.setRootObject(row);
			ExpressionParser prs = new SpelExpressionParser();
			Expression exp1 = prs.parseExpression("value('C1')");
			Object value = exp1.getValue(ctx);

			log.info("Column value: {}", value);
		}
	}
}
