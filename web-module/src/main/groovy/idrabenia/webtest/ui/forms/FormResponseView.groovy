package idrabenia.webtest.ui.forms

import org.springframework.web.servlet.view.AbstractView
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.springframework.validation.BindingResult
import org.springframework.validation.FieldError
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.web.servlet.support.BindStatus
import org.springframework.web.servlet.support.RequestContext

/**
 * 
 * @author Ilya Drabenia
 * @since 27.01.13
 */
class FormResponseView extends AbstractView {

    FormResponseView() {
        setContentType('text/json;charset=utf-8')
    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object> stringObjectMap, HttpServletRequest httpServletRequest,
                                           HttpServletResponse httpServletResponse) {
        BindingResult binding = (BindingResult) stringObjectMap.get('binding');

        def json
        if (binding.hasErrors()) {
            json = [result: 'failed', errors: []]
            for (FieldError curError : binding.getFieldErrors()) {
                //BindStatus status = new BindStatus(new RequestContext(httpServletRequest), curError.field, true);
                json.errors << [field: "[name='${curError.field}']".toString(), message: resolveErrorCode(curError)]
            }
        } else {
            json = [result: 'ok']
        }

        ObjectMapper mapper = new ObjectMapper();
        def jsonString = mapper.writeValueAsString(json);

        httpServletResponse.setContentType(getContentType());
        httpServletResponse.getWriter().append(jsonString);
    }

    private String resolveErrorCode(FieldError error) {
        final NOT_FOUND_KEY = '^MESSAGE$NOT%FOUND^'

        def resultMessage = error.codes
                .collect { getMessageSourceAccessor().getMessage(it, error.arguments, NOT_FOUND_KEY) }
                .find {it != NOT_FOUND_KEY}
        resultMessage ?: error.defaultMessage
    }

}
