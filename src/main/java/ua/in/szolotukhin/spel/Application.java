package ua.in.szolotukhin.spel;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
public class Application {
    public static void main(String[] args) {


        Parameters parameters = Parameters.builder()
                .tables(Arrays.asList(
                        new Table("T1", "T 1 description"),
                        new Table("T2", "T 2 description"),
                        new Table("T3", "T 3 description")))
                .build();

        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setVariable("parameters", parameters);


        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("#parameters.getTableByName('T1')?.description");
        String value = (String) exp.getValue(context);

        log.info("Expression evaluation: {}", value);
    }

    @Builder
    private static class Parameters {
        private final List<Table> tables;

        public Table getTableByName(String name) {
            return tables.stream()
                    .filter(table -> name.equals(table.getName()))
                    .findFirst()
                    .orElse(null);
        }
    }

    @Getter
    @RequiredArgsConstructor(staticName = "of")
    private static class Table {
        private final String name;
        private final String description;
    }
}
