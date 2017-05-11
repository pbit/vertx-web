package io.vertx.ext.web.validation;

import io.vertx.codegen.annotations.Fluent;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.ext.web.validation.impl.HTTPRequestValidationHandlerImpl;

/**
 * An interface for add HTTP Request validation.
 * <br/>
 * You can assign multiple body type at the same time(for example a JSON schema together with a XML schema). This interface support:
 * <ul>
 *     <li>application/x-www-form-urlencoded</li>
 *     <li>multipart/form-data</li>
 *     <li>application/xml</li>
 *     <li>application/json</li>
 * </ul>
 * Also you can add a form parameter for validation without care about content type of your request. For form parameters this interface support both "multipart/form-data" and "application/x-www-form-urlencoded"
 * <br/>
 * This interface allow extra parameters in the request, so it doesn't care if in a request there's a parameter without a specified validation rule
 * <br/>
 * If a parameter is flagged as an array, it will be validated also if the size of array is 1 element
 * @author Francesco Guardiani @slinkydeveloper
 */
@VertxGen
public interface HTTPRequestValidationHandler extends ValidationHandler {

  static HTTPRequestValidationHandler create() { return new HTTPRequestValidationHandlerImpl(); }

  /**
   * Add a path parameter with included parameter types
   * @param parameterName expected name of parameter inside the path
   * @param type expected type of parameter
   * @param required true if parameter is required
   * @return this handler
   */
  @Fluent
  HTTPRequestValidationHandler addPathParam(String parameterName, ParameterType type, boolean required);

  /**
   * Add a path parameter with a custom pattern
   * @param parameterName expected name of parameter inside the path
   * @param pattern regular expression for validation
   * @param required true if parameter is required
   * @return this handler
   */
  @Fluent
  HTTPRequestValidationHandler addPathParamWithPattern(String parameterName, String pattern, boolean required);

  /**
   * Add a query parameter with included parameter types
   * @param parameterName expected name of parameter inside the query
   * @param type expected type of parameter
   * @param required true if parameter is required
   * @return this handler
   */
  @Fluent
  HTTPRequestValidationHandler addQueryParam(String parameterName, ParameterType type, boolean required);

  /**
   * Add a query parameter with a custom pattern
   * @param parameterName expected name of parameter inside the query
   * @param pattern regular expression for validation
   * @param required true if parameter is required
   * @return this handler
   */
  @Fluent
  HTTPRequestValidationHandler addQueryParamWithPattern(String parameterName, String pattern, boolean required);

  /**
   * Add a query parameters array with included parameter types
   * @param arrayName expected name of array inside the query
   * @param type expected type of parameter
   * @param required true if parameter is required
   * @return this handler
   */
  @Fluent
  HTTPRequestValidationHandler addQueryParamsArray(String arrayName, ParameterType type, boolean required);

  /**
   * Add a query parameters array with a custom pattern
   * @param arrayName expected name of array inside the query
   * @param pattern regular expression for validation
   * @param required true if parameter is required
   * @return this handler
   */
  @Fluent
  HTTPRequestValidationHandler addQueryParamsArrayWithPattern(String arrayName, String pattern, boolean required);

  /**
   * Add a header parameter with included parameter types
   * @param headerName expected header name
   * @param type expected type of parameter
   * @param required true if parameter is required
   * @return this handler
   */
  @Fluent
  HTTPRequestValidationHandler addHeaderParam(String headerName, ParameterType type, boolean required);

  /**
   * Add a header parameter with a custom pattern
   * @param headerName expected header name
   * @param pattern regular expression for validation
   * @param required true if parameter is required
   * @return this handler
   */
  @Fluent
  HTTPRequestValidationHandler addHeaderParamWithPattern(String headerName, String pattern, boolean required);

  /**
   * Add a single parameter inside a form with included parameter types
   * @param parameterName expected name of parameter inside the form
   * @param type expected type of parameter
   * @param required true if parameter is required
   * @return this handler
   */
  @Fluent
  HTTPRequestValidationHandler addFormParam(String parameterName, ParameterType type, boolean required);

  /**
   * Add a single parameter inside a form with a custom pattern
   * @param parameterName expected name of parameter inside the form
   * @param pattern regular expression for validation
   * @param required true if parameter is required
   * @return this handler
   */
  @Fluent
  HTTPRequestValidationHandler addFormParamWithPattern(String parameterName, String pattern, boolean required);

  /**
   * Add a form parameters array with included parameter types
   * @param parameterName expected name of array of parameters inside the form
   * @param type expected type of array of parameters
   * @param required true if parameter is required
   * @return this handler
   */
  @Fluent
  HTTPRequestValidationHandler addFormParamsArray(String parameterName, ParameterType type, boolean required);

  /**
   * Add a query parameters array with a custom pattern
   * @param parameterName expected name of array of parameters inside the form
   * @param pattern regular expression for validation
   * @param required true if parameter is required
   * @return this handler
   */
  @Fluent
  HTTPRequestValidationHandler addFormParamsArrayWithPattern(String parameterName, String pattern, boolean required);

  /**
   * Add a custom validator. For more informations about custom validator, see {@link CustomValidator}
   * @param customValidator
   * @return this handler
   */
  @Fluent
  HTTPRequestValidationHandler addCustomValidatorFunction(CustomValidator customValidator);

  /**
   * Add a json schema for body with Content-Type "application/json"
   * @param jsonSchema
   * @return this handler
   */
  @Fluent
  HTTPRequestValidationHandler addJsonBodySchema(String jsonSchema);

  /**
   * Add a xml schema for body with Content-Type "application/xml"
   * @param xmlSchema
   * @return this handler
   */
  @Fluent
  HTTPRequestValidationHandler addXMLBodySchema(String xmlSchema);

  /**
   * Add a required file name
   * @param filename name of the file inside the form
   * @return this handler
   */
  @Fluent
  HTTPRequestValidationHandler addRequiredFile(String filename);

}