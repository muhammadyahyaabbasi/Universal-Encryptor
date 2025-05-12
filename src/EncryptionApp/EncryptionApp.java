package EncryptionApp;

import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.*;
import java.util.Base64;

public class EncryptionApp extends Application {
    private SecretKey secretKey;
    private TextArea textInput;
    private Label statusLabel;

    @Override
    public void start(Stage primaryStage) throws Exception {
        generateKey();
        
        Label label = new Label("Enter text to encrypt/decrypt:");
        textInput = new TextArea();
        textInput.setPromptText("Enter text here...");
        Button encryptButton = new Button("Encrypt Text");
        Button decryptButton = new Button("Decrypt Text");
        Button encryptFileButton = new Button("Encrypt File");
        Button decryptFileButton = new Button("Decrypt File");
        statusLabel = new Label();

        encryptButton.setOnAction(e -> encryptText());
        decryptButton.setOnAction(e -> decryptText());
        encryptFileButton.setOnAction(e -> encryptFile(primaryStage));
        decryptFileButton.setOnAction(e -> decryptFile(primaryStage));

        VBox layout = new VBox(10, label, textInput, encryptButton, decryptButton, encryptFileButton, decryptFileButton, statusLabel);
        layout.setAlignment(Pos.CENTER);
        layout.setPrefSize(400, 400);
        
        primaryStage.setTitle("Encryption App");
        primaryStage.setScene(new Scene(layout));
        primaryStage.show();
    }

    private void generateKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        secretKey = keyGenerator.generateKey();
    }

    private void encryptText() {
        try {
            String text = textInput.getText();
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedBytes = cipher.doFinal(text.getBytes());
            textInput.setText(Base64.getEncoder().encodeToString(encryptedBytes));
            statusLabel.setText("Text encrypted successfully.");
        } catch (Exception e) {
            statusLabel.setText("Error encrypting text.");
        }
    }

    private void decryptText() {
        try {
            String encryptedText = textInput.getText();
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
            textInput.setText(new String(decryptedBytes));
            statusLabel.setText("Text decrypted successfully.");
        } catch (Exception e) {
            statusLabel.setText("Error decrypting text.");
        }
    }

    private void encryptFile(Stage stage) {
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select File to Encrypt");
            File file = fileChooser.showOpenDialog(stage);
            if (file != null) {
                byte[] fileData = readFile(file);
                Cipher cipher = Cipher.getInstance("AES");
                cipher.init(Cipher.ENCRYPT_MODE, secretKey);
                byte[] encryptedData = cipher.doFinal(fileData);
                writeFile(new File(file.getPath() + ".enc"), encryptedData);
                statusLabel.setText("File encrypted: " + file.getName() + ".enc");
            }
        } catch (Exception e) {
            statusLabel.setText("Error encrypting file.");
        }
    }

    private void decryptFile(Stage stage) {
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select File to Decrypt");
            File file = fileChooser.showOpenDialog(stage);
            if (file != null) {
                byte[] fileData = readFile(file);
                Cipher cipher = Cipher.getInstance("AES");
                cipher.init(Cipher.DECRYPT_MODE, secretKey);
                byte[] decryptedData = cipher.doFinal(fileData);
                writeFile(new File(file.getPath().replace(".enc", "_decrypted")), decryptedData);
                statusLabel.setText("File decrypted: " + file.getName().replace(".enc", "_decrypted"));
            }
        } catch (Exception e) {
            statusLabel.setText("Error decrypting file.");
        }
    }

    private byte[] readFile(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        byte[] data = fis.readAllBytes();
        fis.close();
        return data;
    }

    private void writeFile(File file, byte[] data) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(data);
        fos.close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
