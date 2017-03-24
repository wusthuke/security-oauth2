package org.huke.oauth.cxf.security.server.core.expression;

/**
 * @author huke
 * @create 2017/3/24
 */
public interface Matcher {

    boolean matcher(Expression expression, String value);

}
