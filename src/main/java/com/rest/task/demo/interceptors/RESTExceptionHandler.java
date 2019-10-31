package com.rest.task.demo.interceptors;

import com.rest.task.demo.entities.applicationRelated.RestExceptionDBRelatedEntity;
import com.rest.task.demo.repositories.RestExceptionRepository;
import com.rest.task.demo.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.stream.Collectors;

import static com.rest.task.demo.configuration.Constants.POSTGRE_TEXT_DEFAULT_LENGTH;

/**
 * Created by Milen on 31.10.2019 г..
 */
public class RESTExceptionHandler extends AbstractHandlerExceptionResolver {

    @Autowired
    private RestExceptionRepository restExceptionRepository;

    @Override
    protected ModelAndView doResolveException(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            @Nullable Object o,
            Exception e) {

        String className = Exception.class.getName();
        try {

            Class<?> enclosingClass = e.getClass().getEnclosingClass();
            if (enclosingClass != null) {
                className = enclosingClass.getName();
            }

            String method = httpServletRequest.getMethod();
            String requestURL = httpServletRequest.getRequestURL().toString();
            String userPrincipal = httpServletRequest.getUserPrincipal().toString();
            String queryString = httpServletRequest.getQueryString();
            String requestBody = null;
            if ("POST".equalsIgnoreCase(method))
            {
                requestBody = httpServletRequest.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
            }

            StringBuilder sb = new StringBuilder();
            sb.append("method : ").append(method).append(System.lineSeparator());
            sb.append("requestURL : ").append(requestURL).append(System.lineSeparator());
            sb.append("userPrincipal : ").append(userPrincipal).append(System.lineSeparator());
            sb.append("queryString : ").append(queryString).append(System.lineSeparator());
            sb.append("requestBody : ").append(requestBody).append(System.lineSeparator());

            RestExceptionDBRelatedEntity logEntity = new RestExceptionDBRelatedEntity();
            logEntity.setExceptionName(StringUtils.Shrink(className, POSTGRE_TEXT_DEFAULT_LENGTH));
            logEntity.setExceptionMessage(StringUtils.Shrink(e.getMessage(), POSTGRE_TEXT_DEFAULT_LENGTH));
            logEntity.setRequest(StringUtils.Shrink(sb.toString(), POSTGRE_TEXT_DEFAULT_LENGTH));

            restExceptionRepository.saveAndFlush(logEntity);
        } catch (Exception ignored) {
        }
        ModelAndView model = new ModelAndView();
        model.setView(new MappingJackson2JsonView());
        model.addObject(className, e.getMessage());
        return model;
    }



}
