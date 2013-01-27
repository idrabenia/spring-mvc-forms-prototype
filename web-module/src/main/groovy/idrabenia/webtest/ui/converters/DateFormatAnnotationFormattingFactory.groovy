package idrabenia.webtest.ui.converters

import org.springframework.format.AnnotationFormatterFactory
import org.springframework.format.Printer
import org.springframework.format.Parser
import java.text.SimpleDateFormat

/**
 *
 * @author Ilya Drabenia
 * @since 27.01.13
 */
class DateFormatAnnotationFormattingFactory implements AnnotationFormatterFactory<DateFormat> {

    Set<Class<?>> getFieldTypes() {
        return [Date]
    }

    Printer<?> getPrinter(DateFormat a, Class<?> aClass) {
        return [print: {date, locale -> this.makeDateFormatter().format(date)}] as Printer
    }

    private SimpleDateFormat makeDateFormatter() {
        return new SimpleDateFormat("yyyy.dd.MM")
    }

    Parser<?> getParser(DateFormat a, Class<?> aClass) {
        return [parse: {string, locale -> this.makeDateFormatter().parse(string)}] as Parser
    }

}
