package files;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @AllArgsConstructor
public class FileInfo {
    private String fileName;
    private Long size;
    private String checkSum;

    @Override
    public String toString() {
        return
                "fileName=" + fileName +
                ", size=" + size +
                ", checkSum=" + checkSum ;
    }
}
