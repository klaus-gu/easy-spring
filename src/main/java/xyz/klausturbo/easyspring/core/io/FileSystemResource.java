package xyz.klausturbo.easyspring.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 文件系统的资源加载 .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public class FileSystemResource implements Resource {
    
    private final File file;
    
    private final String path;
    
    public FileSystemResource(String path) {
        this.file = new File(path);
        this.path = path;
    }
    
    @Override
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(this.file);
    }
    
    public String getPath() {
        return path;
    }
}
