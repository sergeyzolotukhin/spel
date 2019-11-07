package ua.in.szolotukhin.spel;

import lombok.extern.slf4j.Slf4j;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import ua.in.szolotukhin.spel.model.Parameters;
import ua.in.szolotukhin.spel.model.Table;

import java.util.Arrays;

@Slf4j
public class Application {
    public static void main(String[] args) {
        Parameters parameters = Parameters.builder()
                .tables(Arrays.asList(
                        Table.of("T1", "T 1 description"),
                        Table.of("T2", "T 2 description"),
                        Table.of("T3", "T 3 description")))
                .build();

        StandardEvaluationContext context = new StandardEvaluationContext(parameters);

        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("tables.^[name == 'T1'].description");
        String value = (String) exp.getValue(context);

        log.info("Expression evaluation: {}", value);
    }

}
