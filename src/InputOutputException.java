import java.io.IOException;

public class InputOutputException extends IOException {
    public InputOutputException(IOException e) {
    }

    @Override
    public String getMessage() {
        return "Проблемы с чтением файла";
    }
}
