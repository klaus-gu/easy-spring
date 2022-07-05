package xyz.klausturbo.easyspring.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 资源 .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public interface Resource {
    
    InputStream getInputStream() throws IOException;
}
