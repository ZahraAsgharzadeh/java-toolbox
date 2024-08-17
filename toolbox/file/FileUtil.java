package toolbox.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtil {

    public void save(byte[] file, String path, String fileName) {

        try {

            Path fullPath = Paths.get(path, fileName);

            Path directory = fullPath.getParent();

            if (directory != null) {

                Files.createDirectories(directory);
            }

            Files.write(fullPath, file);
        } catch (IOException e) {

            throw new RuntimeException(e);
        }
    }

    public void delete(String path, String fileName) {

        Path fullPath = Paths.get(path, fileName);

        try {

            Files.delete(fullPath);
        } catch (IOException e) {

            throw new RuntimeException(e);
        }
    }

    public void deleteDirectory(File file) {

        File[] contents = file.listFiles();

        if (contents != null) {
            for (File f : contents) {
                if (! Files.isSymbolicLink(f.toPath())) {
                    deleteDirectory(f);
                }
            }
        }

        file.delete();
    }
}