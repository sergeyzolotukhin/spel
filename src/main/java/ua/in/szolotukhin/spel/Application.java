package ua.in.szolotukhin.spel;

import lombok.extern.slf4j.Slf4j;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

@Slf4j
public class Application {
    public static void main(String[] args) {

        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setVariable("var", "Serhij Zolotukhin");

        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello World ' + #var");
        String message = (String) exp.getValue(context);

        log.info("Expression evaluation: {}", message);
    }
}
