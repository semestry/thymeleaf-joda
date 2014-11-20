package nl.eveoh.thymeleaf.joda.dialect;

import nl.eveoh.thymeleaf.joda.expression.JodaImpl;
import org.thymeleaf.context.IProcessingContext;
import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.dialect.IExpressionEnhancingDialect;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Thymeleaf dialect used to format Joda {@link org.joda.time.DateTime}, {@link org.joda.time.LocalDate}, and
 * {@link org.joda.time.LocalTime} objects in Thymeleaf pages.
 *
 * @author Marco Krikke
 */
public class JodaDialect extends AbstractDialect implements IExpressionEnhancingDialect {

    public static final String DEFAULT_PREFIX = "joda";

    public static final String JODA_EXPRESSION_OBJECT_NAME = "joda";

    public JodaDialect() {
        super();
    }

    public String getPrefix() {
        return DEFAULT_PREFIX;
    }

    @Override
    public Map<String, Object> getAdditionalExpressionObjects(IProcessingContext processingContext) {
        Locale locale = processingContext.getContext().getLocale();

        Map<String, Object> expressionObjects = new HashMap<String, Object>();
        expressionObjects.put(JODA_EXPRESSION_OBJECT_NAME, new JodaImpl(locale));

        return expressionObjects;
    }
}
