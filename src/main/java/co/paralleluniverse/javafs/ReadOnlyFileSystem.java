package co.paralleluniverse.javafs;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.WatchService;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.nio.file.spi.FileSystemProvider;
import java.util.Set;

/**
 *
 * @author pron
 */
class ReadOnlyFileSystem extends FileSystem {
    private final FileSystem fs;
    private final FileSystemProvider provider;

    public ReadOnlyFileSystem(FileSystem fs) {
        this.fs = fs;
        this.provider = new ReadOnlyFileSystemProvider(fs.provider());
    }

    @Override
    public boolean isReadOnly() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
    @Override
    public FileSystemProvider provider() {
        return provider;
    }

    @Override
    public void close() throws IOException {
        fs.close();
    }

    @Override
    public boolean isOpen() {
        return fs.isOpen();
    }

    @Override
    public String getSeparator() {
        return fs.getSeparator();
    }

    @Override
    public Iterable<Path> getRootDirectories() {
        return fs.getRootDirectories();
    }

    @Override
    public Iterable<FileStore> getFileStores() {
        return fs.getFileStores();
    }

    @Override
    public Set<String> supportedFileAttributeViews() {
        return fs.supportedFileAttributeViews();
    }

    @Override
    public Path getPath(String first, String... more) {
        return fs.getPath(first, more);
    }

    @Override
    public PathMatcher getPathMatcher(String syntaxAndPattern) {
        return fs.getPathMatcher(syntaxAndPattern);
    }

    @Override
    public UserPrincipalLookupService getUserPrincipalLookupService() {
        return fs.getUserPrincipalLookupService();
    }

    @Override
    public WatchService newWatchService() throws IOException {
        return fs.newWatchService();
    }
}
