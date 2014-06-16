package nl.eveoh.thymeleaf.joda.dialect;

import nl.eveoh.thymeleaf.joda.expression.Joda;
import nl.eveoh.thymeleaf.joda.expression.JodaImpl;
import org.thymeleaf.context.IContext;
import org.thymeleaf.context.IProcessingContext;
import org.thymeleaf.context.IWebContext;
import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.dialect.IExpressionEnhancingDialect;

import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
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
        final IContext context = processingContext.getContext();
        final IWebContext webContext = (context instanceof IWebContext ? (IWebContext) context : null);

        final Map<String, Object> objects = new HashMap<>(1, 1.0f);

		/*
         * Create the #joda expression object
		 */
        if (webContext != null) {
            final HttpServletRequest request = webContext.getHttpServletRequest();

            if (request != null) {
                final Joda joda = new JodaImpl(request.getLocale());

                objects.put(JODA_EXPRESSION_OBJECT_NAME, joda);
            }

        }

        return objects;
    }
}
